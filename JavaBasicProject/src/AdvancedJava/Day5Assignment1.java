package AdvancedJava;

import java.util.Scanner;

// Custom exception class
@SuppressWarnings("serial")
class OddNumberEnteredException extends Exception {

	public OddNumberEnteredException(String message) {
		super(message);
	}

}

public class Day5Assignment1 {

	public static void main(String[] args) {
		// Take even number from user
		// If user enters odd number it should throw your exception called
		// OddNumberEnteredException
		// and loop the program until he enters right input
		// and print "You entered even number" and stops

		Scanner input = new Scanner(System.in);

		boolean retry;
		do {
			try {
				System.out.print("Enter the even number: ");
				int num = input.nextInt();

				if (num % 2 == 0) {
					System.out.println("You entered even number");
					retry = false;
				} else {
					System.out.println("About to throw custom exception because user entered odd number");
					throw new OddNumberEnteredException("oh no you entered an odd number!");
				}
			}
//			catch (OddNumberEnteredException e) {
//				System.out.println("Hey that was't even number, please try again.\n");
//				input.nextLine(); // Discard the invalid input
//				retry = true;
//			} 
			catch (Exception e) {
				// System.out.println(e.toString());
				System.out.println("Unexpected exception caught " + e.toString() + ". Please try again.\n");
				input.nextLine(); // Discard the invalid input
				retry = true;
			}
		} while (retry == true); // User did not enter even number, loop again

		input.close();
		System.out.println("Good bye!");
	}

}
