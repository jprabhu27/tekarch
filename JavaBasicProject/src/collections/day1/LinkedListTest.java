package collections.day1;


import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				LinkedList<String> ob=new LinkedList<String>();//0 
				ob.add("aana");// autoboxing

				ob.add("aana");
				ob.add(null);
				ob.add(null);
				ob.add("john");
				ob.add("banu");
				System.out.println(ob);
				ob.add(0,"divya");
				System.out.println(ob);
				ob.set(0, "poorna");// replaces the ele
				System.out.println(ob);
				ob.add(0,"suchi");
				
				Iterator<String> it= ob.iterator();
				while(it.hasNext()) {
					System.out.println("element is="+it.next());
				}
				
				

	}
	}

		
		// reading and writing the xl sheet
		// poi jar-- 