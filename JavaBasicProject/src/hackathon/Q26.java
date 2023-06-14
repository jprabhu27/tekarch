package hackathon;

import java.util.Arrays;
import java.util.Scanner;

public class Q26 {

	public static void main(String[] args) {
		// Q26. WJP to merge two sorted array.(Do not use third array)
		// array1[10] = 1,2,4,6,9,10 array2[4] = 3, 5,7,8
		// After merge : array1[10] = 1,2,3,4,5,6,7,8,9,10

		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter array1 size: ");
			int size1 = input.nextInt();
			System.out.print("Enter array2 size: ");
			int size2 = input.nextInt();
			System.out.println();

//		int[] array1 = {1, 2, 4, 6, 9, 10, 0, 0, 0, 0}; 
//        int[] array2 = {3, 5, 7, 8 };
			
			int[] array1 = new int[size1 + size2]; // array1 has a buffer space for array2
			int[] array2 = new int[size2];
			int i;

			System.out.println("Enter sorted list of elements for array1:");
			for (i = 0; i < size1; i++) {
				System.out.print("Enter number: ");
				array1[i] = input.nextInt();
			}
			System.out.println();
			System.out.println();

			System.out.println("Enter sorted list of elements for array2:");

			for (i = 0; i < size2; i++) {
				System.out.print("Enter number: ");
				array2[i] = input.nextInt();
			}
			System.out.println();
			System.out.println();

			System.out.println("array1: " + Arrays.toString(array1));
			System.out.println("array2: " + Arrays.toString(array2));
			mergeArrays(array1, size1, array2, size2);
			System.out.println("After Merge array1: " + Arrays.toString(array1));

			input.close();
		}
	}

	public static void mergeArrays(int[] arr1, int size1, int[] arr2, int size2) {
		int i = size1 - 1;	//represents the index of the last element in arr1
		int j = size2 - 1;	//repersent the index of the last element in arr2
		int k = size1 + size2 - 1; //represents the index of the last element in the 
										//merged array ('arr1)
		
//While loop continues till both i and j are > or = '0' (indicating that there are elements left
		//in both arr1 and arr2 to be merged
		
		while (i >= 0 && j >= 0) {
			if (arr1[i] >= arr2[j]) {	// if true
				arr1[k] = arr1[i];   //current element of arr1 should be placed at the k index of arr1
				i--;	//i is decremented to move to the previous element in arr1
			} else {
				arr1[k] = arr2[j]; //current element from arr2 should be placed at the k index of arr1
				j--; //j is decremented to move to the previous element in arr2
			}
			k--; 	//k is decremented to move to the previous index in 'arr1'
		}

		//Second while loop for the elements still left in arr2 that were not merged
		while (j >= 0) {
			arr1[k] = arr2[j]; //copies the remaining elements from arr2 to the remaining positions i arr1 starting from index k
			j--;		//j is decremented
			k--;		//k is decremented
		}
	}
}