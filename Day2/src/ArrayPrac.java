import java.util.Scanner;

public class ArrayPrac {

	enum Week {Mon, Tus, Wen, Thu, Fri, Sat, Sun}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		int[] intArray = new int[5];
//		int max = 0;
//
//		System.out.println("Put 5 numbers.");
//		
//		for(int i = 0; i < 5; i++) {
//			intArray[i] = sc.nextInt();
//			
//			if(max < intArray[i]) {
//				max = intArray[i];
//			}
//		}
//		
//		System.out.println("The Largest number is " + max + ".");
//		sc.close();

//		int[] n = {1, 2, 3, 4, 5};
//		String[] names = {"A", "B", "C", "D", "E", "F"};
//		
//		int sum = 0; 
//		for (int k : n) {
//			System.out.print(k + " ");
//			
//			sum += 0;
//		}
//		
//		System.out.println("Total is " + sum);
//		
//		for (String s : names) {
//			System.out.print(s + " ");
//		}
//		System.out.println();
//		
//		for (Week day : Week.values()) {
//			System.out.print(day + " ");
//		}
//		System.out.println();
		
//		int intArray[][] = new int [4][];
//		int num = 0;
//		
//		for (int i = 0 ; i < intArray.length ; i++) {
//			System.out.println("Set list length.");
//			num = sc.nextInt();
//			intArray[i] = new int[num];
//		}
//		for (int i = 0; i < intArray.length; i++) {
//			for(int j = 0; j < intArray[i].length; j++) {
//				System.out.println("array[" + i +"][" + j +"] Set Values.");
//				num = sc.nextInt();
//				intArray[i][j] = num;
//			}
//		}
//		for (int i = 0; i < intArray.length; i++) {
//			for(int j = 0; j < intArray[i].length; j++) {
//				System.out.print(intArray[i][j] + "  ");
//			}
//			System.out.println();
//		}
		
		while(true) {
			System.out.println("put divided : ");
			int divided = sc.nextInt();
			System.out.println("put divisor : ");
			int divisor = sc.nextInt();
			
			try {
				System.out.println(divided + " is divided by " + divisor +". : " + (double)divided/divisor);
				break;
			} catch (ArithmeticException e) {
				System.out.println("Do not put 0. try again.");
			}

		}

		sc.close();
		
	}

}
