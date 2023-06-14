package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment2 {

	public static void main(String[] args) {
		// convert string to integer

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");

		String s = input.next();

		int a = Integer.parseInt(s);
		System.out.println("After the string is converted to integer " + a);

		// Second method
//		int b = Integer.valueOf(s);
//		System.out.println("After the string is converted to integer "+b);

		input.close();
	}

}
