package AdvancedJava;

import java.util.Scanner;


class Student1 {
	public int id;
	public String name;
	public long phone;
	public String country;
	
	Student1(int id, String name, long phone, String country){
		this.id=id;
		this.name=name;
		this.phone=phone;
		this.country=country;
				
	}
}

public class Day2Assignment5 {

	// Private class https://www.w3schools.blog/private-class-in-java
	
	
	
	public static void main(String[] args) {
		// Create the student class with id name phonenumber country
		// create constructors
		// read the data from user
		// store 5 student object
		// and print the details in the console

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int n = input.nextInt();
		System.out.println();

		Student1[] stuArray = new Student1[n];

		System.out.println("Reading student data\n");

		for (int i = 0; i < n; i++) {
			// When i = 0, we want the prompt to be "Enter Student #1", that's why we add
			// (i+1) below
			System.out.println("Student #" + (i + 1));
			stuArray[i] = readStudentData(input);
			System.out.println();
		}

		System.out.println("Printing student data");

		for (int j = 0; j < n; j++) {
			System.out.print("Student #" + (j + 1) + ": ");
			printStudentData(stuArray[j]);
		}

		input.close();
	}

	private static Student1 readStudentData(Scanner scan) {

		System.out.print("Enter the student id: ");
		int id = scan.nextInt();

		System.out.print("Enter the student name: ");
		String name = scan.next();

		System.out.print("Enter the phone number: ");
		long phone = scan.nextLong();

		System.out.print("Enter the country name: ");
		String country = scan.next();

		System.out.println();

		Student1 stu = new Student1(id, name, phone, country);
		return stu;

	}

	private static void printStudentData(Student1 stud) {
		System.out.println(stud.id + " " + stud.name + " " + stud.phone + " " + stud.country);
	}

}
