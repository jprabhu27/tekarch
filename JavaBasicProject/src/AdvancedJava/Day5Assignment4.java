package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day5Assignment4 {

	public static void main(String[] args) {
		// search an given key in the array of size n using
		// binary search

		int i;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the size of an array: ");
			int size = input.nextInt();

			int[] arr = new int[size];

			for (i = 0; i < size; i++) {
				System.out.print("Enter the number of elements: ");
				arr[i] = input.nextInt();
			}

			System.out.println("Enter the target number: ");
			int target = input.nextInt();

			System.out.println("Before sorting: " + Arrays.toString(arr));

			// First sort the array before making the binarySearch call
			Arrays.sort(arr);
			System.out.println("After sorting: " + Arrays.toString(arr));

			int result = Arrays.binarySearch(arr, target);

			if (result < 0) {
				System.out.println("Element not found: ");
			} else
				System.out.println("The target " + target + " found in an array using binary sort" + Arrays.toString(arr));

			input.close();
		}
	}

}
