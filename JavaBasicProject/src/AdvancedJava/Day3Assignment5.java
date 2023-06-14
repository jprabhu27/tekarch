package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment5 {

	public static void main(String[] args) {
		// find the character at a given location

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the word: ");
		String s = input.next();

		System.out.println("Enter a location for the character: ");
		int n = input.nextInt();

		char p1 = s.charAt(n);
		System.out.println("The character at position " + n + " is: " + p1);

		input.close();

	}

}
