package Day4;

import java.util.Scanner;

public class NewScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Instantiation of variables
		Scanner input = new Scanner(System.in);
		
		Float x, y, z;
		double sum, difference, product, quotient, average;
		
		//Users will enter the numbers
		
		System.out.print("Enter the first number:  ");
		 x = input.nextFloat();  //Read user input
		 
		 System.out.print("Enter the second number:  ");
		 y = input.nextFloat(); //Read user input
		 
		 System.out.print("Enter the third number: ");
		 z= input.nextFloat();//Read user input
		
		//Solving
		sum= x + y;
		difference= x-y;
		product= x*y;
		quotient= x/y;
		
		
		//Print results
		System.out.println("Sum: " +sum);
		System.out.println("Difference: " +difference);
		System.out.println("Product: " +product);
		System.out.println("Quotient: " +quotient);
		
		
		String name;
		int age;
		String gender;
		String address;
		
		//Solving
		
		average=(x+y+z)/3;
		
		System.out.print("The Sum of the number is: " + sum + "  ");
		//sum= input.nextDouble();
		
		System.out.print("The Average of the number is: " + average);
		//average= input.nextDouble();
		
		//Users will enter 
//		input.nextLine();
//		System.out.print("Enter name: " +"             ");
//		name= input.nextLine();
//		
//		System.out.print("Enter age: "+"       ");
//		age= input.nextInt();
//		
//		input.nextLine();
//		System.out.print("Enter gender: ");
//		gender= input.nextLine();
//		input.next();
//		
//		System.out.print("Enter address: ");
//		address= input.nextLine();
		System.out.println();
		System.out.println();
		System.out.println("Enter Name, Age, Gender, and Address");
		name = input.next();
		age = input.nextInt();
		gender = input.next();
		address = input.nextLine();
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Address: " + address);
		
		input.close();
	}

}
