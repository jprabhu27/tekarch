package Day3;

import java.util.Scanner;

public class ExerciseTwo {

	public static void main(String[] args) {
		//part1();
		//part2();
		//part3();
		part4();
	}
	
	public static void part1() {
		//Multiplication table using FOR LOOP
		int num=4;
		for(int i=1; i<=10; i++) {
			
						
			System.out.println(num+" * " +i +" = " +num*i);
			
		}
		/*Multiplication table using WHILE LOOP
		int k=1;
		while (k<=10) {
			System.out.println(num+" * " +k +" = " +num*k);
			k++;
			*/
		}
	
	//Finding the largest,middle,smallest number
	public static void part2() {
		System.out.println("Exercise# 2");
		try (Scanner sc = new Scanner(System.in)) {
			int num1, num2, num3;	
			
			System.out.print("Enter the first number:");
			num1= sc.nextInt();
			System.out.print("Enter the second number:");
			num2= sc.nextInt();
			System.out.print("Enter the third number:");
			num3 = sc.nextInt();
			
			int max,mid,min;
			if(num1 >= num2 && num1>=num3) {
				max = num1;
				mid = Math.max(num2, num3);
				min = Math.min(num2, num3);
			}
			else if(num2 >= num1 && num2>=num3) {
				max = num2;
				mid = Math.max(num1, num3);
				min = Math.min(num1, num3);
			}
			else {
				max = num3;
				mid = Math.max(num1, num2);
				min = Math.min(num1, num2);
			}
			
			
			System.out.println("Biggest:" + max + " Middle: " + mid + " Smallest: " + min);
			sc.close();
		}
						
		
	}
	//Swapping two variables without the third variable
	public static void part3() {
		
		int x=15;
		int y=10;
		
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println("after swapping x is:" +x);
		System.out.println("after swapping y is:" +y);
	}
	
	//Finding revised salary
	public static void part4() {
		
	int exp=6;			;
	double old_salary=1000;
	double revised_salary=old_salary;
	boolean reward= true;
	
	if (exp>=3 && exp<=5)
		revised_salary = old_salary + 0.1 * old_salary;
	else if (exp>=6 && exp<=9)
		revised_salary = old_salary + 0.15 * old_salary;
	else if (exp>=10 && exp<=20)
		revised_salary = old_salary + 0.2 * old_salary;
	else 
		revised_salary = old_salary + 0.25 * old_salary;
	
	if (reward == true)
		revised_salary = revised_salary + 1000;
	 
	System.out.println("Employer experience is:" +exp);
	System.out.println("Old Salary is:" + old_salary);
	System.out.println("Revised Salary is:" +revised_salary);
	
	}
}
