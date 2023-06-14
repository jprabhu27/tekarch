package AdvancedJava;

import java.util.Scanner;

public class Day1Assignment2 {

	public static void main(String[] args) {
		// Find the maximum of two and minimum of three numbers

		Scanner in = new Scanner(System.in);

		System.out.print("Enter the first number ");
		int max1 = in.nextInt();

		System.out.print("Enter the second number ");
		int max2 = in.nextInt();

		if (max1 > max2) {

			System.out.print("Maximum of two number is " + max1);
		} else {
			System.out.print("Maximum of two number is " + max2);
			System.out.println();
		}

		// Find the minimum of three numbers

		System.out.println();
		System.out.print("Enter the first number ");
		int min1 = in.nextInt();

		System.out.print("Enter the second number ");
		int min2 = in.nextInt();

		System.out.print("Enter the third number ");
		int min3 = in.nextInt();

		if (min1 < min2 && min1 < min3) {
			System.out.println("The minimum number is " + min1);

		} else if (min2 < min1 && min2 < min3) {
			System.out.println("The minimum number is " + min2);
		} else {
			System.out.println("The minimum number is " + min3);
		}
		in.close();
	}

}
