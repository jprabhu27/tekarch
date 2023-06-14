package hackathon;

import java.util.Arrays;

public class Q32 {

	public static void main(String[] args) {
		
//		Q32. You are given two sorted arrays, A and B, and A has a large enough buffer 
//		at the end to hold B. 
//		Write a method to merge B into A in sorted order.
		
		int[] A = {10, 30, 50, 0, 0, 0, 0}; // A has a buffer space for B
        int[] B = {20, 40, 60, 70};

        int numA = 3;
        int numB = 4;
        
        mergeArrays(A, numA, B, numB);

        System.out.println("After Merge: " + Arrays.toString(A));

	}

	public static void mergeArrays(int[] arr1, int numArr1, int[] arr2, int numArr2) {
        int i = numArr1 - 1;
        int j = numArr2 - 1;
        int k = numArr1 + numArr2 - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
    }
}
