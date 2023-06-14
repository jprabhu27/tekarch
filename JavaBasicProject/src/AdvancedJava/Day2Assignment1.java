package AdvancedJava;

import java.util.Scanner;

public class Day2Assignment1 {

	public static void fibonacci(int size) {
		int num1 = 0;
		int num2 = 1;
		int i = 0;

		// Iteration
		while (i < size) {

			System.out.print(num1 + " ");

			// Swap
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;

			i++;
			
		}

	}

	public static void main(String[] args) {
		// To find the fibonacci series of size n

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size number ");
		int size = input.nextInt();

		fibonacci(size);

		input.close();
	}

}
