import java.io.File;

public class FileReadPrac {

	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "의 서브리스트입니다.-----");
		
		File[] subFiles = dir.listFiles(); //디렉토리에 포함된 파일과 디렉토리 이름의 리스트 얻기
		
		for(int i = 0; i < subFiles.length; i++) { //subFiles 배열의 각 File에 대해 루프
			File f = subFiles[i];
			long t = f.lastModified(); //마지막 수정 시간
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length()); //파일크기
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t); //포맷 출력
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.length() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res = "";
		if(f1.isFile()) {
			res = "파일";
		} else if(f1.isDirectory()) {
			res = "디렉토리";
		}
		System.out.println(f1.getPath() +"은 " + res +"입니다.");
		
		File f2 = new File("D:\\java_sample");
		if(!f2.exists()) {
			f2.mkdir();
		}
		
		listDirectory(new File("D:\\"));
		f2.renameTo(new File("D:\\javasample"));
		
		listDirectory(new File("D:\\"));
		

	}

}
