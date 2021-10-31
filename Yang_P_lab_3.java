import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

class  Yang_P_lab_3 {
	static Scanner in = new Scanner(System.in);
	
	public static int getAnInt(){
		int retval = 0;
		boolean done = false;
		String dummy;
		while(!done){
			System.out.println("Enter an integer from 0, 1, or 2:");
			if(in.hasNextInt()){
				done = true;
				retval = in.nextInt();
			} else {
				System.out.println("Sorry, integer values only.");
				dummy = in.next();
			}
		}//while
		return retval;
	}//getAnInt
	
	public static double getADouble(){
		double retval = 0;
		boolean done = false;
		String dummy;
		while(!done){
			System.out.println("Enter a double: ");
			if(in.hasNextDouble()){
				done = true;
				retval = in.nextDouble();
			} else {
				System.out.println("Sorry, doubles only.");
				dummy = in.next();
			}
		}//while
		return retval;
	}//getADouble
	
	public static void Quadratic(){
		System.out.print("Input your A value: ");
		double A = getADouble();
		System.out.print("Input your B value: ");
		double B = getADouble();
		System.out.print("Input your C value: ");
		double C = getADouble();
		double discriminant = B*B - 4*A*C;
		if (discriminant < 0) {
			double imagdisc = Math.abs(discriminant);
			double imag = (Math.sqrt(imagdisc)/(2*A));
			double realpart = -B/(2*A);
			System.out.println("Imaginary roots. The roots are " + realpart + " + " + imag + "i and " + realpart + " - " + imag + "i");
		} else if (discriminant >= 0){
			double posroot = (-B + Math.sqrt(discriminant))/(2*A);
			double negroot = (-B - Math.sqrt(discriminant))/(2*A); 
			if (discriminant == 0){
				System.out.println("Double roots. The roots both are " + posroot);
			} else {
				System.out.println("Two real roots. The roots are " + posroot + " and " + negroot);
			}
		}			
	}
	
	public static void Pythagorean(){
		System.out.println("Input -1 for the unknown side length that you want to find.");
		System.out.print("Input the length of the first leg: ");
		double a = getADouble();
		System.out.print("Input the length of the second leg: ");
		double b = getADouble();
		System.out.print("Input the length of the hypotenuse: ");
		double c = getADouble();
		if (a == -1){
			if ((b == -1) || (c == -1)){
				System.out.println("Invalid. Only one value may be -1.");
			} else if ((b <= 0) || (c <= 0)){
				System.out.println("Invalid. Known lengths may not be zero and below.");
			} else {
				a = Math.sqrt(c*c - b*b);
				System.out.println("The value of the first leg is " + a);
				System.out.println("Angle A = " + Math.asin(a/c) + " radians, Angle B = " + Math.asin(b/c) + " radians");
			}
		} else if (b == -1){
			if (c == -1){
				System.out.println("Invalid. Only one value may be -1.");
			} else if ((c <= 0) || (a <= 0)) {
				System.out.println("Invalid. Known lengths may not be zero and below.");
			} else {
				b = Math.sqrt(c*c - a*a);
				System.out.println("The value of the second leg is " + b);
				System.out.println("Angle A = " + Math.asin(a/c) + " radians, Angle B = " + Math.asin(b/c) + " radians");
			}
		} else if (c == -1) {
			if ((b <= 0) || (a <= 0)) {
				System.out.println("Invalid. Known lengths may not be zero and below.");
			} else {
				c = Math.sqrt(a*a + b*b);
				System.out.println("The value of the hypotenuse is " + c);
				System.out.println("Angle A = " + Math.asin(a/c) + " radians, Angle B = " + Math.asin(b/c) + " radians");
			}
		} else {
			System.out.println("No unknown side.");
		}
	}
	
	public static void main(String args[]) {
		int inputnum = -1;
		
		System.out.println("Welcome to Lab03.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Quadratic Formula program");
			System.out.println("2: Pythagorean Theorem program");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: Quadratic();
						break;
				case 2: Pythagorean();
						break;
				default: System.out.println("Illegal value entered");
			}
		}//while
	}//main
 }//Yang_P_lab_3
