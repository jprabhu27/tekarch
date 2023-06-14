package AdvancedJava;

import java.util.Scanner;

public class Day2Assignment3 {

	// Finding the area of a circle
	public int findArea(int a) {

		int area = a * a;
		return area;
	}

	public int findArea(int length, int width) {

		int area = length * width;
		return area;
	}

	public static void main(String[] args) {
		// Find area of square and rectangle using overloading

		Scanner input = new Scanner(System.in);
		Day2Assignment3 ob = new Day2Assignment3();

		// Find the area of square

		System.out.print("Enter the first number ");
		int a = input.nextInt();
		int square = ob.findArea(a);
		System.out.println("The area of a square is: " + square);
		System.out.println();

		// Find the are of a rectangle
		System.out.print("Enter the length ");
		int length = input.nextInt();

		System.out.print("Enter the width ");
		int width = input.nextInt();

		int rectangle = ob.findArea(length, width);
		System.out.println("The area of a rectangle is :" + rectangle);

		input.close();

	}

}
