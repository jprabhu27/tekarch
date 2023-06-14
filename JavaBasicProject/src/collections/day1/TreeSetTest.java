package collections.day1;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> ob=new TreeSet<Integer>();
		ob.add(13);
		ob.add(34);
		ob.add(12);
		ob.add(13);
		ob.add(25);// 12 13 16 25 34  --> compareTo() from comparable interface or compare() from comparator interface
		ob.add(16);
		ob.add(null);
		Iterator it= ob.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		

	}

}
