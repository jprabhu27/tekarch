package hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class Q3SortingIntegers {

	public static void main(String[] args) {
		//Q3.	Given an array of integers, sort the integer values.

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = input.nextInt();
		
		int[]arr = new int[size];
		
		
		for (int i=0; i<arr.length; i++) {
			
			System.out.print("Enter the numbers: ");
			int num = input.nextInt();
			arr[i]=num;
		}
				
		System.out.println("The unsorted array: " +Arrays.toString(arr) );
		
		Arrays.sort(arr);
		
		System.out.print("The sorted array: " +Arrays.toString(arr));
		
		input.close();
	}

}