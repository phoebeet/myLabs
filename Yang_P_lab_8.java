import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;

	
class Vehicle {
	
	int vehicle_idnumber;
	int num_of_passangers;
	int fuel_capacity;
	int mpg;
	String make;
	
	Vehicle(int vehicle_idnumber, int num_of_passangers, int fuel_capacity, int mpg, String make){
		this.vehicle_idnumber = vehicle_idnumber;
		this.num_of_passangers = num_of_passangers;
		this.fuel_capacity = fuel_capacity;
		this.mpg = mpg;
		this.make = make;
	}
	
	public String toString(){
		return vehicle_idnumber + "\t" + num_of_passangers + "\t" + fuel_capacity + "\t" + mpg + "\t" + make;
	}
}


public class Yang_P_lab_8 {
	
	
	static Scanner ui = new Scanner(System.in);
	
	
	public static int vehicleArrayCreate(Vehicle [] vehiclearray) {
		int vehiclecount = 0;
		Scanner in;
		int vehicle_idnumber;
		int num_of_passangers;
		int fuel_capacity;
		int mpg;
		String make;
		
		try {
			in = new Scanner(new File ("carlist.txt"));
			while (in.hasNext()){
				vehicle_idnumber = in.nextInt();
				num_of_passangers = in.nextInt();
				fuel_capacity = in.nextInt();
				mpg = in.nextInt();
				make = in.next();
				vehiclearray[vehiclecount] = new Vehicle(vehicle_idnumber, num_of_passangers, fuel_capacity, mpg, make);
				vehiclecount++;
			}
		}
		catch (IOException except) {
			System.out.println("Can't find file = place carlist.txt in same directory OR input a file with less than 100 vehicles");
		}
		return vehiclecount;
	}
	
	
	private static void WriteToFile(Vehicle vehiclearray[], int numofvehicles) {
		String record;
		int i;
		
			try {
				FileWriter writer = new FileWriter("newcarlist");
				PrintWriter printWriter = new PrintWriter(writer);
				
				for (i = 0; i < numofvehicles; i++) {
					record = vehiclearray[i].vehicle_idnumber + "\t" + vehiclearray[i].num_of_passangers + "\t" + vehiclearray[i].fuel_capacity + "\t" + vehiclearray[i].mpg + "\t" + vehiclearray[i].make;
						printWriter.println(record);
				}
				writer.flush();
				writer.close();
			}
			catch (IOException excep) {
				System.out.print("Can't write file");
			}
	}
	
	
	public static void printvehiclearray(Vehicle [] my_vehiclearray, int numofvehicles) {
		int i;
		
		for(i = 0; i < numofvehicles; i++) {
			System.out.println(my_vehiclearray[i]);
		}
	}
	
	
	public static int getAnInt(){
		int retval = 0;
		boolean done = false;
		String dummy;
		while(!done){
			System.out.println("Enter an integer:");
			if(ui.hasNextInt()){
				done = true;
				retval = ui.nextInt();
			} else {
				System.out.println("Integer values only, please re-enter a valid input: ");
				dummy = ui.next();
			}
		}
		return retval;
	}//getAnInt


	public static void maketotal(Vehicle vehiclearray[], int numofvehicles){
		int i, j;
		boolean match_found;
		int makes = 0;
		String[] make = new String[numofvehicles];
		int[] cnt = new int[numofvehicles];
		
		for (i = 0; i < numofvehicles; i++) {
			match_found = false;
			for (j = 0; j < makes; j++) {
				if (make[j].equals(vehiclearray[i].make)) {
					cnt[j] += 1;
					match_found = true;
				}
			}
			if (!match_found) {
				make[makes] = vehiclearray[i].make;
				cnt[makes] = 1;
				makes++;
				}
			}
			System.out.println("MAKE" + "\t  \t" + "NUMOFCARS");
			
		for (j = 0; j < makes; j++)
			System.out.printf("%-10s\t%d\n", make[j], cnt[j]);
		
		System.out.println("");
	}
	
	
	public static void IDrange(Vehicle vehiclearray[], int numofvehicles){
		int i;
		int highestrangeid = 0;
		int lowestrangeid = 0;
		int highestrange = 0;
		int lowestrange = Integer.MAX_VALUE;
		int range;
		
		for (i = 0; i < numofvehicles; i++){
			
			range = vehiclearray[i].fuel_capacity*vehiclearray[i].mpg;
			
			if (range > highestrange){
				highestrange = range;
				highestrangeid = i;
			}
				
			if (range < lowestrange){
				lowestrange = range;
				lowestrangeid = i;
			}
		}
		
		System.out.println("Highest range:");
		System.out.println(vehiclearray[highestrangeid].vehicle_idnumber + " with a range of " + highestrange + " miles");
		System.out.println("Lowest range:");
		System.out.println(vehiclearray[lowestrangeid].vehicle_idnumber + " with a range of " + lowestrange + " miles");
		
		System.out.println("");
	}
	
	
	public static void vehiclenumbersort(Vehicle vehiclearray[], int numofvehicles){
		int a, b, i;
		Vehicle t;
		
		for (a = 1; a < numofvehicles; a++){
			for (b = numofvehicles - 1; b >= a; b--){
				if(vehiclearray[b-1].vehicle_idnumber > vehiclearray[b].vehicle_idnumber){
					t = vehiclearray[b-1];
					vehiclearray[b-1] = vehiclearray[b];
					vehiclearray[b] = t;
				}
			} 
		}
		
		for (i = 0; i < numofvehicles; i++){
			System.out.println(vehiclearray[i]);
		}
		System.out.println("");
		WriteToFile(vehiclearray, numofvehicles);
	}
	
	
	public static void rangesort(Vehicle vehiclearray[], int numofvehicles){
		int a, b, i, r;
		Vehicle t;
		int[] range = new int[numofvehicles];
		
		for (i = 0; i < numofvehicles; i++){
			range[i] = vehiclearray[i].fuel_capacity*vehiclearray[i].mpg;
		}
		
		for (a = 1; a < numofvehicles; a++){
			for (b = numofvehicles - 1; b >= a; b--){
				if(range[b-1] > range[b]){
					t = vehiclearray[b-1];
					vehiclearray[b-1] = vehiclearray[b];
					vehiclearray[b] = t;
					r = range[b-1];
					range[b-1] = range[b];
					range[b] = r;
				}
			} 
		}
		System.out.println("Range\tVID\tPSSGRS\tFuelCap\tMPG\tMake");
		for (i = 0; i < numofvehicles; i++){
			System.out.println(range[i] + "\t" + vehiclearray[i]);
		}
		
		System.out.println("");
	}
	
	
	public static void main(String args[]) {
		
		Vehicle[] my_vehiclearray = new Vehicle[100];
		int inputnum = -1;
		
		int numofvehicles = vehicleArrayCreate(my_vehiclearray);
		System.out.println("Welcome to Lab08.");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to the program you want to run");
			System.out.println("0: Quit the program");
			System.out.println("1: Total number of each make");
			System.out.println("2: Range of car id");
			System.out.println("3: Sorting by Vehicle Number");
			System.out.println("4: Challenge Program");
			System.out.println();
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: maketotal(my_vehiclearray, numofvehicles);
						break;
				case 2: IDrange(my_vehiclearray, numofvehicles);
						break;
				case 3: vehiclenumbersort(my_vehiclearray, numofvehicles);
						break;
				case 4: rangesort(my_vehiclearray, numofvehicles);
						break;
				default: System.out.println("Illegal value entered");
			}
		}
	}
 }//Yang_P_lab_8