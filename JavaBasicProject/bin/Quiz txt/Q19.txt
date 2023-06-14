package Quiz;

public class Q19 {

	public static void main(String[] args) {
		// java program to print area of triangle and circle

		calcAreaTriangle(4,5);
		calcAreaCircle(2);

	}

	public static void calcAreaTriangle(int base, int height) {

		
		int area = (base * height) / 2;
		System.out.println("The area of triangle is: " + area);

	}

	public static void calcAreaCircle(int radius) {

		
		double area = Math.PI * radius * radius;
		System.out.println("The are of circle is: " + area);
	}
}
