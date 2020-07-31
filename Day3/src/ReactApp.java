import java.util.Scanner;

class Rectangle {

	int width;
	int height;

	public int getArea() {
		return width * height;
	}
}

public class ReactApp {

	public static void main(String[] args) {

		Rectangle rect = new Rectangle();
		Scanner sc = new Scanner(System.in);
		rect.width = sc.nextInt();
		rect.height = sc.nextInt();
		System.out.println("Rectangle's area is " + rect.getArea());
		sc.close();
	}

}
