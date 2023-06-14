package Quiz;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {

		// Java program that takes three numbers as input to calculate and print the
		// average of three numbers

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the first number :");
		float num1 = input.nextFloat();

		System.out.print("Enter the second number :");
		float num2 = input.nextFloat();

		System.out.print("Enter the third number :");
		float num3 = input.nextFloat();

		System.out.println("The average of three numbers = " + (num1 + num2 + num3) / 3);
		
		input.close();

	}

}
