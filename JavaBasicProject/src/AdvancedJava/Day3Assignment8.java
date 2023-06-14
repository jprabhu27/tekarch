package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment8 {

	public static void main(String[] args) {
		// count the number of words in a given string sentence

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the sentence: ");
		String s = input.nextLine();

		int count = 1;

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' ')) {
				count++;
			}
		}
		System.out.println("The number of words in a given string are: " + count);
		input.close();
	}

}
