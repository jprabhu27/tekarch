package hackathon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q18DuplicateCh {

	public static void main(String[] args) {
		// Q18. WJP to display duplicate character in string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		char[] carr = str.toLowerCase().toCharArray();

		// Counting occurrences
		Map<Character, Integer> chCountMap = new HashMap<>();

		for (Character ch : carr) {

			if (chCountMap.containsKey(ch)) {
				int count = chCountMap.get(ch);
				chCountMap.put(ch, count + 1);
			} else {
				chCountMap.put(ch, 1);
			}
		}

		System.out.print("The duplicate characters are: ");

		for (Character c : chCountMap.keySet()) {
			if (chCountMap.get(c) > 1) {
				System.out.print(c + " ");
			}
		}
		System.out.println();

		input.close();

	}

}
