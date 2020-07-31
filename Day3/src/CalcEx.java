
class Calc {
	public static int abs(int a) {
		return a > 0 ? a : -a;
	}
	public static int max(int a, int b) {
		return (a>b) ? a : b;
	}
	public static int min(int a, int b) {
		return (a>b) ? b : a;
	}
	
}

public class CalcEx {

	public static void main(String[] args) {
		System.out.println(Calc.abs(-44));
		System.out.println(Calc.max(55, 323));
		System.out.println(Calc.min(-1, -222222));
		
	}

}
