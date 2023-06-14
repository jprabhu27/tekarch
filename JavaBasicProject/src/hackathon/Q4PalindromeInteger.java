package hackathon;

import java.util.Arrays;

import java.util.Scanner;

public class Q4PalindromeInteger {

	public static void main(String[] args) {
		// Q4.	Given an array of integers check the Palindrome of the series.
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the size: ");
			int size = input.nextInt();
			
			int arr[]= new int[size];
			int reverse[] = new int[size];
			
			int i; 
			boolean isPalindrome = true;
			
			for(i=0; i<size; i++) {
				System.out.print("Enter the integer: ");
				int num=input.nextInt();
				arr[i] = num;
			}

			// Reverse items from "arr" array into "reverse" array
			i = size-1;
			for(int j = 0; j < size; j++) {
				reverse[j] = arr[i];
				i--;
			}
			
			System.out.println();
			System.out.println("The original series: " +Arrays.toString(arr));;
			System.out.println("The reverse series: " +Arrays.toString(reverse));;
			
			for (i=0; i<arr.length; i++) {
									
						if (arr[i] != reverse[i]) {
							isPalindrome = false;
							System.out.println("The series are not a Palindrome ");
							break;
				}
			}
			if (isPalindrome) {
				System.out.print("The series are a Palindrome");
							}
			input.close();
		}
	}

}
