package AdvancedJava;

import java.util.Scanner;

public class Day1Assignment1 {

	public static void main(String[] args) {
		// Swap two numbers with and without using third variable

		// Swap two numbers with using third variable

		int temp = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter first number ");
		int number1 = in.nextInt();

		System.out.print("Enter second number ");
		int number2 = in.nextInt();

		System.out.println("Before the numbers are swapped " + "Number 1= " + number1 + "," + "Number 2= " + number2);

		temp = number1;
		number1 = number2;
		number2 = temp;

		System.out.println("After the numbers are swapped " + "Number 1= " + number1 + "," + "Number 2= " + number2);

		// Swap two numbers without using third variable
		System.out.println();

		System.out.print("Enter the first number ");
		int x = in.nextInt();

		System.out.print("Enter the second number ");
		int y = in.nextInt();

		System.out.print(
				"Before the numbers are swapped without third variable " + "Number 1= " + x + " , " + "Number 2= " + y);

		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println();

		System.out.print("After the numbers are swapped " + "Number 1= " + x + " , " + "Number 2= " + y);
		in.close();
	}

}
