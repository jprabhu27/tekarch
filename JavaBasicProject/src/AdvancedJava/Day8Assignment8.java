package AdvancedJava;


import java.util.LinkedList;

public class Day8Assignment8 {

	public static void main(String[] args) {
		// Store 5 integer values in the linkedlist and remove duplicates if exists

		LinkedList<Integer> list1 = new LinkedList<>();

		list1.add(30);
		list1.add(9);
		list1.add(30);
		list1.add(10);
		list1.add(6);

		System.out.println("The original numbers are: " + list1);

		// Remove duplicates

		LinkedList<Integer> list2 = new LinkedList<Integer>();

		for (Integer num : list1) {

			if (!list2.contains(num)) {
				list2.add(num);
			}
		}

		System.out.println("The unique numbers are: " + list2);
	}

}
