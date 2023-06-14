package AdvancedJava;

import java.util.Scanner;

public class Day2Assignment2 {

	// 2. To find the given year is leap year or not(include century year also)

	public static void leapYear(int year) {

		if ((year % 4 == 0) && (year % 100 != 0 || (year % 400 == 0))) {
			System.out.print("The year " + year + " is a leap year");
		} else {
			System.out.print(" The year " + year + " is not a leap year");
		}
	}

	public static void main(String[] args) {
		// To find the given year is leap year or not(include century year also)

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year ");
		int year = input.nextInt();

		leapYear(year);
		input.close();

	}

}
