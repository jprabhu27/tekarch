package Quiz;

import java.util.Scanner;

public class Q18 {

	public static void main(String[] args) {

		// java program to print the sum of a given array elements of size n. (read all
		// the input from user)

		Scanner enter = new Scanner(System.in);

		int n, sum = 0;

		System.out.print("Enter number of elements to add up: ");
		n = enter.nextInt();

		int arrNumber[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter number " + (i + 1) + ": ");
			arrNumber[i] = enter.nextInt();
			sum += arrNumber[i];
		}

		System.out.println("\nSum of array is: " + sum);
		enter.close();
	}
		
}
