package hackathon;
import java.util.Scanner;

public class Q28 {

	public static long factorialRecursive(int num) {

		if (num == 1)
			return 1;
		else
			return num * factorialRecursive(num-1);
	}
	
	public static void main(String[] args) {
		// Q28. WJP to find factorial of a number using recursion

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the factorial number: ");
		int num = input.nextInt();

		if (num <= 0) {
			System.out.println("Enter the number greater than zero");
		} else {
			long result = factorialRecursive(num);
			System.out.println("The factorial of " + num + " is: " + result +" ");
		}
		input.close();
	}

}
