package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment13 {

	public static void main(String[] args) {
		// Write a Java program to find all the substrings of a given string

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = input.nextLine();

		// Split the string from space using split method
		String[] array = s.split(" ");

		System.out.println("The substrings of a given string are: ");
		for (String str : array) {
			System.out.print(str + ",");

			input.close();
		}

	}

}
