package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day5Assignment2 {

	public static void main(String[] args) {

		// search an given key in the array of size n using
		// linear or sequential search
		
		int i, target;

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the array size: ");
			int size = input.nextInt();

			// Storing elements in an array
			int[] arr = new int[size];
			for (i = 0; i < size; i++) {
				System.out.println("Enter the number: ");
				arr[i] = input.nextInt();
			}

			// asking user for the target element
			System.out.print("Enter the target number: ");
			target = input.nextInt();

			System.out.println();
			boolean targetFound = false;
			for (i = 0; i < size; i++) {
				if (arr[i] == target) { // Search if the target is present
					System.out.println("The target " + target + " is present at the index: " + i + " in array "
							+ Arrays.toString(arr));
					targetFound = true;
					break;
				}
			}

			if (targetFound == false)
				System.out.println("The target " + target + " not found in array " + Arrays.toString(arr));

			input.close();
		}
	}

}
