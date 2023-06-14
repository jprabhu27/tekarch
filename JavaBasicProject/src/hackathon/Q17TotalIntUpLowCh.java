package hackathon;

import java.util.Scanner;

public class Q17TotalIntUpLowCh {

	public static void countCh(String str) {

		int count = 0;
		int uppercount = 0;
		int lowercount = 0;

		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				count++;
			} else if (Character.isUpperCase(ch)) {
				uppercount++;
			} else if (Character.isLowerCase(ch)) {
				lowercount++;
			}
		}

		System.out.println("Total number of Integers: " + count);
		System.out.println("Total number of upper case: " + uppercount);
		System.out.println("Total number of lower case: " + lowercount);
	}

	public static void main(String[] args) {
		// Q. 17 WJP to find total number of integers, uppercase and lowercase character
		// in the give string

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = input.nextLine();

		System.out.print("The final result ");

		countCh(str);
		
		input.close();
	}

}
