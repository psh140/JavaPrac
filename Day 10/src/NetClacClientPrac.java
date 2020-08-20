import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetClacClientPrac {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				System.out.print("put number and +, - or * >> ");
				String outputMessage = sc.nextLine();			
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
				String inputMessage = in.readLine(); //server로부터 결과 수신
				System.out.println("Result : " + inputMessage);
				
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
