package Quiz;

public class Q24 {

	public static void main(String[] args) {
		// Write a Java program to Print the area and Perimeter of a
		// rectangle

		calcArea(6, 7);
		 calcPerimeter(4, 7);

	}

	public static void calcArea(int w, int h) {
		// Calculate the area of rectangle
		int area = w * h;
		System.out.println("The area of a rectangle is: " + area);

	}

	public static void calcPerimeter(int w, int h) {
		// Calculate the Perimeter of rectangle
		int perimeter = 2 * (w + h);
		System.out.println("The perimeter of a rectangle is: " + perimeter);
	}
}
