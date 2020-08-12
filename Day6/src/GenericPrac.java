class GStack<T> {
	int tos;
	Object[] stck;
	public GStack() {
		tos = 0;
		stck = new Object[10];
	}
	
	public void push(T item) {
		if(tos == 10) {
			return;
		}
		stck[tos] = item;
		tos++;
	}
	
	
	public T pop() {
		if(tos == 0) {
			return null;
		}
		tos--;
		return (T)stck[tos];
	}
	
}
public class GenericPrac {

	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>();
		
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("Auckland");
		
		for(int i = 0; i < 3; i++) {
			System.out.println(stringStack.pop());
		}
		
		GStack<Integer> intStack = new GStack<Integer>();
		
		intStack.push(1);
		intStack.push(4);
		intStack.push(55);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(intStack.pop());
		}

	}

}
