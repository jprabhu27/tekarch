package AdvancedJava;

import java.util.Scanner;
import java.util.ArrayList;

public class Day4Assignment8 {

	public static void main(String[] args) {
		// Move all even numbers to the beginning of the array.

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array");
		int n = input.nextInt();

		int[] array = new int[n];

		// Regular for loop to accept input and initialize array elements and access the
		// index of the array
		for (int i = 0; i < n; i++) {
			// Ask for user input
			System.out.println("Enter the number ");
			array[i] = input.nextInt();
		}

		ArrayList<Integer> evenNums = new ArrayList<Integer>();
		ArrayList<Integer> oddNums = new ArrayList<Integer>();

		System.out.print("Original numbers are: ");
		for (int num : array) {
			System.out.print(num + " ");
			if (num % 2 == 0)
				evenNums.add(num);
			else
				oddNums.add(num);
		}
		System.out.println();

		ArrayList<Integer> finalNums = new ArrayList<Integer>();
		finalNums.addAll(evenNums);
		finalNums.addAll(oddNums);

		// overwrite array such that even numbers are moved to the beginning
		System.out.print("Final numbers are: ");
		for (int j = 0; j < n; j++) {
			array[j] = finalNums.get(j);
			System.out.print(array[j] + " ");
		}
		System.out.println();

		input.close();
	}

}
