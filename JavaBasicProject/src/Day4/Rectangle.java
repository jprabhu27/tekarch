package Day4;

public class Rectangle {

	int rectangle1;
	int rectangle2;
	int length;
	int width;
	int area;
	
	
	Rectangle(int len, int wid)
	{
		this.length= len;
		this.width= wid;
		
	}
	
	public void calcArea() 
	{
		area=(length*width);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle r1=new Rectangle(4,5);
		Rectangle r2=new Rectangle(5,8);
		
		r1.calcArea();
		r2.calcArea();
		
		System.out.println("The area of the rectangle r1 is:" +r1.area);
		System.out.println("The area of the rectangle r2 is:" +r2.area);

	}

}
