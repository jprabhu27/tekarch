package hackathon;

import java.util.Scanner;

public class Q22 {

	public static void main(String[] args) {
		//Q22. WJP to convert int to string
				
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = input.nextInt();
		
		System.out.println("The number converted to string is: " + ((Integer)num).toString());
		
        input.close();
	}

}

