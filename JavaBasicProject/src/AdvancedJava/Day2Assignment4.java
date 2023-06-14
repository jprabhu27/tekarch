package AdvancedJava;

import java.util.Scanner;

public class Day2Assignment4 {

	public static void main(String[] args) {

//		4.Print fallowing patterns
//
//		a. If n=4 then   o/p= 6 9 12 15
//		b. if n=5 then   o/p= 1,4,7,10,13
//		c. If n=5 then   o/p= 0,4,8,12,16

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number: ");
		int n = input.nextInt();

		if (n == 4) {
			printPattern1(n);
			System.out.println();
		} else if (n == 5) {

			System.out.println("The first pattern for " + n + " is : ");
			printPattern2(n);
			System.out.println();

			System.out.println("The second pattern for " + n + " is : ");
			// n = input.nextInt();
			printPattern3(n);
			System.out.println();
		}
		input.close();

	}
	// a. If n=4 then o/p = 6,9 12,15

	public static void printPattern1(int n) {
		int num = 6;

		for (int i = 0; i < n; i++) {
			System.out.print(num + " ");
			num += 3;
		}
		System.out.println();
	}

	// b. If n=5 then o/p = 1,4,7,10,13
	public static void printPattern2(int n) {
		int num = 1;

		for (int i = 0; i < n; i++) {
			System.out.print(num + ",");
			num += 3; // num=num+3
		}
		System.out.println();
	}

	// c. If n=5 then o/p= 0,4,8,12,16
	public static void printPattern3(int n) {
		int num = 0;

		for (int i = 0; i < n; i++) {
			System.out.print(num + " ");
			num += 4;
		}
		System.out.println();
	}
}