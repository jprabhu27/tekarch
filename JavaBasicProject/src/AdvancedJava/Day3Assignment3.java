package AdvancedJava;

import java.util.Scanner;

public class Day3Assignment3 {

	public static void main(String[] args) {
		// convert int to string

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Integer: ");
		int a = input.nextInt();

//		String s = Integer.toString(a);
//		System.out.println("The conversion of integer to string value is " +s);
//		
		// Second method
		String c = String.valueOf(a);
		System.out.println("The integer to string value is: " + c);
//		
//		//Third method
//		String b = String.format("%d", a);
//		System.out.println("The integer to string value is " +b);

		input.close();
	}

}
