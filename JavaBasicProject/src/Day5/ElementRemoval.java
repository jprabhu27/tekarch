package Day5;

public class ElementRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Syntax for Array list
		
				//ArrayList<ArrayList<Integer>> list = new ArrayList<>();
				
				//int a[] = new int[5]; //declare array with size 5, starting index is 0 and ending index is 4
					int sum = 0;
				
				//storing/inserting values into array
				//a[0] = 100;
				//a[1] = 200;
				//a[2] = 300;
				//a[3] = 400;
				//a[4] = 500;
					
					int a[]={100,200,300,400,500};
					//To find the sum of an array
					
					//for (int j:a) {
					
					//sum += j;
					//System.out.println ("The sum of the arrays are: " +sum );
				//}
				
					for (int i=0; i<a.length; i++) {
						sum = sum + a[i];
						System.out.println ("The sum of the arrays are: " +sum );
					}
				//OR
				//Declare an array without specifying the size
				
			
				//list the values using enhanced for loop
					/*for(int i:a)
					{
				System.out.println(i);
						}*/
					//System.out.println("The total sum of the array is: " +sum);
					
				System.out.println("The lenght of the array is: " +a.length); //Prints length/size of an array
					
			}

		

	}


