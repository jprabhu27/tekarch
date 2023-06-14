package Quiz;

import java.util.Scanner;

public class Q13 {

	public static void main(String[] args) {
		// Read size n from user and print pattern 2 4 6 8 10

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number: ");
		int n = input.nextInt();

		for (int i = 2; i <= n * 2; i += 2) {

			System.out.print(i + " ");
		}
		System.out.println();
		input.close();
	}

}
