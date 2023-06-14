package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day5Assignment8 {

	// Create a static method quickSort which takes an integer array and two int
	// variables as parameters

	public static void quickSort(int[] arr, int low, int high) {
		
		if (low < high) { // check if the value of the low variable less than the value of high variable
			
			int pivotIndex = partition(arr, low, high); // Calling a method partition and assigning the
			// returned value to the integer variable "pivotIndex"
			
			quickSort(arr, low, pivotIndex - 1); // calling the quick sort method recursively with the same
			// integer array arr and the values of "low" and "pivotIndex -1" as
			// new parameters
			
			quickSort(arr, pivotIndex + 1, high); // calling the quick sort method recursively with the same
			// integer array arr and the values of "low" and "pivotIndex +1" as
			// new parameters
		}
	}

	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];	// Assigns the value of the last element of the integer 
								// array "arr" to integer variable pivot
		
		int i = low - 1; 		// This variable will be used to keep track of the 
								// index of the last element in the left subarray.
		
		for (int j = low; j < high; j++) {// Initializing for loop starts with value of 'low' 
											// and ends with the value of 'high-1'
		
			if (arr[j] <= pivot) { // Checks if the value of the element at index "j" of the integer array 'arr'
									// is less than or equal to the value of integer variable 'pivot'
				i++; 				// increments by 1
				
				int temp = arr[i]; // assigns value of the element of index 'i' of the integer array "arr" to the
									// integer variable "temp"
				
				arr[i] = arr[j]; // Assigns value of the element of index 'j' of the integer array 'arr to the
									// element at index 'i' of the same array
				
				arr[j] = temp; // Assigns value of the integer variable "temp" to the
								// element at index 'j' of the integer array "arr"
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		// Sort the array of size n in the ascending order using
		// Quick Sort
		// You pick one number as pivot and then on the left side will all be the lower
		// numbers tha piovt
		// and on the right side all the higher numbers
		// after partitioning the last number will be the pivot for left part and the
		// pivot will do the partitioning
		// Same for the right side

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = input.nextInt();
		int[] arr = new int[size];

		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}

		input.close();
		quickSort(arr, 0, size - 1);
		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(arr));
	}

}
