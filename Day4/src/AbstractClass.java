abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
}


public class AbstractClass extends Calculator{
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum/a.length;
	}
	
	public static void main(String[] args) {
		AbstractClass a = new AbstractClass();
		System.out.println(a.add(2, 3));
		System.out.println(a.subtract(2, 3));
		System.out.println(a.average(new int [] {2, 3, 4}));
		
	}

	

}
