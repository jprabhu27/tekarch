package Quiz;

public class Q21 {

	public static void main(String[] args) {
		// Swap 2 numbers without using the 3rd variable.

		int x = 10;
		int y = 20;

		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("The value of x after swapping is: " + x);
		System.out.println("The value of y after swapping is: " + y);

	}

}
