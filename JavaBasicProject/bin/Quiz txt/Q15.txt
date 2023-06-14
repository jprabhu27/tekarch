package Quiz;

import java.util.Scanner;

public class Q15 {

	public static void main(String[] args) {
		// Print age group depending on the age value entered

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = input.nextInt();

		if (age <= 2) {
			System.out.println("Age group " + age + " is toddler");
		} else if (age > 2 && age <= 10) {
			System.out.println("Age group " + age + " is kid");
		} else if (age > 10 && age <= 18) {
			System.out.println("Age group " + age + " is children");
		} else if (age > 18 && age <= 30) {
			System.out.println("Age group " + age + " is young adult");
		} else if (age > 30 && age <= 45) {
			System.out.println("Age group " + age + " is adult");
		} else {
			System.out.println("Age group " + age + " is old adult");
		}
		input.close();
	}

}
