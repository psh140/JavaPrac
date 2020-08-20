import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class NetworkServerPrac {

	public static void main(String[] args) {

		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("Waiting Connect...");
			socket = listener.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client에서 정보 받기
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //client로 정보 보내기
			while (true) {
				String inputMessage = in.readLine(); //client에서 한 줄 읽기
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("exit connect...");
					break;
				}
				
				System.out.println("Client : " + inputMessage);
				System.out.print("Send>>");
				String outputMessage = sc.nextLine(); //keyboard에서 한 줄 읽기
				out.write(outputMessage + "\n");
				out.flush(); //stream buffer에 남아있는 data 전송
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				socket.close();
				listener.close();
			} catch (IOException e2) {
				System.out.println("ERROR");
			}
		}
	}

}
