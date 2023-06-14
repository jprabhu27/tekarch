package hackathon;

import java.util.Scanner;

public class Q2FindFactorial {

	public static long factorialCalc(int num) {

		long fact = 1;

		for (int i = 1; i <= num; i++) {

			fact *= i;

		}
		return fact;

	}

	public static void main(String[] args) {
		// Q2. write a program to find factorial (Non Recursive)

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the factorial number: ");
		int num = input.nextInt();

		if (num <= 0) {
			System.out.println("Enter the number greater than zero");
		} else {
			long result = factorialCalc(num);
			System.out.println("The factorial of " + num + " is: " + result);
		}
		input.close();
	}

}
