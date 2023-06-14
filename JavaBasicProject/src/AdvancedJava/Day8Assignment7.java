package AdvancedJava;

import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class Day8Assignment7 {

	public static void main(String[] args) {
		// Wjp to store 4 string element and print it in reverse order(don’t use for and
		// while)

		List<String> list1 = new LinkedList<>();

		list1.add("Banana");
		list1.add("orange");
		list1.add("Apple");
		list1.add("Mango");

		System.out.println("Before sorting: " + list1);

		list1.sort(Comparator.reverseOrder());

		System.out.print("After sorting: " + list1);

	}

}
