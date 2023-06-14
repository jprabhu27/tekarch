package AdvancedJava;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Day8Assignment4 {

	public static void main(String[] args) {
		// Given a string, write a Java program to find the most common word in the
		// string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		str = str.toLowerCase();

		String[] arr = str.split(" "); // Split the input string into array of words using split()and we are using
										// (" ") as the delimiter

		// Create a Map to store the frequency of each word

		Map<String, Integer> freq = new HashMap<>();

		// Iterate through the words and update the frequency count in the Map
		// It creates a mapping of each unique word in the string to its frequency of
		// occurrence

		for (String s : arr) {

			Integer num = freq.get(s); // Retrieves the current frequency of the word from freq using the get() method

			freq.put(s, (num == null) ? 1 : num + 1); // If the frequency is null that is if the word does not exist in
														// the map
														// then it is set to 1; otherwise it increments the frequency by
														// 1 and updates
														// the map using the 'put' method

		}
		// Find the most frequent word

		String common = ""; // Initialize the common variable to an empty string
		int maxRep = 0; // Initialize the maxRep variable to 0

		// Iterate through each entry in the Map and compare its frequency with the
		// current maximum frequency

		for (Map.Entry<String, Integer> entry : freq.entrySet()) { // Returns a set view of the key-value pair in a map

			if (entry.getValue() > maxRep) { // Compares the frequency of the current word with the maximum frequency
												// and updates the common and maxRep
				common = entry.getKey(); // Extracts the key(Word)
				maxRep = entry.getValue(); // Extracts the value(Frequency)

			}

		}

		System.out.println("The most common word is: " + common);
		System.out.println("The frequency of the word is: " + maxRep);

		input.close();
	}

}
