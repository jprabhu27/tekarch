package AdvancedJava;

import java.util.HashSet;
//import java.util.Objects;
import java.util.Set;

class Student {
	private String name;
	private int id;
	private String major;

	// Define the instance variables 'name', 'id', and 'major' and the constructor
	// that initializes these variables

	public Student(String name, int id, String major) {
		this.name = name;
		this.id = id;
		this.major = major;
	}

	// These methods are getters for the 'name', 'id', and 'major' instance
	// variables

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getMajor() {
		return major;
	}

	// This method overrides the 'equals' method inherited from the 'Object' class.
	// Simply put, these methods(equals() and hashcode() work together to verify if
	// two objects have the same values.

	@Override
	public boolean equals(Object obj) {
		// Cast obj to Student type and then compare id using getter
		return this.getId() == ((Student) obj).getId();

	}

	// hashCode method is overridden to calculate the hash value of the 'id'
	// instance variable

	@Override
	public int hashCode() {
		return Integer.hashCode(id); // hashCode is available on objects. Since id is int, use 
										//Integer wrapper class
	}

}

public class Day8Assignment9 {

	public static void main(String[] args) {

		// Store 5 student(name,id,major) object in hashset.if 2 objects has same id
		// consider them as duplicate objects.

		// Create a new HashSet 'set' to store the Student objects
		// When items will be added, HashSet will not store duplicates

		Set<Student> set = new HashSet<>();
		set.add(new Student("Bob", 1, "Computer Science"));
		set.add(new Student("Kavita", 2, "Commerce"));
		set.add(new Student("Sheila", 1, "Biology"));
		set.add(new Student("Pablo", 3, "Physics"));
		set.add(new Student("Jasmine", 4, "Psychology"));

		System.out.println("The set with Duplicates removed:\n");

		for (Student stu : set) {
			System.out.println(stu.getName() + "-" + stu.getId() + "-" + stu.getMajor());
		}

	}

}
