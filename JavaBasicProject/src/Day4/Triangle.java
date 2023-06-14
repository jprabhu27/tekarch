package Day4;

public class Triangle {
	
	int base;
	int side1;
	int side2;
	int perimeter;
	int area;
	int height;
	
	public void calcPerimeter() {
		perimeter=(base+side1+side2);
	}
	public void calcArea() {
		area=(base*height)/2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle solve = new Triangle();
		
		solve.base = 4;
		solve.side1 = 5;
		solve.side2 = 3;
		solve.height = 2;
		
		solve.calcArea();
		solve.calcPerimeter();
		
		System.out.println("Area of the triangle is:" +solve.area);
		System.out.println("Perimeter of the triangle is:" +solve.perimeter);
			
		}
	}


