package AdvancedJava;

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class Day8Assignment1 {

	public static void main(String[] args) {
		// Find frequency of each character in a string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.nextLine();

		// abcdaba
		// ch: a b c d a b a
		// Map: <a, 3> <b, 2> <c, 1> <d, 1>
		// value = 2
		Map<Character, Integer> ob = new HashMap<>();

		// Iterate through each character in the string
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// If the character is already in the map, increment its count
			if (ob.containsKey(ch)) {
				int value = ob.get(ch);
				value++;
				ob.put(ch, value);
			}
			// Otherwise, add the character to the map with a count of 1
			else {
				ob.put(ch, 1);
			}
		}

		// Print the frequency of each character using enhanced for loop
		// for (Map.Entry<Character, Integer> entry : ob.entrySet()) {
		//  System.out.println(entry.getKey() + " : " + entry.getValue());
		// }

		// Print the frequency of each character using Iterator
		Set<Entry<Character, Integer>> set = ob.entrySet();
		
		Iterator<Entry<Character, Integer>> it = set.iterator();
		while (it.hasNext() == true) {
			Entry<Character, Integer> entry = it.next(); // return whole entry with key and value
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		input.close();

	}

}
