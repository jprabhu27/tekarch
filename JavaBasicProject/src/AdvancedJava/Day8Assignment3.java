package AdvancedJava;

import java.util.Scanner;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Day8Assignment3 {

	public static void main(String[] args) {
		// Given a string, write a Java program to find all the unique words in the
		// string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine(); // Take the user input
		str = str.toLowerCase();

		String[] arr = str.split(" "); // Split the string into words using built-in function

		Set<String> set = new HashSet<String>(); // Create HashSet to store unique words
		StringBuilder sb = new StringBuilder();

		// Iterate through (words) arr and add unique words to the HashSet
		
		for (String s : arr) {
			if (!set.contains(s)) {
				set.add(s);
				sb.append(s);
				sb.append(" "); // add a space to separate words
			}
		}

		System.out.println("Number of unique words found: " + set.size());

		// Create an iterator for the HashSet and print out unique words
		
		System.out.print("The output using HashSet: ");
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

		System.out.println();

		String output = sb.toString();
		System.out.println("The output using StringBuilder: " + output);
		input.close();
	}

}
