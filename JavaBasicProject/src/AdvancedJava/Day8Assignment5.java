package AdvancedJava;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Day8Assignment5 {

	public static void main(String[] args) {
		// Write a Java program to sort the characters in the string alphabetically

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();
		str = str.toLowerCase();

		char[] ch = str.toCharArray();

		// Create a List to hold sorted characters

		List<Character> list = new ArrayList<>();

		// Enhanced For Loop to add the characters to the List

		for (Character c : ch) {

			list.add(c);

		}

		// Sort the character in the list

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					char temp = list.get(i);
					list.set(i, list.get(j)); // takes the position of the element to be replaced i.e i and
												// the new element that is to be stored at array[j]

					list.set(j, temp); // takes the position of the element to to be replaces i.e i and
										// the new element that is to be stored at temp

				}

			}

		}

		// Create an iterator for the List and print out the sorted characters
		// alphabetically
		System.out.print("The sorted string is: ");
		Iterator<Character> it = list.iterator();

		while (it.hasNext()) {

			System.out.print(it.next());

		}

//			StringBuilder sb = new StringBuilder();
//			for (char c:list) {
//				sb.append(c);
//			}
//			
//			System.out.println("The sorted String are: " +sb.toString());
		input.close();
	}

}
