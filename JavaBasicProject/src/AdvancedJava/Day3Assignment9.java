package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment9 {

	public static void main(String[] args) {
		// check if two strings are the same ignoring their cases

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String s = input.nextLine();

		System.out.println("Enter the second string: ");
		String s1 = input.nextLine();

		boolean check = s.equalsIgnoreCase(s1);

		if (check) {
			System.out.println("The two strings are the same ");
		} else {
			System.out.println("The two strings are not the same ");
		}

		input.close();

	}

}
