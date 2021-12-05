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

  
 public static String Rot13 (String s, int n) {
    char a, c;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c < 'A' || c > 'z' || (c > 'Z' && c < 'a')) {
        sb.append(c);
        continue;
      }

      if (c >= 'A' && c <= 'Z')
        a = 'A';
      else
        a = 'a';

      c = (char) (a + (((c - a) + n) % 26));
      sb.append(c);
    }
    return sb.toString();
  }
}
