package AdvancedJava;

import java.util.*;

public class Day1Assignment3 {

	public static void main(String[] args) {
		// convert float to double
		// double to float
		// int to long
		// long to int

		Scanner input = new Scanner(System.in);

		// Convert float to double

		System.out.print("Enter the Float number ");
		float x = input.nextFloat();

		double y = (double) x;
		System.out.println("Converted the float number " + x + " to double= " + y);
		System.out.println();

		// Convert double to float
		System.out.print("Enter the double number ");
		double a = input.nextDouble();

		float b = (float) a;
		System.out.println("Converted the double number " + a + " to float= " + b);
		System.out.println();

		// Convert integer to long
		System.out.print("Enter the integer ");
		int c = input.nextInt();
		long d = (long) c;// Long.valueOf(c);

		System.out.println("Converted the integer number " + c + " to long= " + d);
		System.out.println();

		// Convert long to integer
		System.out.println("Enter the long number ");
		long e = input.nextLong();
		int f = (int) e;

		System.out.println("Converted the long number " + e + " to integer= " + f);

		input.close();

	}

}
