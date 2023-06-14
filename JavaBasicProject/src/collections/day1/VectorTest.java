package collections.day1;

//fail-fast and fail-safe
import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Vector<Integer> ob=new Vector<Integer>();
				ob.add(10);
				ob.add(15);
				ob.add(56);
				ob.add(56);
				System.out.println(ob);
				
				Enumeration<Integer> list= ob.elements();
				while(list.hasMoreElements()) {
					System.out.println(list.nextElement());
				}
				
				

			}

		}
		// enumeration and iterator  ---> fail-safe fail-fast