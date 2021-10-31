import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

class  Yang_P_lab_4 {
	static Scanner in = new Scanner(System.in);
	
	public static int getAnInt(){
		int retval = 0;
		boolean done = false;
		String dummy;
		while(!done){
			System.out.println("Enter an integer:");
			if(in.hasNextInt()){
				done = true;
				retval = in.nextInt();
			} else {
				System.out.println("Integer values only, please re-enter a valid input: ");
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
				System.out.println("Doubles only, please re-enter a valid input: ");
				dummy = in.next();
			}
		}//while
		return retval;
	}//getADouble
	
	public static int getGCD(int a, int b){ //a, b are positive integers
		int i = 1;
		int gcd = 1;
		while (i <= a && i <= b){
			if (a%i == 0 && b%i == 0)
				gcd = i;
			i++;
		} 
		return gcd;
	}
	
	public static int getLCM(int a, int b, int gcd){
			return a*b/gcd;
	}
	
	public static void Adding(){
		System.out.print("The integer you input will be added up to from 1.");
		int a = getAnInt();
		int sum = 0;
		int temp = 1;
		if (a <= 0){
			System.out.println("The integer must be greater than zero.");
			return;
		}
		while (temp <= a){
			sum += temp;
			if (temp < a)
				System.out.print(temp + " + ");
			else
				System.out.print(temp + " = " + sum);
			temp++;
		} 
		System.out.println("");
	}
	
	public static void Grading(){
		System.out.print("Input the grades. Input -1 to calculate the average of the grades. Numbers above 100 will be seen as extra credit grades!");
		double grade = getADouble();
		int num = 0;
		double sum = 0;
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int F = 0;
		while (grade != -1){
			if (grade < 0){
				System.out.println("The grade cannot be negative.");
				return;
			}
			sum += grade;
			num++;
			if (grade >= 90)
				A++;
			else if (grade >= 80)
				B++;
			else if (grade >= 70)
				C++;
			else if (grade >= 60)
				D++;
			else
				F++;
			grade = getADouble();
		}
		System.out.println("The average is: " + sum/num);
		System.out.println("A's = " + A);
		System.out.println("B's = " + B);
		System.out.println("C's = " + C);
		System.out.println("D's = " + D);
		System.out.println("F's = " + F);
	}
	
	public static void Reciprocal(){
		String s = "";
		int inputs = 0;
		int r;
		double a = 0;
		int den = 0;
		int num = 0;
		int choice;

		while (inputs < 10){
			inputs ++;
			r = getAnInt();
			if (r < 0) {
				System.out.println("Postive integers only");
				return;
			}
			else if (r == 0) {
				do{
					System.out.println("Do you want to stop adding numbers: 0 = no, 1 = yes");
					int n = getAnInt();
					if (n == 0){
						choice = 0;
						break;
					} else if (n == 1){
						choice = 1;
						break;
					} else {
						System.out.println("Illegal value entered. Please enter 0 or 1");
						choice = 2;
					} 
				} while (choice == 2);
				if (choice == 0){
					inputs--;
					continue;
				} else {
					System.out.println(s + " = " + a);
					return;
				}
			} else {
				s = s + " + 1/" + String.valueOf(r);
				a = a + (1.0/r);
			}
		}
		if (inputs == 10)
			System.out.println(s + " = " + a);
	}
	
	public static void LCMGCD(){
		int a = getAnInt();
		int b = getAnInt();
		int i = 1;
		int gcd = i;
		int lcm = i;
		if (a <= 0 || b <= 0){
			System.out.println("Illegal values entered, must be positive integers.");
			return;
		}
		gcd = getGCD(a, b);
		lcm = getLCM(a, b, gcd);
		System.out.println("The LCM of " + a + " and " + b + " is: " + lcm);
		System.out.println("The GCD of " + a + " and " + b + " is: " + gcd);
	}
	
	public static void Challenge(){
		String s = "";
		int inputs = 0;
		int r;
		int num = 0;
		int den = 0;
		int choice;
		int gcd;
		int lcm;
 		while (inputs < 10){
			inputs++;
			r = getAnInt();
			if (r < 0){
				System.out.println("Positive integers only, please");
				return;
			}
			if (r == 0) {
				do{ 
					System.out.println("Do you want to stop adding numbers: 0 for no, 1 for yes");
					int n = getAnInt();
					if (n == 0) {
						choice = 0;
						break;
					} else if (n == 1) {
						choice = 1;
						break;
					} else {
						System.out.println("Illegal value entered. Please enter 0 or 1.");
						choice = 2;
					}
				} while (choice == 2);
				if (choice == 0) {
					inputs--;
					continue;
				} else {
					System.out.println(s + " = " + num + "/" + den);
					return;
				}
			} else {
				if (den == 0) {
					den = r;
					num = 1;
					s = s + String.valueOf(num) + "/" + String.valueOf(den) + " + ";
				} else {
					gcd = getGCD(den, r);
					lcm = getLCM(den, r, gcd);
					num = (num*lcm/den + lcm/r);
					den = lcm;
					if (inputs == 10)
						s = s + "1/" + String.valueOf(r);
					else
						s = s + "1/" + String.valueOf(r) + " + ";
				}
			}
			if (inputs == 10)
				System.out.println(s + " = " + num + "/" + den);
		}
	}
	
	public static void main(String args[]) {
		int inputnum = -1;
		
		System.out.println("Welcome to Lab04.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Adding program");
			System.out.println("2: Grading program");
			System.out.println("3: Reciprocal program");
			System.out.println("4: LCM/GCD program");
			System.out.println("5: Challenge Reciprocal program");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: Adding();
						break;
				case 2: Grading();
						break;
				case 3: Reciprocal();
						break;
				case 4: LCMGCD();
						break;
				case 5: Challenge();
						break;
				default: System.out.println("Illegal value entered");
			}
		}//while
	}//main
 }//Yang_P_lab_4
