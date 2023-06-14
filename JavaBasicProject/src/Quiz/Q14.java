package Quiz;

	import java.util.Scanner;
	
public class Q14 {

	public static void main(String[] args) {
		
		// Print month name for the given month number
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter month : ");
		int month = input.nextInt();

		switch (month) {

		case 1:
			System.out.println("Month " + month + " is: January");
			break;

		case 2:
			System.out.println("Month " + month + " is: February");
			break;

		case 3:
			System.out.println("Month " + month + " is: March");
			break;

		case 4:
			System.out.println("Month " + month + " is: April");
			break;

		case 5:
			System.out.println("Month " + month + " is: May");
			break;

		case 6:
			System.out.println("Month " + month + " is: June");
			break;

		case 7:
			System.out.println("Month " + month + " is: July");
			break;

		case 8:
			System.out.println("Month " + month + " is: August");
			break;

		case 9:
			System.out.println("Month " + month + " is: September");
			break;

		case 10:
			System.out.println("Month " + month + " is: October");
			break;

		case 11:
			System.out.println("Month " + month + " is: November");
			break;

		case 12:
			System.out.println("Month " + month + " is: December");
			break;

		default:
			System.out.println("Not a valid month");
			break;

		}
		input.close();
	}

}
