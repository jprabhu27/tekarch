package hackathon;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Q5UniqueNumbers {

	public static void main(String[] args) {
		// Q5. Given an array prints the unique numbers and also print the
		// number of occurrences of duplicate numbers.

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = input.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the Integer: ");
			arr[i] = input.nextInt();
		}
		// Counting occurrences
		Map<Integer, Integer> numCount = new HashMap<>();

		for (int num : arr) {

			if (numCount.containsKey(num)) {
				int count = numCount.get(num);
				numCount.put(num, count + 1);
			} else {
				numCount.put(num, 1);
			}
		}

		// Unique numbers
		System.out.println("The unique numbers ");

		for (int num : numCount.keySet()) {

			if (numCount.get(num) == 1) {
				System.out.print(num + " ");
			}
		}

		System.out.println();

		// Occurrences of duplicate numbers
		System.out.println("Occurences and Duplicate ");

		for (int num : numCount.keySet()) {
			if (numCount.get(num) > 1) {
				System.out.println("Duplicate numbers: " + num + " Number of occurrences " + numCount.get(num));
			}
		}
		input.close();
	}
}
