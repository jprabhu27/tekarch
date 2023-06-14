package hackathon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q19NumberOfOccur {

	public static void main(String[] args) {
		// Q19. WJP to display number of occurrence of all character

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
		System.out.println("The number of ouccurances of all characters are: ");

		for (Character c : chCountMap.keySet()) {
			System.out.println("  Character " + c + " occurs " + chCountMap.get(c));
		}
		System.out.println();

		input.close();
	}
}
