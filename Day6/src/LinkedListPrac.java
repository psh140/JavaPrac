import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPrac {

	static void printList(LinkedList<String> l) {
		
		Iterator<String> iterator = l.iterator();
		while(iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			if(iterator.hasNext()) {
				separator = "->";
			} else {
				separator = "\n";
			}
			System.out.print(e + separator);
		}
		
	}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("transformer");
		myList.add("star wars");
		myList.add("matrix");
		myList.add(0, "terminator");
		myList.add(2, "avatar");
		
		Collections.sort(myList);
		printList(myList);
		
		Collections.reverse(myList);
		printList(myList);
		
		int index = Collections.binarySearch(myList, "avatar") + 1;
		System.out.println("avatar is " + index + " element.");

	}

}
