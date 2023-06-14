package hackathon;

import java.util.Scanner;

public class Q30 {

	public static void main(String[] args) {
		// Q30. Write a function to find out longest palindrome in a given string?

		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");

		String str = input.next();

		// If input str is a palindrome then it will be the longest palindrome
		if (isPalindrome(str) == true) {
			System.out.println("Longest palindrome is " + str);
		} else {
			
			String longPal = "";

			// In outer for loop, we will start with all characters in given string str
			for (int i = 0; i < str.length(); i++) {
				
				for (int j = i; j < str.length(); j++) {
					
					String substr = str.substring(i, j + 1);

					// If the length of substr is >=2 we will check if substring is a palindrome
					if (substr.length() >= 2 && isPalindrome(substr) == true) {

						if (substr.length() > longPal.length()) {
							longPal = substr;
						}
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
		
		for (char ch : s.toCharArray()) {
			rev = ch + rev; 
		}

			return s.equalsIgnoreCase(rev);
	}
}
