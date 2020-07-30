import java.util.Scanner;

public class Hello2030 {

	public static void main(String[] args) {
		/*
		 * int n = 2030;
		 * 
		 * System.out.println("헬로" + n);
		 */
//		final double PI = 3.141592;
//		
//		double radius = 10.0;
//		double circleArea = radius * PI;
//		
//		byte b = 127;
//		int i = 100;
//		
//		System.out.println(b+i);
//		System.out.println(10/4);
//		System.out.println(10.0/4);
//		System.out.println((char)0x12340041);
//		System.out.println((byte)(b+i));
//		System.out.println((int)2.9 + 1.8);
//		System.out.println((int)(2.9 + 1.8));
//		System.out.println((int)2.9 + (int)1.8);
//		
//		System.out.println("원의 면적 = " + circleArea);
//		
//		System.out.println("Put name, city, age, weight, married");
		Scanner scanner = new Scanner(System.in);

//		System.out.print("Put name : ");		
//		String name = scanner.next();
//
//		System.out.print("Put city : ");
//		String city = scanner.next();
//
//		System.out.print("Put age : ");	
//		int age = scanner.nextInt();
//
//		System.out.print("Put weight : ");		
//		double weight = scanner.nextDouble();
//
//		System.out.println("Put statement of marriage (true or false)");
//		boolean isMarried = scanner.nextBoolean();
//		if(isMarried == true) {
//			System.out.println("Name is " + name + ", " + "City is " + city + ", " + 
//					"Age is " + age + ", " + "Weight is " + weight + ", " + 
//					"And " + name + " is married.");	
//		} else {
//			System.out.println("Name is " + name + ", " + "City is " + city + ", " + 
//					"Age is " + age + ", " + "Weight is " + weight + ", " + 
//					"And " + name + " is single.");
//		}

		System.out.println("put constant : ");

		int time = scanner.nextInt();
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = (time / 60) / 60;

		System.out.println(time + " is " + hour + "h " + minute + "m " + second + "s.");
		scanner.close();

		int a = 3, b = 3, c = 3;

		a += 3;
		b *= 3;
		c %= 2;

		System.out.printf("%d, %d, %d \n", a, b, c);

		int d = 3;
		a = d++;
		System.out.printf("a = %d, d = %d\n", a, d);
		a = ++d;
		System.out.printf("a = %d, d = %d\n", a, d);
		a = d--;
		System.out.printf("a = %d, d = %d\n", a, d);
		a = --d;
		System.out.printf("a = %d, d = %d\n", a, d);

		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 <= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 != 2));

		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0));
		System.out.println((3 != 2) ^ (-1 > 0));

		a = 3;
		b = 5;
		System.out.println((a > b) ? (a - b) : (b - a));

	}

}
