package Quiz;

import java.util.Scanner;

public class Q22 {

	public static void main(String[] args) {
		// Find the frequency of the given character in the given string.

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the string: ");
		String a = input.nextLine();

		System.out.println("Enter the character: ");
		char b = input.next().charAt(0);

		int j = 0;
		a = a.toLowerCase();
		b = Character.toLowerCase(b);

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b) {
				j++;

			}

		}
		System.out.println("The frequency of " + b + " =" + j);
		
		input.close();
	}

}
