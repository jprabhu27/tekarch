package hackathon;

import java.util.Scanner;

public class Q23 {

	public static void main(String[] args) {
		// Q23. WJP to differentiate input as string, int or bool?

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string, int or bool: ");
		String str = input.next();
		
		if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
			System.out.println("Input is a boolean.");
		}
		else {
			try
			{
		        Integer.parseInt(str);
		        System.out.println("Input is an integer");
			}
			catch(Exception e1)
			{
				System.out.println("Input is a string");
			}
		}	
        input.close();
	}
}
