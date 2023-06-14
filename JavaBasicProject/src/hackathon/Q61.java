package hackathon;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q61 {

	public static void main(String[] args) {
		
		//Q 61. write an algorithm to reverse first 3 numbers, 
		//then next 3 numbers, then next 3 numbers, 
		//the number will be  based on var k. Array = [3,2,4,7,0,3,1,5,8, 4]       k=3      
				//OutPut = [4,2,3,3,0,7,8,5,1,4]
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter array size: ");
		int size = input.nextInt();
		System.out.println();
		
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter number: ");
			arr[i] = input.nextInt();
		}
		System.out.println();
		
		System.out.print("Enter group size (k): ");
		int k = input.nextInt();
		System.out.println();
		
		System.out.println("Input array: " + Arrays.toString(arr));
		int[] revArr = reverseNumbers(arr, k);
		System.out.println("Reversed array: " + Arrays.toString(revArr));
		
		input.close();
	}
	
	public static int[] reverseNumbers(int[] arr, int k) {
		
	    List<Integer> result = new ArrayList<>();

	    for (int i = 0; i < arr.length; i += k) {
	        int[] group;	//To store the current group of elements

	        int groupStart = i;	//Assigns the value of i to groupStart 
	        					//which represents the starting index of the current group
	        
	        int groupEnd = i + k;	//Assigns the value of i+k t groupEnd
	        						//which represents the ending index of the current group
	        
	        if (groupEnd > arr.length)
	        	groupEnd = arr.length; //groupEnd is set to the length of arr to 
	        								//avoid going out of bounds
	        
	        //creates a new array 'group' containing the elements of the current group
	        
	        group = Arrays.copyOfRange(arr, groupStart, groupEnd);//To extract subarray from 
	        					//arr starting from groupStart and ending before group end
	        
	        //System.out.println("i=" + i + " group=" + Arrays.toString(group) + " i % k =" + (i % k));
	        
	        if (group.length == k) {
	            reverseArray(group);
	            //System.out.println("i=" + i + " rev group=" + Arrays.toString(group));
	        }

	        for (int num : group) {
	            result.add(num);
	        }
	    }

	    // Convert the result back to an array
	    int[] reversedSequence = new int[result.size()];

	    for (int i = 0; i < result.size(); i++) {
	        reversedSequence[i] = result.get(i);
	    }

	    return reversedSequence;
	}

	private static void reverseArray(int[] arr) {
	    int start = 0;
	    int end = arr.length - 1;

	    while (start < end) {
	        int temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;

	        start++;
	        end--;
	    }
	}
}
