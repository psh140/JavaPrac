import java.util.ArrayList;

class Shape {
//	public Shape next;
//	public Shape() {
//		next = null;
//	}
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {

	@Override
	public void draw() {
		System.out.println("Line");
//		super.draw();
	}
}

class Rect extends Shape {

	@Override
	public void draw() {
		System.out.println("Rect");
//		super.draw();
	}
}

class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("Circle");
//		super.draw();
	}
}

class Weapon {
	protected int fire() {
		return 1;
	}
}

class Cannon extends Weapon {

	@Override
	protected int fire() {
		return 10;
	}
	
}
public class Overriding {
	static void paint(Shape p) {
		p.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();		
		
		paint(line);
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
		
		Weapon weapon = new Weapon();
		System.out.println("Normal weapon's attack damage is " + weapon.fire());
		
		weapon = new Cannon();
		System.out.println("Cannon's attack damage is " + weapon.fire());
	}

}
