package AdvancedJava;

import java.util.Scanner;

public class Day4Assignment5 {

	public static void main(String[] args) {
		// check the given string is palindrome or not

		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = input.next();

		// Reverse string use "" as a space holder
		String rev = "";

		for (char ch : str.toCharArray()) // Converting string to character array and loop through each character
		{
			rev = ch + rev; // adds each character in front of the existing string
		}

		System.out.println("Input is " + str + "," + " reverse is " + rev);

		if (str.equalsIgnoreCase(rev))
			System.out.println("The string is a palindrome");
		else
			System.out.println("The string is not a palindrome");

		input.close();
	}

}
