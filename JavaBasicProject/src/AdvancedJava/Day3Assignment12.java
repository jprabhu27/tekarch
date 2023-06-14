package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment12 {

	public static void main(String[] args) {
		// Write a Java program to capitalize the first letter of each word in a given
		// string.

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String in = input.nextLine();

		System.out.println("The new string is: ");

		// Split method divides the string at the specified strings and returns an array
		// of substrings
		String[] array = in.split(" ");

		for (int i = 0; i < array.length; i++) {

			// This picks out the character at 0 place for each word
			char c = array[i].charAt(0);

			// Convert the string to upper case
			String s = String.valueOf(c).toUpperCase();

			// Append the other string
			String sub = array[i].substring(1);

			// Concatenate the strings together

			System.out.print(s + sub + " ");

			input.close();
		}

	}

}
