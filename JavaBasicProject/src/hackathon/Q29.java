package hackathon;

import java.util.Scanner;
import java.util.Arrays;

public class Q29 {

	public static void mergeSort(int array[], int start, int end) {
		if (start != end) {

			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	public static void merge(int array[], int start, int mid, int end) { // creating a merge function
		int i = start;
		int j = mid + 1;
		int k = 0;

		int[] temp = new int[end - start + 1]; 
		while (i <= mid && j <= end) { 
			if (array[i] <= array[j]) { 
				temp[k] = array[i]; 
				i++; 
			} 
			else {
				temp[k] = array[j]; 
				j++; 
			}
			k++;
		}

		while (i <= mid) { 
			temp[k] = array[i]; 
			i++; 
			k++; 
		}

		while (j <= end) {
			temp[k] = array[j]; 
			j++; 
			k++; 
		}

		k = 0; 

		for (i = start; i <= end; i++) {
			array[i] = temp[k]; 
			k++;
		}

	}

	public static void main(String[] args) {
		
		//Q29. WJP to perform Merge sort using recursion

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = input.nextInt();
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {

			System.out.print("Enter the element: ");
			array[i] = input.nextInt();
		}
		System.out.println();

		System.out.println("Input array: " + Arrays.toString(array));

		mergeSort(array, 0, array.length - 1);

		System.out.println("Sorted array: " + Arrays.toString(array));

		input.close();
	}

}