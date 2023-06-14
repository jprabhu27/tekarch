package AdvancedJava;

import java.util.Scanner;

public class Day1Assignment4 {

	public static void main(String[] args) {
		// Find the factorial of a given number

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number ");
		int n = input.nextInt();
		long factorial = 1;

		for (int i = n; i >= 1; i--) {
			// factorial = factorial *i

			factorial *= i;

		}

		System.out.printf("Factorial of " + n + " is = " + factorial);
		input.close();

		//Method 2
//		factorial = 1;
//		int j = 1;
//		while (j <= n) {
//			// factorial*=j;
//			// j++;
//			factorial *= j++;
//		}
//		System.out.printf("\nFactorial of " + n + " is = " + factorial);
//		input.close();
//		
//		//Method 3
//		factorial = 1;
//		int k = n;
//		while (k >= 1) {
//			factorial *= k--;
//		}
//		System.out.printf("\nFactorial of " + n + " is = " + factorial);
//		input.close();

	}

}
