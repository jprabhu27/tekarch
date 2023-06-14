package AdvancedJava;

import java.util.Scanner;

public class Day5Assignment3 {

	
	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					
					//Swap arr[j] and arr[j+1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}
	}

	public static void main(String[] args) {
		// Sort the array of size n in the ascending order using
//		bubble sort
//		insertion sort
//		selection sort 
//		quick sort
//		merge sort

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = input.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {

			System.out.println("Enter the Elements of an array: ");
			arr[i] = input.nextInt();
		}

		bubbleSort(arr);
		System.out.println("Sorted Array in ascending order: ");
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i] + " ");

			input.close();
		}

	}

}
