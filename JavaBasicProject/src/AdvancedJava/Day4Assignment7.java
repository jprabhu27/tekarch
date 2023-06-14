package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment7 {

	public static void main(String[] args) {
		// find the frequency of each character in the given string

		// Request user to input the string
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String s = input.nextLine();

		int i, j;

		// First find unique chars in a string
		// Then for each of that unique char,
		// count how many times char exists in string by calling function
		System.out.print("The frequency of the string are: ");
		for (i = 0; i < s.length(); i++) {
			for (j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					break;
			}
			if (i == j) // If i is same j, this is a unique character
			{
				// Use countChars method to count how many times the given
				// character exists in the string user inputed
				// Pass that string and the unique character we just found
				int c = countChars(s, s.charAt(i));

				// Output the charater and how many times it occurs in the string
				System.out.print(s.charAt(i) + ":" + c + " ");

				input.close();
			}
		}

	}

	// Count how many times ch1 occurs in str1
	private static int countChars(String str1, char ch1) {
		int count = 0;

		// Use enhanced for loop to go thru all characters in str1
		for (char c : str1.toCharArray()) {
			if (c == ch1) // If c is same as ch1, increase count
				count++;
		}

		// return how many times ch1 was found in str1 back to the caller
		return count;
	}

}
