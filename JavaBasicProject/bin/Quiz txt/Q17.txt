package Quiz;

public class Q17 {

	public static void main(String[] args) {
		// find maximum of two numbers and maximum of 3 numbers using function
		// overloading

		PrintMax(10, 20);
		PrintMax(50, 80, 30);

	}

	static void PrintMax(int a, int b) {
		int max = Math.max(a, b);
		System.out.println("The maximum of two numbers " +a +"," +b +" is: " + max);
	}

	static void PrintMax(int a, int b, int c) {
		int max1 = Math.max(Math.max(a, b), c);
		System.out.println("The maximum of three numbers " +a +"," +b +"," +c +" is: " + max1);
		
	}

}
