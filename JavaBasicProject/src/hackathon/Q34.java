package hackathon;

import java.util.Scanner;

public class Q34 {

	public static void main(String[] args) {
		// Q34. Write a method to implement *, - , / operations. 
		//You should use only the + operator
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number for 'a': ");
		int a = input.nextInt();
		
		System.out.print("Enter the number for 'b': ");
		int b = input.nextInt();
		
		System.out.println("a * b = " + multiply(a, b));
		System.out.println("a - b = " + subtract(a, b));
		System.out.println("a / b = " + divide(a, b));
		
		input.close();
	}

    public static int multiply(int a, int b) {
        int result = 0;
        boolean isNegative = (b < 0);
        
        if (isNegative) {
            b = negate(b);
        }
        
        while (b > 0) {
            result += a;
            b--;
        }
        
        if (isNegative) {
            result = negate(result);
        }
        
        return result;
    }
    
    public static int subtract(int a, int b) {
        return a + negate(b);
    }
    
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        
        boolean isNegative = (a < 0) || (b < 0);
        
        a = negate(Math.abs(a));
        b = Math.abs(b);
        
        int quotient = 0;
        while (a <= 0) {
            a += b;
            quotient++;
        }
        
        quotient--;
        
        if (isNegative) {
            quotient = negate(quotient);
        }
        
        return quotient;
    }
    
   
    private static int negate(int num) {
    	// For example, if num=5, the Bitwise complement (~) operator ~num will return -6
    	// Adding 1 to it will effectively end up negating the num
        return ~num + 1;
    }


}
