package hackathon;

import java.util.Scanner;

public class Q12PalindromeNumStr {

	public static void main(String[] args) {
		//Q12. Write a program to check palindrome (MalayalaM) for both numbers and string?

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String str = input.next();

		if (isPalindrome(str))
			System.out.println("The string is a palindrome");
		else
			System.out.println("The string is not a palindrome");

		System.out.println();

		System.out.print("Enter a number: ");
		int num = input.nextInt();

		String numStr = ((Integer) num).toString();
		if (isPalindrome(numStr))
			System.out.println("The integer is a palindrome");
		else
			System.out.println("The integer is not a palindrome");

		System.out.println();

		input.close();
	}
	
	public static boolean isPalindrome(String str) {
		// reverse the incoming str string
		String rev = "";

		for (char ch : str.toCharArray()) {
			rev = ch + rev;
		}

		return str.equalsIgnoreCase(rev);
	}

}
