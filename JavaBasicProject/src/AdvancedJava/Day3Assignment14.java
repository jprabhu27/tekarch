package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment14 {

	public static void main(String[] args) {
		// Write a Java program to check if a given text is a rotation of another text
		// example : "aana" is rotation of "naaa"

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first word");
		String s1 = input.nextLine();
		System.out.println("Enter the second word");
		String s2 = input.nextLine();

		// If lengths don't match, its not rotated string
		if (s1.length() != s2.length()) {

			System.out.println("The Second string is not a rotation of the first string");
		} else {
			// concatenate s1 with itself
			// e.g If s1=jaya s2=yaja
			s1 += s1; // s1=jayajaya

			// Check if s2 is present in s1
			if (s1.indexOf(s2) >= 0) // index of "yaja" in "jayajaya" is 2, so it is a rotation
				System.out.println("Second  string is a rotation of first string ");
			else
				System.out.println("Second string is not a rotation of first string");
		}

		input.close();
	}

}
