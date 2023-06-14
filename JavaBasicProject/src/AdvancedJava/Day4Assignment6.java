package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment6 {

	public static void main(String[] args) {
		// find the longest palindrome in the given string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");

		// Examples of palindrome
		// Civic, malayalam, radar, noon, level,
		// Hannah, Emme, Ava, Bob, Otto
		// TacoCat, WasItACarOrACatISaw, TooBadIHidABoot

		String str = input.next();

		// If input str is a palindrome then it will be the longest palindrome
		if (isPalindrome(str) == true) {
			System.out.println("Longest palindrome is " + str);
		} else {
			// Otherwise we will loop thru all chars in str and
			// We will store longest palindrome in variable longPal

			String longPal = "";

			// In outer for loop, we will start with all characters in given string str
			for (int i = 0; i < str.length(); i++) {
				// In inner for loop, we will start at outer loop index and go thru rest of
				// characters
				// to see if there are any inner palindromes

				for (int j = i; j < str.length(); j++) {
					// Substring from beginning of outer loop index thru current inner loop index
					String substr = str.substring(i, j + 1);

					// If the length of substr is >=2 we will check if substring is a palindrome
					if (substr.length() >= 2 && isPalindrome(substr) == true) {

						// If the palindrome we found is longest than previous find, update longPal
						// variable

						if (substr.length() > longPal.length()) {
							longPal = substr;
						}
						System.out.println("Found palindrome in substr " + substr + " (length: " + substr.length()
								+ ", longPal:" + longPal + ")");
					}

				}
			}

			if (longPal.length() > 0)
				System.out.println("Longest palindrome is " + longPal);
			else
				System.out.println("No palindromes found");
		}

		input.close();
	}

	// To check is given string s is a palindrome or not
	// we will first reverse the string and then compare with the input s

	private static boolean isPalindrome(String s) {
		// Reverse string initialized to ""
		String rev = "";
		// Converting string to character array and loop through each character
		for (char ch : s.toCharArray()) {
			rev = ch + rev; // adds each character in front of the existing string
		}

		// Do case insensitive comparison of input string s and reverse string rev
		// If they are same return true, it's a palindrome, otherwise return false
		return s.equalsIgnoreCase(rev);
	}
}
