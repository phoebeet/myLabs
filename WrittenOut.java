import java.util.Scanner;

class WrittenOut {
  static Scanner in =  new Scanner(System.in);

  public static void num2words(int n) {
    String[] numbers = new String[20];
    numbers[0] = "zero";
    numbers[1] = "one";
    numbers[2] = "two";
    numbers[3] = "three";
    numbers[4] = "four";
    numbers[5] = "five";
    numbers[6] = "six";
    numbers[7] = "seven";
    numbers[8] = "eight";
    numbers[9] = "nine";
    numbers[10] = "ten";
    numbers[11] = "eleven";
    numbers[12] = "twelve";
    numbers[13] = "thirteen";
    numbers[14] = "fourteen";
    numbers[15] = "fifteen";
    numbers[16] = "sixteen";
    numbers[17] = "seventeen";
    numbers[18] = "eighteen";
    numbers[19] = "nineteen";

    String[] tens = new String[8];
    tens[0] = "twenty";
    tens[1] = "thirty";
    tens[2] = "fourty";
    tens[3] = "fifty";
    tens[4] = "sixty";
    tens[5] = "seventy";
    tens[6] = "eighty";
    tens[7] = "ninety";

    int u, t, h;
    String written = "";

    if (n == 0)
      System.out.println(numbers[0]);
    else if (n > 999 || n < 0)
      System.out.println("Only support numbers from 0 up to 999");
    else {
      u = n % 10;
      t = (n / 10) % 10;
      h = n / 100;
      if (h != 0)
        written = numbers[h] + " hundred ";
      if (t != 0) {
        if (t != 1) {
          written += tens[t - 2];
          if (u != 0)
            written += (" " + numbers[u]);
	} else {
          written += numbers[t * 10 + u];
        }
      } else {
        if (h != 0) {
          if (u != 0)
            written += ("and " + numbers[u]);
	} else if (h == 0)
          written = numbers[u];
      }

      System.out.println(written);
    }
  }

  public static void num2roman(int n) {
    int u, t, h;
    String written = "";

    if (n == 0)
      System.out.println("Zero is not defined in roman numerals");
    else if (n > 999 || n < 0)
      System.out.println("Only support numbers from 0 up to 999");
    else {
      u = n % 10;
      t = (n / 10) % 10;
      h = n / 100;

      if (h != 0) {
        if (h < 4) {
          for (int i = 0; i < h; i++)
            written += "C";
        } else if (h == 4) {
          written = "CD";
	} else if (h == 9) {
          written = "CM";
	} else {
          written = "D";
          for (int i = 5; i < h; i++)
            written += "C";
        }
      }
      if (t != 0) {
        if (t < 4) {
          for (int i = 0; i < t; i++)
            written += "X";
        } else if (t == 4) {
          written += "XL";
        } else if (t == 9) {
          written += "XC";
        } else {
          written += "L";
          for (int i = 5; i < t; i++)
            written += "X";
        }
      }
      if (u != 0) {
        if (u < 4) {
          for (int i = 0; i < u; i++)
            written += "I";
        } else if (u == 4) {
          written += "IV";
        } else if (u == 9) {
           written += "IX";
        } else {
          written += "V";
          for (int i = 5; i < u; i++)
            written += "I";
        }
      }

      System.out.println(written);
    }
  }

  public static void main(String[] args) {
    int n, num;

    System.out.println("Please input a number you would like to write out");
    num = in.nextInt();

    System.out.println("Please select output format:");
    System.out.println("1. English words");
    System.out.println("2. Roman numerals");
    n = in.nextInt();

    if (n == 1)
      num2words(num);
    else if (n == 2)
      num2roman(num);
    else
      System.out.println("Format not supported");
  }
}
