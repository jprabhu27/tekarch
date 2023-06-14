package Quiz;

import java.util.Scanner;

public class Q16 {

	public static void main(String[] args) {
		// Find an element in a array of elements

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number: ");
		int a = input.nextInt();
		boolean foundIndex = false;

		int arrA[] = { 100, 200, 300, 400 };

		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] == a) {
				System.out.println("The element found in an array at index " + i);
				foundIndex = true;
			}

		}
		if (foundIndex == false) {
			System.out.println("Element not found in an array");
		}
		input.close();
	}

}
