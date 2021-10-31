import java.io.*;
import java.util.Scanner;

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
		return "" + vehicle_idnumber + " " + num_of_passangers + " " + fuel_capacity + " " + mpg + " " + make;
	}
}

public class VehicleProgram {
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
				FileWriter writer = new FileWriter("carlist");
				PrintWriter printWriter = new PrintWriter(writer);
				
				for (i = 0; i < numofvehicles; i++) {
					record = " " + vehiclearray[i].vehicle_idnumber + "" + vehiclearray[i].num_of_passangers;
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
	
	public static void main(String[]args) {
		Vehicle[] my_vehiclearray = new Vehicle[100];
		int numofvehicles;
		
		numofvehicles = vehicleArrayCreate(my_vehiclearray);
		printvehiclearray(my_vehiclearray, numofvehicles);
		WriteToFile(my_vehiclearray, numofvehicles);
	}
}