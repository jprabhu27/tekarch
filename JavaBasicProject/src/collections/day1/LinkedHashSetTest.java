package collections.day1;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				LinkedHashSet<Object> ob=new LinkedHashSet<Object>();
				ob.add(13);
				ob.add(34);
				ob.add(12);
				ob.add(13);
				//ob.add("Aana");
				
				  ob.add(null);
				  ob.add(null);
				 // 13 34 12 null 
				
				
				@SuppressWarnings("rawtypes")
				Iterator it= ob.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}

			}

		}
		// 13 34 12