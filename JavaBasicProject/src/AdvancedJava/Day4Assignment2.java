package AdvancedJava;

import java.util.Scanner;
//import java.math.*;

public class Day4Assignment2 {

	public static void main(String[] args) {
		// find maximum element in the array

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the element: ");
		int n = input.nextInt();

		int[] array = new int[n];

		// Regular for loop to accept input and initialize array elements and access the
		// index of the array
		for (int i = 0; i < n; i++) {
			// Ask for user input
			System.out.println("Enter the number ");
			array[i] = input.nextInt();
		}

		// Initially the variable max stores the first element of the array
		int max = array[0];

		// Enhanced FOR loop to access all the elements of the array
		for (int a : array) {

			max = Math.max(max, a); // Math.max() method compares the variable max with all the elements of the
									// array and
									// assigns the maximum value to max

		}
		System.out.println("The maximum element in the array is: " + max);

		input.close();
	}

}
