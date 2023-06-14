package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment3 {

	public static void main(String[] args) {
		// find unique elements in the array

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = input.nextInt();
		System.out.println();

		int[] nums = new int[n];

		// Ask user to input all numbers
		for (int index = 0; index < nums.length; index++) {

			System.out.print("Enter the number :");
			nums[index] = input.nextInt();

		}

		System.out.print("\nYou entered: ");
		for (int k : nums)
			System.out.print(k + " ");
		System.out.println();

		System.out.print("Unique numbers are: ");
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (nums[i] == nums[j]) // Compare array elements
					break;
			}

			// Compare index, if i is same as j, we are actually looking at number at same
			// index, so it is unique
			// If both are not same, then it's not unique, so we won't print it
			if (i == j)
				System.out.print(nums[i] + " ");

		}
		System.out.println();

		input.close();

	}

}
