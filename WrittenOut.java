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

    String[] tens = new String[9];
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
    String written;

    if (n % 100 < 20){
      written = numbers[n%100];
      n /= 100;
    } else {
      written = numbers[n%10];
      n /= 10;
      written = tens[n%10 - 2] + written;
      n /= 10;
    }

    if (n == 0)
      System.out.println(numbers[0]);
    
    System.out.println(numbers[n] + " hundred " + written);
  }
}
