package Quiz;

import java.util.Scanner;

public class Q23 {

	public static void main(String[] args) {

		// Write a Java program to Accept Name, Age, Gender and Aadhaar number of a
		// person from the user and print them in separate lines

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = input.next();

		System.out.print("Enter your age: ");
		int age = input.nextInt();

		System.out.print("Enter your gender M/F: ");
		char gender = input.next().charAt(0);
		gender = Character.toUpperCase(gender);

		System.out.print("Enter your Aadhaar number: ");
		String aadhaarNo = input.next();

		System.out.println();

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Aadhaar Number: " + aadhaarNo);

		input.close();
	}

}
