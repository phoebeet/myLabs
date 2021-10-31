import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

class  Yang_P_lab_5 {
	static Scanner in = new Scanner(System.in);
	
	public static int getAnInt(){
		int retval = 0;
		boolean done = false;
		String dummy;
		while(!done){public static void (){

	}
	
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
	
	public static void Guess(){
		int randomnumber;
		int guesses = 0;
		int guess;
		Random myrand = new Random();
		randomnumber = myrand.nextInt(1000);
		while (true) {
			guesses++;
			System.out.print("Please guess an integer between 1 and 1000: ");
			guess = getAnInt();
			if (guess <= 1)
				System.out.println("Please guess an integer between 1 and 1000 inclusive.");
			if (guess == randomnumber){
				System.out.println("Congratulations! Guesses made: " + guesses);
				break;
			} else if (guess < randomnumber){
				System.out.println("Too low.");
			} else if (guess > randomnumber) {
				System.out.println("Too high.");
			} 	
		}
	}
	
	public static void DoubleLoop(){
		System.out.print("Please input a number of rows you want: ");
		int lines = getAnInt();
		if (lines <= 0){
			System.out.println("Please input a positive integer.");
			return;
		}
		int i, j;
		for (i = lines; i>0; i--){
			System.out.print(i);
			for (j = lines - i; j>0; j--){
				System.out.print("	" + i);
			} 
			System.out.println("");
		}
	}

	public static void Rectangle(){
		System.out.print("Please input the width of the rectangle you want: ");
		int width = getAnInt();
		System.out.print("Please input the height of the rectange you want: ");
		int height = getAnInt();
		int w, h;
		if (width <= 0 || height <= 0){
			System.out.println("Please input positive integer values.");
			return;
		}
		for (h = height; h>0; h--){
			if (h == height || h == 1){
				for (w = width; w>0; w--){
					if (w == 1)
						System.out.println("*");
					else
						System.out.print("*");
				} 
			}
			else {
				for (w = width; w>0; w--){
					if (width == 1)
						System.out.println("*");
					else { 
						if (w == width)
							System.out.print("*");
						else if (w == 1)
							System.out.println("*");
						else
							System.out.print(" ");
					}
				}
			} 
		}
		
	}	
	
	
	public static void Factorials(){
		System.out.print("Please enter the number of factorials you would like in your table: ");
		int number = getAnInt();
		if (number <= 0){
			System.out.println("Please enter a positive integer.");
			return;
		}
		int factorial = 1;
		int i,j;
		for (i = 1; i <= number; i++){
			factorial = factorial*i;
			System.out.print(i + "! = ");
			for (j = i; j > 0; j--){
				if (j == 1)
					System.out.println(j + " = " + factorial);
				else
					System.out.print(j + " x ");
			}
		}
	}
	
	
	public static void Prime(){
		System.out.print("Please enter the number of the prime you want (up to 1000th): ");
		int n = getAnInt();
		int num, count, i;
		num = 1;
		count = 1;
		if (n <= 0 || n > 1000){
			System.out.println("Please enter a positive integer up to 1000.");
			return;
		}
		if (n == 1)
			System.out.println("2");
		else {
			while (count != n){
				num = num+2;
				for (i = 2; i <= num/2; i++){
					if (num%i == 0)
						break;
				}
				if (i > num/2){
					count++;
				if (count == n)
					System.out.println(num);
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		int inputnum = -1;
		
		System.out.println("Welcome to Lab05.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Guess My Number program");
			System.out.println("2: Double Loop program");
			System.out.println("3: Rectangle program");
			System.out.println("4: Fab Factorials program");
			System.out.println("5: The 1000th Prime program");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: Guess();
						break;
				case 2: DoubleLoop();
						break;
				case 3: Rectangle();
						break;
				case 4: Factorials();
						break;
				case 5: Prime();
						break;
				default: System.out.println("Illegal value entered");
			}
		}//while
	}//main
 }//Yang_P_lab_5
