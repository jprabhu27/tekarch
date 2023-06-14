package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day3Assignment4 {

	public static void main(String[] args) {
		// convert string to char array

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.next();

		char[] array = s.toCharArray();
		System.out.println("String to Character Array is: " + Arrays.toString(array));

		input.close();
	}
}
//}
