package hackathon;

import java.util.Scanner;

public class Q1BooleanVariable {

	public static boolean twoCount(boolean a, boolean b, boolean c) {
		int count = 0;

		if (a) {
			count++;
		}
		if (b) {
			count++;
		}
		if (c) {
			count++;
		}

		return count >= 2;
	}

	public static void main(String[] args) {
		// Q7. Consider there is a 3 Boolean variable called a, b, c.
		// Check if at least two out of three Booleans are true

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the value for 'a'as True/False: ");
		boolean a = input.nextBoolean();
		System.out.println();

		System.out.print("Enter the value for 'b' as True/False: ");
		boolean b = input.nextBoolean();
		System.out.println();

		System.out.print("Enter the value for 'c' as True/False: ");
		boolean c = input.nextBoolean();
		System.out.println();

		Boolean result = twoCount(a, b, c);
		System.out.print(("The results are: ") + result);

		input.close();
	}

}
