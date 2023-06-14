package Quiz;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {

		// Java program that takes a number as input(read it from user) and prints its
		// multiplication table up to 10.

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.println(number + " x " + i + " = " + (number * i));
		}
		input.close();
	}

}
