package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment4 {

	public static void main(String[] args) {
		// print only even numbers in the given array

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = input.nextInt();
		System.out.println();

		int[] nums = new int[n];

		// Ask user to input all numbers
		for (int i = 0; i < nums.length; i++) {

			System.out.print("Enter the number :");
			nums[i] = input.nextInt();

		}

		System.out.println("The even numbers are: ");
		for (int b : nums) {

			if (b % 2 == 0) {
				System.out.print(b + " ");
			}

		}
		input.close();

	}

}
