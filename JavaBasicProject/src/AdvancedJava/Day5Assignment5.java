package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day5Assignment5 {

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {

			int temp = arr[i];
			// System.out.println("i = " + i + " temp = " + temp);
			int j = i - 1;

			// Moving the elements that are greater than temp to one position ahead of their
			// current position
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				// System.out.println("While loop j = " + j + " " + Arrays.toString(arr));
				j = j - 1; // decrement j by one
			}

//			int j;
//			for(j=i-1; j>=0 && arr[j]>temp; j--) {
//				arr[j+1]=arr[j];
//				System.out.println("While loop j = " + j + " " + Arrays.toString(arr));
//			}

			arr[j + 1] = temp; // insert the value of temp in j
			// System.out.println("Copying from temp " + Arrays.toString(arr));

		}

	}

	public static void main(String[] args) {
		// Sort the array of size n in the ascending order using
		// insertion sort : After comparing elements to the left shift elements to the
		// the right to make room to insert a value

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter the size of an array: ");
			int size = input.nextInt();
			int i;

			int[] arr = new int[size];

			for (i = 0; i < arr.length; i++) {
				System.out.println("Enter the numbers: ");
				arr[i] = input.nextInt();

			}
			System.out.println("Input array: " + Arrays.toString(arr));

			insertionSort(arr);

			System.out.println("Array after insertionSort(): " + Arrays.toString(arr));

			input.close();
		}
	}

}
