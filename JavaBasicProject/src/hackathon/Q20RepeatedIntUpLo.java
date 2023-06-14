package hackathon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q20RepeatedIntUpLo {

	public static void main(String[] args) {
		// Q20. WJP to find total number of repeated integers, uppercase and lowercase
		// character in the give string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		char[] carr = str.toCharArray();

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
		int dCount = 0;
		int uCount = 0;
		int lCount = 0;
		for (Character c : chCountMap.keySet()) {
			if (chCountMap.get(c) > 1) {
				if (Character.isDigit(c))
					dCount++;
				else if (Character.isUpperCase(c))
					uCount++;
				else if (Character.isLowerCase(c))
					lCount++;
			}
		}
		System.out.println("Total number of repeated integers are: " + dCount);
		System.out.println("Total number of repeated uppercase characters are: " + uCount);
		System.out.println("Total number of repeated lowercase characters are: " + lCount);

		input.close();
	}

}
