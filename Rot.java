import java.io.*;
import java.util.Scanner;

class Rot {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Please input a string you would like to encode/decode.");
    String a = in.nextLine();
    System.out.println("What rotation would you like to use?");
    int n = in.nextInt();
    System.out.println(Rot13(a, n));
  }

  
  public static String Rot13 (String a, int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (c >= 'a' && c <= 'm') 
        c += n%26;
      else if (c >= 'A' && c <= 'M') 
        c += n%26;
      else if (c >= 'n' && c <= 'z') 
        c -= n%26;
      else if (c >= 'N' && c <= 'Z') 
        c -= n%26;
      sb.append(c);
    }
    return sb.toString();
  }
  
}
