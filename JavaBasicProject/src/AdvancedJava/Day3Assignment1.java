package AdvancedJava;

import java.util.Arrays;
import java.util.Scanner;

public class Day3Assignment1 {

	public static void main(String[] args) {
		// 1. convert an array to string in Java.
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int n =input.nextInt();
		System.out.println();
		
		int [] array = new int [n];

		for (int i=0; i < n; i++)
		{
			System.out.print("Enter number: ");
			array[i] = input.nextInt();
		}
		
		//String str = Arrays.toString(array);
		System.out.println("String representation of array you entered is: " + Arrays.toString(array));
		
		input.close();
	}


}
