package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment1 {

	public static void main(String[] args) {
		// add all the elements in the given array of size n

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size: ");
		int a = input.nextInt();
		int[] array = new int[a];

		// Regular for loop to accept input and initialize array elements
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter the number ");
			array[i] = input.nextInt();
		}

		int sum = 0;

		// Enhanced for loop to calculate the sum
		for (int b : array) {
			sum += b;
		}

		System.out.println("The sum of array elements is: " + sum);

		input.close();

	}

}
