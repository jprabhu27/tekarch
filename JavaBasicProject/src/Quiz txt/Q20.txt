package Quiz;

public class Q20 {

	public static void main(String[] args) {
		// Find the even numbers in the given integer array of size n

		int arrayInt[] = { 10, 17, 15, 20, 18, 300 };
		
		System.out.print("The even numbers are: ");

		for (int i = 0; i < arrayInt.length; i++) {

			int a = arrayInt[i];

			if (a % 2 == 0) {
				System.out.print(a +" ");
			}

		}

	}
}
