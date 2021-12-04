import java.io.*;
import java.util.Scanner;

class AnaPal {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {

    int inputnum = -1;

    while(inputnum != 0) {
      System.out.println("Anagram or Palindrome Test?");
      System.out.println("0: Quit the program");
      System.out.println("1: Anagram Test");
      System.out.println("2: Palindrome Test");
      System.out.println();

      inputnum = in.nextInt();

      switch (inputnum){
        case 0:
	  break;
        case 1: Anagram();
          break;
        case 2: Palindrome();
          break;
        default:
          System.out.println("Illegal value entered");
      }
    }
  }

  public static void Anagram(){
    System.out.println("Please type a string.");
    in.nextLine();
    String a = in.nextLine();
    char[] anagram1 = a.toCharArray();
    Bubblesort ana1 = new Bubblesort();
    ana1.bubblesort(anagram1);

    System.out.println("Please type a second string.");
    String b = in.nextLine();
    char[] anagram2 = b.toCharArray();
    Bubblesort ana2 = new Bubblesort();
    ana2.bubblesort(anagram2);

    int z;

    if (anagram1.length != anagram2.length){
      System.out.println("Not anagram");
    } else {
      for (z = 0; z < anagram1.length; z++){
        if (anagram1[z] != anagram2[z]){
          break;
        }
      }
      if (z == anagram1.length) {
        System.out.println("It's an anagram!");
      } else {
        System.out.println("Not an anagram.");
      }

    }

  }

  public static void Palindrome()
  {
    System.out.println("Please enter a string.");
    in.nextLine();
    String c = in.nextLine();
    String d = "";
    char ch;

    for (int x = 0; x < c.length(); x++) {
      ch = c.charAt(x);
      d = ch + d;
    }

    if (c.equals(d))
      System.out.println("It's a palindrome!");
    else
      System.out.println("Not a palindrome.");
  }


  public static void swap(char[] a, int i, int j)
  {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static class Bubblesort {

    private static void bubblesort(char[] a)
    {
      for (int i = 0; i < a.length; i++) {
        for (int j = i+1; j < a.length; j++) {
          if (a[j] < a[i])
            swap(a, i, j);
        }
      }
    }
  }
}
