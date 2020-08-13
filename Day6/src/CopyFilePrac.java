import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFilePrac {

	public static void main(String[] args) {
		//¼÷Á¦
		File src = new File("C:\\Users\\USER\\Desktop\\makeRandomNumber.txt");
		
		File dest = new File("D:\\Java\\copy.txt");
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buff = new byte[1024*10];
			
			while(true) {
				int n = fi.read(buff);
				fo.write(buff, 0, n);
				if(n < buff.length) {
					break;
				}
			}
			
			fi.close();
			fo.close();
			System.out.println(src.getPath() + " is copyed to " + dest.getPath());
		} catch (IOException e) {
			
		}
	}

}
