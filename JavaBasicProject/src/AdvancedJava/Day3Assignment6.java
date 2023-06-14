package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment6 {

	public static void main(String[] args) {

		// find the index of given character or substring(first character index)

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = input.next();

		System.out.println("Enter the character you want to find: ");

		char c = input.next().charAt(0);

		System.out.println("The index of a given character " + c + " is: " + s.indexOf(c));
		input.close();

	}

}
