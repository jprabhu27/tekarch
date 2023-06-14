package AdvancedJava;

import java.util.Scanner;
import java.util.Arrays;

public class Day4Assignment9 {

	public static void main(String[] args) {
		// Add sum of the array to each element in the array

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int s = input.nextInt();

		int[] array = new int[s];

		int sum = 0;
		int i;
		System.out.println("Enter the " + s + " elements of an arrray");

		for (i = 0; i < array.length; i++) {
			array[i] = input.nextInt(); // User enter the elements
			sum += array[i]; // Calculates the sum
		}
		
		// Prints the elements and their sum
		System.out.println("Elements of the array are: " + Arrays.toString(array));
		System.out.println("The sum of elements are: " + sum);
		input.close();
	}

}
