import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

class MyFibCalc {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		char c;
		Fib f;
		System.out.println("Welcome to Fibonacci calculator");
		do {
			System.out.println("Cached? (y/n)");
			c = in.next().charAt(0);
			if (c == 'y' || c == 'Y')
				f = new CachedFib();
			else
				f = new Fib();

			System.out.println("Please input the term you want to calculate:");
			int term = in.nextInt();
			System.out.println("Fib[" + term + "] = " + f.calc(term));

			System.out.println("Calculate another term? (y/n)");
			in.nextLine();
			c = in.next().charAt(0);
		} while (c == 'y' || c == 'Y');
	}
}

class Fib {
	int[] beginning_nums;

	Fib() {
		beginning_nums = new int[] {0, 1, 1};
	}

	public int calc(int t) {
		if (t < 3)
			return beginning_nums[t];
		return calc(t - 1) + calc(t - 2);
	}
}

class CachedFib extends Fib {
	HashMap<Integer, Integer> fibMap;

	CachedFib() {
		fibMap = new HashMap<Integer, Integer>();
	}

	public int calc(int t) {
		if (!fibMap.containsKey(t))
			fibMap.put(t, super.calc(t));
		return fibMap.get(t);
	}
}
