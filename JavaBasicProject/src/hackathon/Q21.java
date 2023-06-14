package hackathon;

import java.util.Scanner;

public class Q21 {
	
	public static void main(String[] args) {
		
		//Q21. WJP to convert string to int
				
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the string: ");
			String str = input.next();
					
			try
			{
		        int num = Integer.parseInt(str);
		        System.out.println("Converted number is " + num);
			}
			catch(Exception e)
			{
				System.out.println("The string could not be converted to integer");
			}
	        input.close();
	
		}
}
