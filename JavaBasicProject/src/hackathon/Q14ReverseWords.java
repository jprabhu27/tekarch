package hackathon;

import java.util.Scanner;

public class Q14ReverseWords {

	public static void main(String[] args) {
		// Q14. Given a string print the reverse of the words string.(Input: Java Code
		// Output: Code Java)

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		String[] w = str.split("\\s+"); // break string into words by ignoring any white space

		System.out.print("Reverse of words: ");
		for (int i = w.length - 1; i >= 0; i--) {
			System.out.print(w[i] + " ");
		}
		System.out.println();

		input.close();
	}

}
