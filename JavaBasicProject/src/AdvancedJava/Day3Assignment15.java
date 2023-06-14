package AdvancedJava;

import java.util.Scanner;
import java.util.Arrays;

public class Day3Assignment15 {

	public static void main(String[] args) {
		// Write a Java program to check if two given strings are anagrams of each other 
		//example: cinema formed from iceman

		// Take input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first string");
		String s = input.nextLine();
		System.out.println("Enter a second string");
		String s1 = input.nextLine();

		// Check is they have same length
		if (s.length() != s1.length()) {

			System.out.println("The string is not an anagram");
		} else {
			// First convert string to character Array
			char[] array1 = s.toCharArray();
			char[] array2 = s1.toCharArray();

			// Second sort the characters array
			Arrays.sort(array1);
			Arrays.sort(array2);

			// Check if they have the same letters
			System.out.println("Both String are anagrams is: " + Arrays.equals(array1, array2));

			input.close();
		}

	}

}
