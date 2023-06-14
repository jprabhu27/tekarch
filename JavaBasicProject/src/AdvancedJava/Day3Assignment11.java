package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment11 {

	public static void main(String[] args) {
		// Write a Java program to remove all the white spaces from a given string

		// creat an object of scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = input.nextLine();
		System.out.println("The original string is: " + s);

		// Removing white spaces using replaceAll
		// The \\s finds all white space characters(tabs, spaces, new line character)
		s = s.replaceAll("\\s", "");
		System.out.println("The new string is: " + s);

		input.close();

	}

}
