package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment7 {

	public static void main(String[] args) {

		// check whether the given substring is present in the given string or not.

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the sentence: ");
		String s = input.nextLine();

		System.out.print("Enter the substring you want to find: ");
		String a = input.next();

		// Using contains()when the the substring is present
		boolean check = s.toLowerCase().contains(a.toLowerCase());

		if (check) {
			System.out.println("Substring is present in the given string");
		} else {
			System.out.println("Substring is not present in the given string");
		}

		input.close();
	}

}
