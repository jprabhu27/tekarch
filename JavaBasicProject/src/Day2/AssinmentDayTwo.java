package Day2;

public class AssinmentDayTwo {

	public static void main(String[] args) {
		//Putting the slash below will stop the assignmentDay2_1a() from running. Take out the slash and the program will run
		assignmentDay2_1a();
	
		assignmentDay2_1b();
				
		assignmentDay2_1c();
		
		assignmentDay2_1d();
		
		assignmentDay2_3();
		
		assignmentDay2_4();
		
		assignmentDay2_5(); 
		
		assignmentDay2_6();
		
		assignmentDay2_6switch(); 
		
		assignmentDay2_7();
		
		assignmentDay2_7b();
	}

	private static void assignmentDay2_1a() {
		int a=-5;
		int b=8;
		int c=6;
		
		System.out.println("Assignment 1a Output:");
		System.out.println("Solution for -5+8*6 is:" +(a+b*c));
		//By adding '+' outside you are concatenating the string "Solution for -5+8*6 is:" with the results of a+b*c. It is very important to put the brackets around or the result will be wrong.
		
		System.out.println("Sum of a, b and c is:" +(a+b+c));
		System.out.println("Multiplication of a, b and c is:" +(a*b*c));
		System.out.println("Subtraction of a, b, and c is:" +(a-b-c));
		System.out.println("Division of b and c is:" +(b/c));
		System.out.println("Modulo of a and c is:" + (a%c));
		System.out.println();
	}
	
	private static void assignmentDay2_1b() {
		int d=55;
		int e=9;
		
		System.out.println("Assignment 1b Output:");
		System.out.println("Sum of (55+9)%9 is:" +((d+e)% e));
		System.out.println();
	}
	
	private static void assignmentDay2_1c() {
		int a=20;
		int b=-3;
		int c=5;
		int d=8;
		
		System.out.println("Assignment 1c Output:");
		System.out.println("Sum of a+b*c/d is:" +(a+b*c/d));
		System.out.println();
	}
	
	private static void assignmentDay2_1d() {
		int a=5;
		int b=15;
		int c=3;
		int d=2;
		int e=8;
		
		System.out.println("Assignment 1d Output:");
		System.out.println("Sum of a+b/c*d-e%c is:" +(a+b/c*d-e%c));		
		System.out.println();
	}
	
	private static void assignmentDay2_3() {
		int radius =1;
		double areaOfCircle =Math.PI * radius *radius;
		double circumference = Math.PI*2*radius;
		
		//The other ways are as below:
		//double radius = 1;
        //double area1 = ((double)22/7) * radius * radius;
        //double area2 = Math.PI * radius * radius;
        //double area3 = Math.PI * Math.pow(radius, 2);
        //System.out.println("Area1 " + area1);
        //System.out.println("Area2 " + area2);
        //System.out.println("Area3 " + area3);
		
		System.out.println("Assignment 3 Output is:");
		System.out.println("Area of a circle is:" +areaOfCircle);
		System.out.println("Circumference of a circle is:" + circumference);
		System.out.println();
		
		}
			
		private static void assignmentDay2_4() {
			int width =5;
			int height=6;
			int area=width*height;
			int perimeter=2*(width+height);
			
			System.out.println("Assignment 4 output is:");
			System.out.println("Area of a rectangle is:" + area);
			System.out.println("Perimeter of a rectangle is:" + perimeter);
			System.out.println();
			
		}
		
		private static void assignmentDay2_5()  {

			int a=5;
			int b=10;
			int c;
			
			System.out.println("Assignment 5 output is:");
			System.out.println("The value of a is:" +a);
			System.out.println("The value of b is:" +b);
			System.out.println();
			//Swapping the variable from a to b and b to a
			
			c=a;
			a=b;
			b=c;
			
			System.out.println("The new value of a after swapping is:" +a);
			System.out.println("The new value of b after swapping is:" +b);
			System.out.println();
		
				}
		
		private static void assignmentDay2_6()  {
			int num = 4;
			//if statement
			if (num > 0) {
				System.out.println("The number is positive");
			}
			// if-else statement
			if (num == 0) {
				System.out.println("The number is zero");
			} else if (num > 0) {
				System.out.println("The number is positive");
			}
			else {
				System.out.println("The number is negative");
			}
			
			//Nested if statement
			if (num >= 0) 
				if (num == 0) 
					System.out.println("The number is zero");
				else 
					System.out.println("The number is positive");
			else 
				System.out.println("The number is negative");
			System.out.println();
			
		}
		private static void assignmentDay2_6switch() {
			
			//Switch Statement
				int month = 4;
		switch(month) {
		case 1:
			System.out.println("January");
			break;
		case 2:
			System.out.println("February");
			break;
		case 3:
			System.out.println("March");
			break;
		case 4:
			System.out.println("April");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		case 8:
			System.out.println("August");	
			break;
		case 9:
			System.out.println("September");
			break;
		case 10:
			System.out.println("October");
			break;
		case 11:
			System.out.println("November");
			break;
		case 12:
			System.out.println("December");
			break;
		default:
			System.out.println("The Month is: Inavlid");
			System.out.println();
		
		}
	}
		private static void assignmentDay2_7() {
			//if-elseif statement to find the largest of 3 numbers
			int x=2;
			int y=3;
			int z=4;
			if (x>y && x>z)
				System.out.println("x is largest");
			else if (y>x && y>z)
				System.out.println("y is largest");
			else
				System.out.println("z is largest");
			System.out.println();
				
		}
		private static void assignmentDay2_7b() {
			//Nested if to find the largest of 3 numbers
			int x=2;
			int y=3;
			int z=4;
			if (x>y) {
				if (x>z)
					System.out.println("x is largest");
						}
			else {
				if (y>x) {
					if (y>z)
						System.out.println ("y is largest");
					else
						System.out.println("z is largest");
				}
			}
				
		}
}
		
		

