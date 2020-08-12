import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryStreamPrac {

	public static void main(String[] args) {

//		byte[] b = { 1, 23, 4, 56, 22 };

		byte[] bout = new byte[10];
		
 		try {
//			FileOutputStream fout = new FileOutputStream("D:\\test.out");
//			for (int i = 0; i < b.length; i++) {
//				fout.write(b[i]);
//			}
			
//			for(byte i : b) {
//				fout.write(b);
//			}
//			fout.close();
			
			FileInputStream fin = new FileInputStream("D:\\test.out");
			int n = 0, c;
			while((c = fin.read()) != -1) {
				bout[n] = (byte)c;
				n++;
			}
			System.out.println("print");
			
			for(int i = 0; i < bout.length; i++) {
				System.out.print(bout[i] + " ");
			}
			System.out.println();
			fin.close();
			
		} catch (IOException e) {
			System.out.println("Fail.");
			return;
		}

	}

}
