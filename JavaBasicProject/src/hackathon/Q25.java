package hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class Q25 {
	
	public static int binarySearch(int[]arr, int target ) {
		
		int left =0;
		int right= arr.length -1;
		
		while(left<=right) {
			int mid = left +(right - left)/2;
			
			if (arr[mid]== target) {
				return mid;
			}else if (arr[mid]<target) {
				left = mid +1;
			}else {
				right = mid-1;
			}
		}
		return -1;		// Target not found
	}
	
	
	public static void main(String[] args) {
	//Q25. Write a program for binary search. And 5 i/p has to take 
	//from user as binary elements.
	
		int [] arr = new int[5];
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter 5 binary elements: ");
		
		for (int i=0; i<5; i++) {
			arr[i]=input.nextInt();
			
		}
		Arrays.sort(arr);
		
		System.out.println("Enter the target element to search: ");
		int target = input.nextInt();
		
		int result = binarySearch(arr, target);
		
		if (result == -1) {
			
			System.out.println("Target element not found");
		}
		else {
			System.out.println("Target element found at index: " + result);
		}
	
	input.close();
}

}
