package hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class Q6AscendingSelectionSort {

	public static void selectionSort(int[] arr) {

		int num = arr.length;

		for (int i = 0; i < num - 1; i++) {
			int minIndex = i;	//assuming the first element to be minimum of the unsorted array

			//Gives the effective size of the unsorted array
			// Determine where the lowest element is in array, store it's index in minIndex
			for (int j = i + 1; j < num; j++) {

				if (arr[j] < arr[minIndex]) {			//finds the minimum element
					minIndex = j;
				}
			}

			// Use temp variable and swap values at arr[minIndex] and arr[i] locations
			int temp = arr[minIndex];		//Putting minimum element on its proper position
			arr[minIndex] = arr[i];
			arr[i] = temp;

		}

	}

	public static void main(String[] args) {
		// Q6 WJP to perform ascending order Selection sort

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = input.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the Integer: ");
			arr[i] = input.nextInt();
		}

		System.out.println();
		System.out.println("Before sorting: " + Arrays.toString(arr));

		selectionSort(arr);

		System.out.println();
		System.out.println("After sorting in ascending order " + Arrays.toString(arr));

		input.close();
	}

}
