package AdvancedJava;

import java.util.Scanner;
import java.util.Arrays;

public class Day5Assignment6 {

	public static void mergeSort(int array[], int start, int end) {
		// System.out.println("mergeSort(a, " + start + ", " + end + ")");

		// if start != end then it means there are two or more elements, continue
		// recursion
		// if start == end then it means it is only element, we found leaf of the tree,
		// stop recursion

		// First Part
		if (start != end) {

			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}

	}

	// Second part
	public static void merge(int array[], int start, int mid, int end) { // creating a merge function
		// System.out.print("merge(a, " + start + ", " + mid + ", " + end + ") ");

		// setting i, j and k
		int i = start;
		int j = mid + 1;
		int k = 0;

		int[] temp = new int[end - start + 1]; // Setting up the temp array

		// now we have to create an underline /a boundary for i and j
		// Boundary for i goes from start to mid inclusively
		// Whereas j goes from mid plus one and to the end inclusively

		while (i <= mid && j <= end) { // We ask i and j which one has the smaller number to put into the temp

			if (array[i] <= array[j]) { // check if i is smaller than j
				temp[k] = array[i]; // if i is smaller than we put it into temp: K
				i++; // then we move i up

			} else {
				// if j has the smaller number
				temp[k] = array[j]; // then temp: k will be the number that the number j is at
				j++; // then we move j up

			}
			k++;
		}
		// the above while loop is finished when i goes outside the boundary for the
		// left sub array or j goes out
		// of the boundary for the right sub array

		// if j goes out of the boundary for the right sub array then we will use the
		// while loop as below
		// for the left sub array i

		while (i <= mid) { // When i is still within the boundary
			temp[k] = array[i]; // copy the value of i to temp: k
			i++; // increment i by one or move up
			k++; // move up k
		}

		// if i goes out of the boundary for the left sub array then we will use the
		// while loop as below
		// for the right sub array j

		while (j <= end) {
			// When j is still within the boundary

			temp[k] = array[j]; // Copy the value of j to temp
			j++; // move up j
			k++; // move up k
		}

		// After these both while loop now we know that both i and j are outside of
		// their boundary
		// Which means the merge is finished and we need to move the temporary array
		// into our original array

		k = 0; // we set the k back to zero so it is at the beginning of the array

		for (i = start; i <= end; i++) {
			array[i] = temp[k]; // We copy the temporary array to our original array from start to end
			k++;
		}

//		System.out.print(" temp = " + Arrays.toString(temp));
//		System.out.println(" array = " + Arrays.toString(array));
	}

	public static void main(String[] args) {

		// // Sort the array of size n in the ascending order using
		// merge sort

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
