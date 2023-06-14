package Quiz;

public class Q7 {

	public static void main(String[] args) {
		// Java program and compute the sum of the digits of an integer.

		int q = 234;
		int r;
		int sum = 0;

		while (q > 0) {

			r = q % 10;
			q = q / 10;
			sum += r;
		}

		System.out.println("The sum of digits of number is " + sum);

	}

}
