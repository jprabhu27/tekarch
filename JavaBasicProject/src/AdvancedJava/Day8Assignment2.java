package AdvancedJava;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Day8Assignment2 {

	public static void main(String[] args) {
		// Remove the duplicates character in the given string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine(); // Prompt the user to enter the string

		char[] ch = str.toCharArray(); // Convert the string to character array

		Set<Character> s = new HashSet<Character>(); // Create a HashSet to store the unique characters
		StringBuilder sb = new StringBuilder(); // Create StringBuilder to append the unique characters

		// using enhanced for loop
		for (char c : ch) { // Loop through each character array

			if (!s.contains(c)) { // Check if the character is already in HashSet
				s.add(c); // if not add it to the HashSet
				sb.append(c); // Append it to the StringBuilder

			}

		}

		// Create an iterator for the HashSet and print out unique character

		Iterator<Character> it = s.iterator();

		// HashSet output order is not any specific order, but contains the unique
		// characters in input string
		System.out.print("HashSet Output: ");

		while (it.hasNext()) {

			System.out.print(it.next());
		}

		System.out.println();

		String output = sb.toString(); // Convert the contents of the StringBuilder object to string

		// StringBuilder output shows character in input string as they appear but after
		// removing duplicates
		
		System.out.print("StringBuilder output: " + output);
		input.close();
	}

}
