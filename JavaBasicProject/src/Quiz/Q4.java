package Quiz;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {

		// print the sum (addition), multiply, subtract, divide and remainder of

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the first number: ");
		int number1 = input.nextInt();

		System.out.print("Enter the second number: ");
		int number2 = input.nextInt();

		System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
		System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
		System.out.println(number1 + " x " + number2 + " = " + (number1 * number2));
		System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
		System.out.println(number1 + " mod " + number2 + " = " + (number1 % number2));
		
		input.close();

	}

}
