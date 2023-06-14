package hackathon;

import java.util.Scanner;

public class Q13ReverseString {

	public static void main(String[] args) {
		// Q13. Given a string print the reverse of the string.(Input: Java Code Output:
		// edoC avaJ)

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.nextLine();

		
		StringBuilder reverse = new StringBuilder(str).reverse();
		String result = reverse.toString();

		System.out.print("The reversed string is: " + result);

		input.close();
	}
}
