import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;


public class NetCalcServerPrac {

	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp, " "); //spacebar 기준으로 데이터 분할
		if(st.countTokens() != 3) {
			return "ERROR";
		}
		
		// 받아들인 객체를 나눈 후 각자의 변수에 매칭
		String res = "";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		switch (opcode) {
			case "+":
				res = Integer.toString(op1 + op2);
				break;
			case "-":
				res = Integer.toString(op1 - op2);
				break;
			case "*":
				res = Integer.toString(op1 * op2);
				break;
			default : res = "ERROR";
		}
		return res;
	}
	
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("Wait Connect...");
			socket = listener.accept();
			System.out.println("Connect Success");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Client Disconnect");
					
					break;
				}
				System.out.println(inputMessage);
				String res = calc(inputMessage);
				out.write(res + "\n");
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(listener != null) {
					listener.close();
				}
			} catch (IOException e2) {
				System.out.println("ERROR");
			}
		}

	}

}
