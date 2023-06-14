package collections.day1;


import java.util.LinkedHashMap;




public class LinkedHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				LinkedHashMap<String,String> ele=new LinkedHashMap<String,String>();
				ele.put("113","john");
				ele.put("111","john");
				ele.put("113","aana");
				ele.put(null,"rai");
				ele.put("112",null);
				ele.put("114",null);
				ele.put("117", "ddg");
				ele.put(null,"divya");  
				System.out.println(ele); // 113=aana,111=john,null=divya, 112=null, 114=null, 117=ddg
				
				
				
				
				
			
				
				
				
				

			}

		
		// 113-aana   111-john  null-divya  112-null 114-null 117-ddg  
		//null-divya 
	}


