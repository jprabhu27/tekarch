package AdvancedJava;

import java.util.LinkedList;
import java.util.List;

public class Day8Assignment6 {

	public static void main(String[] args) {
		// Write a java program to Store 5 integer values in linkedlist and sort in
		// ascending order.

		List<Integer> list1 = new LinkedList<>();

		list1.add(30);
		list1.add(8);
		list1.add(60);
		list1.add(25);
		list1.add(20);

		System.out.print("The list before sorting: " + list1);

		for (int i = 0; i < list1.size() - 1; i++) {
			for (int j = i + 1; j < list1.size(); j++) {
				if (list1.get(i) > list1.get(j)) {
					int temp = list1.get(i);
					list1.set(i, list1.get(j));
					list1.set(j, temp);

				}
			}

		}

		System.out.println();
		System.out.println("The list after sorting:" + list1);

	}

}
