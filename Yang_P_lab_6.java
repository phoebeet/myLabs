import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;


class  Yang_P_lab_6 {
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
		}
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
	
	
	public static void sum(){
		int i;
		long sum = 0;
		for(i = 7; i <= 70000; i++)
			sum = sum + i;
		System.out.println(sum);	
	}
	
	
	public static void multiplication(){
		int i, j, columns, rows;
		System.out.println("Please input the number of columns in your multiplication table you want.");
		columns = getAnInt();
		System.out.println("Please input the number of rows in your multiplication table you want.");
		rows = getAnInt();
		if (columns <= 0 || rows <= 0){
			System.out.println("Please input positive integer values.");
			return;
		}
		for (i = 1; i <= rows; i++){
			for (j = 1; j <= columns; j++)
				if (j == 1)
					System.out.print(i*j);
				else if (j == columns)
					System.out.println("\t" + i*j);
				else 
					System.out.print("\t" + i*j);
				
		}
	}


	public static void fibonacci(){
		int firstnum, secondnum, sum, n, i;
		firstnum = 0;
		secondnum = 1;
		sum = 0;
		i = 0;
		System.out.println("Please input to how many entries you want to print the fibonacci sequence.");
		n = getAnInt();
		if (n <= 0){
			System.out.println("Please input positive integer values.");
			return;
		}
		for (i = 0; i < n; i++){
			if (i == 0)
				System.out.print("0, ");
			else{
				sum = firstnum + secondnum;
				firstnum = secondnum;
				secondnum = sum;
				if (i == (n-1))
					System.out.println(firstnum);
				else
					System.out.print(firstnum + ", ");
			}
		}
	}	
	
	
	public static void interest(){
		double start, rate, compoundedvalue, n;
		int years, i;
		i = 0;
		System.out.println("Input your starting balance.");
		start = getADouble();
		System.out.println("Input your interest rate in %.");
		rate = getADouble();
		n = 1 + rate/100;
		System.out.println("Input the amount of years you want compounded.");
		years = getAnInt();
		if (start < 0 || rate < 0 || years < 0){
			System.out.println("Please input positive values.");
			return;
		}
		for (i = 0; i <= years; i++){
			compoundedvalue = start*Math.pow(n, i);	
			System.out.println("Year " + i + ": Balance " + compoundedvalue);
		}
	}
	
	
	public static void picture(){
		int width, height, i, j;
		i = 1;
		j = 1;
		System.out.println("Input width.");
		width = getAnInt();
		System.out.println("Input height.");
		height = getAnInt();
		if (width <= 0 || height <= 0){
			System.out.println("Please input positive integer values.");
			return;
		}		
		for (i = 1; i <= height; i++){
			if (i%2 == 1){
				for (j = 1; j <= width; j++){
					if (j == width)
						System.out.println("*");
					else
						System.out.print("*");
				}
			} else {
				for (j = 1; j <= width; j++){
					if (j%2 == 1 && j < width)
						System.out.print("*");
					else if (j%2 == 1 && j == width)
						System.out.println("*");
					else if (j%2 == 0 && j < width)
						System.out.print("0");
					else 
						System.out.println("0");
				}
			}
		}
	}
	
	
	public static void pictureschallenge(){
		int shape, height, i, j, middle, left, right;
		System.out.println("Input 0 for diamond, 1 for x shape.");
		shape = getAnInt();
		if (shape != 0 && shape != 1){
			System.out.println("Please input 0 or 1.");
			return;
		}
		System.out.println("Input a height (must be odd number).");
		height = getAnInt();
		if (height%2 == 0 || height < 0){
			System.out.println("Please input an odd positive integer.");
			return;
		}
		middle = (height - 1)/2;
		left = right = middle;
		if (shape == 0){
			for (i = 0; i < height; i++){
				if (i <= middle) {
					left = middle - i;
					right = middle + i;
				} else {
					left += 1;
					right -= 1;
				}
				for (j = 0; j < height; j++){
					if (j == left || j == right) {
						if (j == height - 1)
							System.out.println("*");
						else
							System.out.print("*");
					} else {
						if (j == height - 1)
							System.out.println(" ");
						else
							System.out.print(" ");
					}
				}
			}
		} else {
			for (i = 0; i < height; i++){
				left = i;
				right = height - i - 1;
				for (j = 0; j < height; j++){
					if (j == left || j == right) {
						if (j == height - 1)
							System.out.println("*");
						else
							System.out.print("*");
					} else {
						if (j == height - 1)
							System.out.println(" ");
						else
							System.out.print(" ");
					}
				}
			}	
		}
	}
	
	
	public static void potshots(){
		int i, darts;
		double x, y, pi, totalDartsincircle;
		totalDartsincircle = 0;
		i = 0;
		System.out.println("Please input the amount of dart throws you would like to run.");
		darts = getAnInt();
		if (darts <= 0){
			System.out.println("Please input a positive integer.");
			return;
		}
		for (i = 0; i < darts; i++){
			x = Math.random();
			y = Math.random();
			if (Math.pow(x,2) + Math.pow(y,2) <= 1)
				totalDartsincircle += 1.0;
		}	
		pi = 4*totalDartsincircle/(double)darts;
		System.out.println("pi = " + pi);
	}
	
	
	public static void main(String args[]) {
		int inputnum = -1;
		System.out.println("Welcome to Lab06.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Sum from 7 to 70,000 program");
			System.out.println("2: Multiplication Table program");
			System.out.println("3: Fibonacci Numbers program");
			System.out.println("4: Interest Rate program");
			System.out.println("5: Picture Pattern program");
			System.out.println("6: Picture Pattern program (challenge)");
			System.out.println("7: Pot shots at Pi");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: sum();
						break;
				case 2: multiplication();
						break;
				case 3: fibonacci();
						break;
				case 4: interest();
						break;
				case 5: picture();
						break;
				case 6: pictureschallenge();
						break;
				case 7: potshots();
						break;
				default: System.out.println("Illegal value entered");
			}
		}
	}
 }//Yang_P_lab_6
