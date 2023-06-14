package collections.day1;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		HashMap<Integer,String> ob = new HashMap<Integer,String>();
		
		ob.put(11, "banu");
		ob.put(13, "aana");
		ob.put(null, "divya");
		ob.put(null, null);
		ob.put(11, "john");
		ob.put(15, null);
	//	ob.put("aana", 12);
		//ob.get(11);
		System.out.println(ob);

	}

}

// chtklchchl   c=3 h=3 t=1 k=1 l=2
// no order of keys
//no duplicate keys
// overrides the value if same key used
// allows one null as key and multiple null as value