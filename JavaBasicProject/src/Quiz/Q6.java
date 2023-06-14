package Quiz;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {

		// to convert a decimal number to binary number

		Scanner inputno = new Scanner(System.in);
		System.out.print("Enter the number ");
		int quotient = inputno.nextInt();

		String binary = "";
		while (quotient != 0) {
			int remainder = quotient % 2;
			quotient = quotient / 2;

			binary = remainder + binary;
		}
		System.out.print("Binary representation is: ");
		System.out.println(binary);
		inputno.close();
	}

}
