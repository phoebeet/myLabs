import java.io.*;
import java.util.Random;
import java.util.Scanner;

class  Lab02 {
	static Scanner in = new Scanner(System.in);

	public static void BMI() {
		System.out.println("PROGRAM 1");
		System.out.print("Weight (lbs):");
		double weight = in.nextDouble();
		System.out.print("Height (in):");
		double height = in.nextDouble();
		double BMI = (weight*703)/(height*height);
		System.out.println("Your BMI is " + BMI);
		if (BMI < 18.5) {
			System.out.println("You are underweight");
		} else if ((BMI >= 18.5) && (BMI < 25)) {
			System.out.println("You are normal weight");
		} else if ((BMI > 25) &&(BMI < 30)) {
			System.out.println("You are overweight");
		} else {
			System.out.println("You are obese");
		}
		System.out.println("");
		System.out.println("");
	}//BMI

	public static void Scores() {
		System.out.println("PROGRAM 2");
		System.out.print("Total points on exam:");
		int total = in.nextInt();
		System.out.print("Points received:");
		int student = in.nextInt();
		int score = (100*student/total);
		if (score < 60) {
			System.out.println("F");
		} else if ((score >= 60) && (score < 70)) {
		   System.out.println("D");
		} else if ((score >= 70) && (score < 80)) {
			System.out.println("C");
		} else if ((score >= 80) && (score < 90)) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
		System.out.println("");
		System.out.println("");
	}//Scores


	public static void Parity() {
		System.out.println("PROGRAM 3");
		System.out.print("Input an integer:");
		int num = in.nextInt();
		if (num%2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");   
		}
		System.out.println("");
		System.out.println("");
	}//Parity
	
	public static void Multiples() {
		System.out.println("PROGRAM 4");   
		System.out.print("First number: ");
		int first = in.nextInt();
		System.out.print("Second number: ");
		int second = in.nextInt();
		if (second%first == 0){
			System.out.println("The first number is a multiple of the second number.");
		} else {
			System.out.println("The first number is not a multiple of the second number.");
		}
		System.out.println("");
		System.out.println("");
	}//Multiples
 
	public static void Fivedigits() {
		System.out.println("PROGRAM 5");
		System.out.print("Input a five-digit integer: ");
		int five = in.nextInt();
		int d5 = five/10000;
		int d4 = five/1000 - 10*d5;
		int d3 = five/100 - 100*d5 - 10*d4;
		int d2 = five/10 - 1000*d5 - 100*d4 - 10*d3;
		int d1 = five%10;
		System.out.println(d5 + "   " + d4 + "   " + d3 + "   " + d2 + "   " + d1);
		System.out.println();
		System.out.println();
	}//Fivedigits
	
	public static void main(String args[]) {
		int inputnum = -1;
		
		System.out.println("Welcome to Lab02.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: BMI program");
			System.out.println("2: Scores program");
			System.out.println("3: Parity program");
			System.out.println("4: Multiples program");
			System.out.println("5: Five Digits program");
			System.out.println();
			
			inputnum = in.nextInt();
			
			switch (inputnum){
				case 0: break;
				case 1: BMI();
						break;
				case 2: Scores();
						break;
				case 3: Parity();
						break;
				case 4: Multiples();
						break;
				case 5: Fivedigits();
						break;
				default: System.out.println("Illegal value entered");
			}
		}//while
	}//main
 }//Lab02
