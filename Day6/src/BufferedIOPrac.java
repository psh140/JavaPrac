import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedIOPrac {

	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("D:\\FileTest.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			
			while((c = fin.read()) != -1) {
				out.write(c);
			}
			
			new Scanner(System.in).nextLine();
			out.flush();
			fin.close();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
