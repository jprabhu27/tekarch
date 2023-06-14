package Day4;

public class Average {
	
	double num1;
	double num2;
	double num3;
	double ave;
	
	Average(double num1,double num_2, double num_3)
	
	{
		this.num1= num1;
		num2= num_2;
		num3= num_3;
	}
	
	public void calcAverage()
	{
		ave=(num1+num2+num3)/3;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Average a1= new Average(3.3,3.3,3.2); 
		
		a1.calcAverage();
		
		System.out.println("The average of 3 numbers is:" +a1.ave);
	}

}
