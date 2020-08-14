	class Person {
		String name;
		String id;
		
		public Person(String name) {
			this.name = name;
		}
	}
	
	class Student extends Person{
		String grade;
		String department;
		
		public Student(String name) {
			super(name);
			
		}

	}
	
public class CastingPrac {

	public static void main(String[] args) {
		Person p1;
		Student s1 = new Student("hugh");
		p1 = s1;

		System.out.println(p1.name);
		
//		p1.grade = "a";
//		p1.department = "com";
		
		Person p2 = new Student("Zoe");
		Student s2;
		
		s2 = (Student) p2;
		System.out.println(s2.name);
		s2.grade = "a";
		System.out.println(s2.grade);
	}

}
