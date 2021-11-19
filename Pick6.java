class Pick6 {

  public static void main(String[] args) {
    int expenses = 0;
    int earnings = 0;
    int[] ticket = new int[6];
    int[] winning = new int[6];
    pick6(winning);
    for (int i = 0; i < 100000; i++) {
      pick6(ticket);
      expenses += 2;
      switch (num_matches(winning, ticket)) {
      case 1:
        earnings += 4;
        break;
      case 2:
        earnings += 7;
        break;
      case 3:
        earnings += 100;
        break;
      case 4:
        earnings += 50000;
        break;
      case 5:
        earnings += 1000000;
        break;
      case 6:
        earnings += 25000000;
        break;
      default:
        break;
      }
    }
    int balance = (earnings - expenses);
    System.out.println("Your balance is " + balance);
    double ROI = (double) balance / (double) expenses;
    System.out.println("Your expenses are " + expenses);
    System.out.println("Your earnings are " + earnings);
    System.out.println("Your return on investment is " + ROI); 
  }

  public static void pick6(int[] a) {
    for (int i = 0; i < a.length; i++){
     a[i] = (int) (Math.random() * 100);
    }
  }

  public static int num_matches(int[] a, int[] b) {
    int matches = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == b[i])
        matches++;
    }
    return matches;
  }

}
