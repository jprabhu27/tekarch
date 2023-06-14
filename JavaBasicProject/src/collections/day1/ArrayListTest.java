package collections.day1;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListTest {

	public static void main(String[] args) {
		// 5 int elements-->insertion order.duplicates
				ArrayList<Integer> ob=new ArrayList<Integer>() ;// 10 -->11th-->15
				ob.add(2);
				ob.add(56);
				//ob.add("tekarch");
				ob.add(2);
				ob.add(null);
				ob.add(null);
				System.out.println(ob);
				System.out.println(ob.size());//5
				System.out.println(ob.contains(2));//true
				Integer i=2;
				System.out.println(ob.remove(i));
				System.out.println(ob);// 56 2 null null
				
				Iterator<Integer> it=ob.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
				
			}


}
