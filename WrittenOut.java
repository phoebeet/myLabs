import java.util.Scanner;

class WrittenOut {
  static Scanner in =  new Scanner(System.in);

  public static void main(String[] args) {


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


    System.out.println("Please input a number you would like to write out");
    int n = in.nextInt();
    int u, t, h;
    String written = "";

    if (n == 0)
      System.out.println(numbers[0]);
    else {
      u = n % 10;
      t = (n / 10) % 10;
      h = n / 100;
      if (h != 0)
        written = numbers[h] + " hundred ";
      if (t != 0) {
        if (t != 1) {
          written += tens[t -2];
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
}
