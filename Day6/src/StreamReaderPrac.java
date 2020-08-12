import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StreamReaderPrac {

	public static void main(String[] args) {

		InputStreamReader isr = null;
		FileInputStream fis = null;
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		
		try {
			fis = new FileInputStream("D:\\FileTest.txt");
			fw = new FileWriter("D:\\FileTest.txt");
			isr = new InputStreamReader(fis);
			int c;
			
			while(true) {
				String line = sc.nextLine();
				if(line.length() == 0) {
					break;
				}
				fw.write(line, 0, line.length());
				fw.write("\r\n", 0, 2);
			}
			fw.close();
//			System.out.println("encoder : " + isr.getEncoding());
			while((c = isr.read()) != -1) {
				System.out.print((char)c);
			}
			
			fis.close();
			isr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
