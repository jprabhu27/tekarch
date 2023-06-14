package hackathon;

import java.util.Scanner;

public class Q24 {

	public static void main(String[] args) {
		// Q24. Write a program which inputs a positive natural number N and prints
		// the possible consecutive number combinations, which when added give
		// N. INPUT: N = 9 OUTPUT: 4 + 5 2 + 3+ 4

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a positive natural number: ");
		int n = input.nextInt();

		int start = 1;
		int end = (n + 1) / 2;
		int sum = 0;

		System.out.println("Possible consecutive number combinations are: ");
		for (int i = start; i <= end; i++) {
			sum = i;
			for (int j = i + 1; j <= end; j++) {
				sum += j;

				if (sum == n) {
					// Print the consecutive number combination
					for (int k = i; k <= j; k++) {
						System.out.print(k);

						if (k != j)
							System.out.print("+");
					}
					System.out.println();
					break;
				} else if (sum > n) {
					break;
				}
			}
		}
		input.close();
	}

}
