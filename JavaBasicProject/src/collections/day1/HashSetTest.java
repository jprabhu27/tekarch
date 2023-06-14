package collections.day1;

import java.util.HashSet;
import java.util.Iterator;



public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// equals() and hashcode()--> 13 34 12 
				
				HashSet<Integer> ob=new HashSet<Integer>();
				
				ob.add(13);
				ob.add(34);
				ob.add(12);
				ob.add(13);// 13 -reject // equals() and hashcode()
				//ob.add("Aana");
				/*
				 * ob.add(null); ob.add(null);
				 */
				ob.add(36);
				
				Iterator it= ob.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				
				}
				
				
			}

		}
		// sort the hashSet content in sorted order

		//

