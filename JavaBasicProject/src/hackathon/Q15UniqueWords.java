package hackathon;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Q15UniqueWords {

	public static void main(String[] args) {
		// Q15. Given a string print the unique words of the string.

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		String[] s = str.split("\\s+");

		Set<String> unique = new HashSet<>();

		for (String s1 : s) {

			unique.add(s1);
		}

		System.out.print("The unique words are: " + unique);
		input.close();
	}

}
