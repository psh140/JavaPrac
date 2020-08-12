import java.util.HashMap;
import java.util.Scanner;

class Student {
	private int id;
	private String tel;
	
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
public class HashMapPrac {

	public static void main(String[] args) {

		HashMap<String, Student> map = new HashMap<String, Student>();
		map.put("박상혁", new Student(1, "+82-10-8930-0000"));
		map.put("hugh", new Student(2, "+64-21-136-9110"));
		map.put("zoe", new Student(3, "+64-21-176-7716"));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Put Name : ");
			String name = sc.nextLine();
			if(name.equals("exit")) {
				break;
			}
			
			Student student = map.get(name); //key인 이름을 불러와 객체를 검색
			if(student == null) {
				System.out.println("There is no person.");
			} else {
				System.out.println("id : " + student.getId() + ", telephone : " + student.getTel());
			}
		}
		sc.close();
	}

}
