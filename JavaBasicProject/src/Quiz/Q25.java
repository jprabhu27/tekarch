package Quiz;

public class Q25 {

	public static void main(String[] args) {
		// Print the patterns
		
		p1();
		p2();
		p3();
		p4();
		p5();

	}

	public static void p1() {
		// Print the pattern 12345.....

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(j);
			}
			System.out.println();

		}
		System.out.println();
	}

	public static void p2() {
		// Print the pattern 11111, 22222.....

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void p3() {
		// Print the pattern 1, 11, 111....

		int n = 4;
		
		for (int i = 1; i <= n; i++) {
			
			for (int j=1; j<=i; j++)
			System.out.print("1");
			System.out.println();
		}
		System.out.println();
	}

	public static void p4() {

		// Print the pattern 1, 111, 11111...
		int rows = 4;
		int cols = 1;

		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= cols; j++) {

				System.out.print("1");
			}
			cols += 2;
			System.out.println();
		}
		System.out.println();
	} 
	public static void p5() {
		
		// Print the pattern 12345,1234,123,12,1
		int rows = 5;
		int cols =5;
		
		for (int i=1; i<=rows; i++) {
			
			for (int j=1; j<=cols; j++) {
				System.out.print(j);
			}
			cols-=1;
			System.out.println();
		}
		
	}
}
