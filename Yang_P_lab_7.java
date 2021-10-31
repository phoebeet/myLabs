import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;


class  Yang_P_lab_7 {
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
	
	public static int smallest(int ar[]){
		int i = 0;
		int currentsmallest = 2147483647;
		for (i = 0; i < 3; i++){
			if (ar[i] < currentsmallest)
				currentsmallest = ar[i];
		}
		return currentsmallest;
	}
	
	public static boolean primecheck(int num){
		boolean composite = false;
		int i;
		for (i = 2; i <= num/2; ++i){
			if (num%i == 0)
				composite = true;
		} 
		if (!composite)
			return false;
		else
			return true;
	}
	
	public static String factorize(int num){
		int i = 2;
		String factors = "";
		boolean composite = false;
		while (i <= num){
			composite = primecheck(i);
			if (composite)
				i++;
			else {
				if (num%i == 0){
					num = num/i;
					factors = factors + i + " ";
				} else
					i++;
			}					
		}
		return factors;
	}
	
	public static String reversestring(String input){
        StringBuffer toreverse = new StringBuffer(input);
		toreverse.reverse();
		String reversed = toreverse.toString();
        return reversed;
	}

	public static boolean perfectcheck(int n){
		int i, m;
		int sum = 0;
		boolean perfect = false;
		m = n/2; // m is the largest possible factor of n
		for (i = 1; i <= m; i++){
				if (n%i == 0)
					sum += i;
		}
		if (n == sum)
			perfect = true;
		return perfect;
	}
	
	public static boolean odds(){
		int i;
		double n;
		int heads = 0;
		for (i = 0; i < 100; i++){
			n = Math.random();
			if (n >= 0.5){
				heads++;
				if (heads >= 6)
					return true;
			}
			else
				heads = 0;
		}
		return false;
	}
	
	public static void smallestnumber(){
		int i, userinput, currentsmallest;
		System.out.println("Please input the 3 integers you want in your array.");
		int[] ar = new int[3];
		for (i = 0; i < 3; i++){
			userinput = getAnInt();
				if (userinput < 0){
					System.out.println("Please input a nonnegative integer.");
					return;
				}
			ar[i] = userinput;
		}
		currentsmallest = smallest(ar);
		System.out.println("The smallest number was: " + currentsmallest);
	}
	
	public static void primetime(){
		boolean composite = false;
		System.out.println("Please input the number you want to check for primeness: ");
		int num = getAnInt();
		if (num <= 1){
			System.out.println("Please input a positive integer greater than 1.");
			return;
		}
		composite = primecheck(num);
		if (!composite)
			System.out.println(num + " is a prime number.");
		else
			System.out.println(num + " is not a prime number.");
	}
	
	public static void primefactorization(){
		int num;
		boolean composite = false;
		System.out.println("Please input a number you'd like to prime factorize.");
		num = getAnInt();
		if (num < 0){
			System.out.println("Please input a positive integer.");
			return;
		}
		composite = primecheck(num);
		if (!composite)
			System.out.println(num);
		else{
			String factors = factorize(num);
			System.out.println(factors);
		}
	}
	
	public static void reverser(){
		System.out.println("Please input a string of integers you would like reversed.");
		String input = in.next();
		String reversed = reversestring(input);
		System.out.println(reversed);
    }
	
	public static void perfectnumbers(){
		int i, n, m;
		boolean perfect = false;
		for (n = 3; n <= 1000; n++) {
			perfect = perfectcheck(n);
			if (perfect){
				m = n/2;
				for (i = 1; i <= m; i++){
					if (i == 1)
						System.out.print(i);
					else if (n%i == 0)
						System.out.print(" + " + i);
				}
				System.out.println(" = " + n);
			}
		}
	}
	
	public static void whataretheodds(){
		int i, runs;
		int trues = 0;
		double probability;
		System.out.println("Please input the number of times you would like to run this:");
		runs = getAnInt();
		if (runs < 0){
			System.out.println("Please input a nonnegative integer.");
			return;
		}
		for (i = 0; i < runs; i++){
			if (odds())
				trues++;
		}
		probability = 100*(double)trues/(double)runs;
		System.out.println("This program ran " + runs + " iterations. The computated probability of at least six consecutive heads was " + probability + "%.");
	}
	
	public static void main(String args[]) {
		int inputnum = -1;
		System.out.println("Welcome to Lab07.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Find the Smallest Number program");
			System.out.println("2: Prime Time program");
			System.out.println("3: Prime Factorization program");
			System.out.println("4: Reverser program");
			System.out.println("5: Perfect Numbers program");
			System.out.println("6: What Are the Odds program");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: smallestnumber();
						break;
				case 2: primetime();
						break;
				case 3: primefactorization();
						break;
				case 4: reverser();
						break;
				case 5: perfectnumbers();
						break;
				case 6: whataretheodds();
						break;
				default: System.out.println("Illegal value entered");
			}
		}
	}
 }//Yang_P_lab_7