package Day5;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //Defining an array of integer type
		int [] array=new int [] {90,23,5,109,12,22,67,34}; //Length of array is 8 here
		
		//Defining an array of String type
		String [] Country = {"California", "Sacramento", "Ohio","Cincinnati","Newyork"};
		
		//Invoking sort() method of the Arrays class
			
		Arrays.sort(array);
		System.out.println("Elements of array sorted in ascending order:");
		
		
		//Prints array using the for loop
		for(int i=0; i<array.length; i++)
		{
			System.out.println(array[i]);
			
		}
		
		//Sorts string array in alphabetical order or ascending order
		
				Arrays.sort(Country);
				System.out.println ("String sorted in ascending order:");
				System.out.println (Arrays.toString(Country));
			
		
				//Sorts string array in alphabetical order or descending order
				Arrays.sort(Country, Collections.reverseOrder());
				System.out.println ("String sorted in descending order:");
				System.out.println (Arrays.toString(Country));
		
	}

}
