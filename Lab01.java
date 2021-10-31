import java.io.*;
import java.util.Scanner;

class  Lab01 {
	
	
 public static void main(String args[]) {
   //this is program 1
   System.out.println("PROGRAM 1");
   System.out.println("");
   System.out.println("Box:");
   System.out.println("******");
   System.out.println("*    *");
   System.out.println("*    *");
   System.out.println("*    *");
   System.out.println("******");
   System.out.println("Oval:");
   System.out.println("   **   ");
   System.out.println(" *    * ");
   System.out.println("*      *");
   System.out.println("*      *");
   System.out.println(" *    * ");
   System.out.println("   **   ");
   System.out.println("Arrow:");
   System.out.println("   *   ");
   System.out.println("  * *  ");
   System.out.println(" * * * ");
   System.out.println("   *   ");
   System.out.println("   *   ");
   System.out.println("Diamond:");
   System.out.println("   *   ");
   System.out.println("  * *  ");
   System.out.println(" *   * ");
   System.out.println("  * *  ");
   System.out.println("   *   ");
   System.out.println("");
   System.out.println("");
   
   //this is program 2
   System.out.println("PROGRAM 2");
   System.out.println("");
   Scanner in = new Scanner(System.in);
   System.out.print("First number: ");
   int first = in.nextInt();
   System.out.print("Second number: ");
   int second = in.nextInt();
   System.out.println("Sum = " + (first + second));
   System.out.println("Difference = " + (first - second));
   System.out.println("Product = " + (first*second));
   System.out.println("Quotient = " + (first/second));
   System.out.println("");
   System.out.println("");
   
   //this is program 3 
   System.out.println("PROGRAM 3");
   System.out.println("");
   System.out.print("Radius: ");
   double radius = in.nextDouble();
   double circumf = (2*3.14159) * radius;
   System.out.println("The circumference is " + circumf);
   System.out.println("");
   System.out.println("");
   
   //this is program 4
   System.out.println("PROGRAM 4");
   System.out.println("");
   System.out.print("Starting odometer reading in miles: ");
   float odometer1 = in.nextFloat();
   System.out.print("Ending odometer reading in miles: ");
   float odometer2 = in.nextFloat();
   System.out.print("Starting fuel amount in gallons: ");
   float fuel1 = in.nextFloat();
   System.out.print("Ending fuel amount in gallons: ");
   float fuel2 = in.nextFloat();
   System.out.println("The fuel consumption is " + (odometer2-odometer1)/(fuel1-fuel2) + " miles/gallons");
   
   
 }
}