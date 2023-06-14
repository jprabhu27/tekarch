package hackathon;

import java.util.Scanner;

public class Q16RemoveCharacter {

	public static String removeCh(String str, char remove) {

		StringBuilder output = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current != remove) {
				output.append(current);
			}

		}

		return output.toString();
	}

	public static void main(String[] args) {
		// Q16. Write a method that will remove given character from the String?

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		System.out.print("Enter the character you want to remove: ");
		char remove = input.next().charAt(0);

		String result = removeCh(str, remove);
		System.out.print("After the character is removed: " + result);

		input.close();
	}

}
