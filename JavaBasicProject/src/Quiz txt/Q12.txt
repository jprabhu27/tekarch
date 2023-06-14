package Quiz;

import java.util.Scanner;

public class Q12 {

	public static void main(String[] args) {
		// read size n from user and print 13579.....

		// 1 3 5 7 9 11 13 15 17 19 21 23
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the size: ");
		int size = input.nextInt();

		for (int i = 1; i <= size * 2; i += 2) {
			System.out.print(i + " ");
		}

		System.out.println();
		input.close();
	}

}
