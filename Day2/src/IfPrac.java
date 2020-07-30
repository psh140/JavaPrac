import java.util.ArrayList;
import java.util.Scanner;

public class IfPrac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("put score(0~100) : ");
//		int score = sc.nextInt();
//		System.out.println("put year(1~4) : ");
//		int year = sc.nextInt();
//		
//		if (score >= 60) {
//			if(year != 4) {
//				System.out.println("Pass!");
//			} else if (score >= 70) {
//				System.out.println("Great!!");
//			} else {
//				System.out.println("Fail..");
//			}
//		} else {
//			System.out.println("Fail..");
//		}
//		
//		sc.close();
		
//		System.out.println("Which coffee do you want? ");
//		String order = sc.next();
//		Integer price = null;
//		
//		switch (order) {
//			case "espresso" :
//			case "cappuccino" :
//			case "latte" :
//				price = 3500;
//				break;
//			case "americano" :
//				price = 2000;
//				break;
//			default :
//				System.out.println("Sorry, We don't have it!");
//		}
//		if (price != null) {
//			System.out.println(order + " is " + price + " won.");
//		}
//		sc.close();
		
//		int count = 0;
//		int sum = 0;
//		for(int i = 1; i <= 10; i++) {
//			sum += i;
//			System.out.print(i);
//			if(i<=9) {
//				System.out.print("+");
//			} else {
//				System.out.print("=" + sum +"\n");
//			}
//		}
//		
//		sum = 0;
//		
//		System.out.println("put integers then put -1");
//		int n = sc.nextInt();
//		while(n != -1) {
//			sum += n;
//			count++;
//			n = sc.nextInt();
//		}
//		
//		if (count == 0) {
//			System.out.println("There is no integer.");
//		} else {
//			System.out.println("The quantity is " + count +", ");
//			System.out.println("The average is " + (double)sum/count + ".");
//		}
//		sc.close();
		
//		for(int i = 1; i < 10; i++) {
//			for(int j = 1; j < 10; j++) {
//				System.out.print(i + "*" + j + "=" + i*j + "\t");
//			}
//			System.out.println();
//		}
		
//		while(true) {
//			System.out.println("put number(if number is -1, exit) : ");
//			int number = sc.nextInt();
//			
//			if(number == -1) {
//				System.out.println("exit");
//				break;
//			}
//			for(int i = 1; i < 10; i++) {
//				System.out.printf(number + "*" + i +"=" + number*i + "\n");
//			}
//		}
//		sc.close();
//		int sum = 0;
//		int number = 0;
//		System.out.println("Put 5 quantities of int.");
//		for(int i = 0; i < 5; i++) {
//			number = sc.nextInt();
//			if(number < 0) {
//				continue;
//			} else {
//				sum += number;
//			}
//		}
//		System.out.println("total int : " + sum);
//		sc.close();

		String str = null;
		System.out.println("if put exit, exit.");
		while(true) {
			str = sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("exit....");
				break;
			}
		}
		sc.close();
		
		
	}

}
