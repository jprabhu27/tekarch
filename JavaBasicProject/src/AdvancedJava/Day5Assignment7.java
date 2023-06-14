package AdvancedJava;

//import java.util.Arrays;
import java.util.Scanner;

public class Day5Assignment7 {

	// Function to swap elements
	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	// Selection sort function

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { // for each i from 0 to 4
			// find index of smallest element

			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) { // if arr[j] is smaller than arr[min]
					min = j; // updating the min
				}

			}
			swap(arr, i, min); // swap the smallest to front

		}

	}

	public static void main(String[] args) {
		// Sort the array of size n in the ascending order using
		// Selection Sort

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size: ");
		int size = input.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {

			System.out.print("Enter the element: ");
			arr[i] = input.nextInt();
		}
		System.out.println();

		// Printing the initial array
		System.out.print("Array before sorting: ");

		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();

		// Calling the sort function
		sort(arr);

		// Printing the sorted array
		System.out.print("Array after sorting: ");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}

		input.close();
	}

}
