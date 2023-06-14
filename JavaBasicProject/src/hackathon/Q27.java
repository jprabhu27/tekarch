package hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class Q27 {

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) { 
			int pivotIndex = partition(arr, low, high); 
			quickSort(arr, low, pivotIndex - 1); 
			quickSort(arr, pivotIndex + 1, high); 
		}
	}
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1; 
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) { 
				i++; 
				int temp = arr[i]; 
				arr[j] = temp; 
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		//Q27. WJP to perform ascending order Quick sort
		
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
