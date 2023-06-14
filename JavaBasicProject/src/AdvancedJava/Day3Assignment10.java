package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment10 {

	public static void main(String[] args) {
		// Write a Java program to remove given characters from the string

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = input.nextLine();

		System.out.println("Enter the character you want to remove: ");
		String ch = input.nextLine();

		System.out.println("After deleting the character: " + s.replace(ch, ""));

		input.close();
	}
}