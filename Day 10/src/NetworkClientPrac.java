import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetworkClientPrac {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //server에서 정보 받기
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //server로 정보 보내기
			
			while (true) {
				System.out.print("Send>>");
				String outputMessage = sc.nextLine(); //keyboard에서 한 줄 읽기
				
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush(); //stream buffer에 남아있는 data 전송
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
				String inputMessage = in.readLine(); //server에서 한 줄 읽기
				System.out.println("Server : " + inputMessage);	
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sc.close();
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e2) {
				System.out.println("ERROR");
			}
		}

	}

}
