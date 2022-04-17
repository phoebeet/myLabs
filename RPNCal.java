import java.util.Scanner;

class RPNCal {
	static Scanner in =  new Scanner(System.in);
	private static double[] ar_stack = new double[100];
	private static int tos = -1; // this is top of stack. It always indicates the location of the most recent addition to the stack.

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please enter your \",\" separated RPN string");
			String sRpn = in.nextLine();
			System.out.println(sRpn + " = " + String.valueOf(RPNCalculate(sRpn)));
		} else {
			if (args[0].equals("-i") && (args.length == 2)) {
				System.out.println(args[1] + " = " + String.valueOf(RPNCalculate(args[1])));
			} else {
				System.out.println("The first argument should be -i");
				System.out.println("The second argument should be the \",\" separated RPN string to be calculated");
			}
		}
	}

	private static double RPNCalculate(String s) {
		double op1, op2;
		String[] aElems = s.split(",", -2);
		for (String a : aElems) {
			if (a.equals("+")) {
				op1 = pop();
				op2 = pop();
				push(op1 + op2);
			} else if (a.equals("-")) {
				op1 = pop();
				op2 = pop();
				push(op2 - op1);
			} else if (a.equals("*")) {
				op1 = pop();
				op2 = pop();
				push(op1 * op2);
			} else if (a.equals("/")) {
				op1 = pop();
				op2 = pop();
				push(op2 / op1);
			} else
				push(Double.valueOf(a));
		}
		return pop();
	}

	private static void push(double d) {
		ar_stack[++tos] = d;
		if (tos >= 100) {
			System.out.println("ERROR: stack overflow!!! automatically cleared");
			tos = -1;
		}
	}

	private static double pop() {
		double d = 0;
		if (tos >= 0)
			d = ar_stack[tos--];
		if (tos == -1)
			System.out.println("WARNING: the stack is now empty");
		return d;
	}

	private static void dumpstack() {
		if (tos >= 0)
			for (int i = 0; i <= tos; i++)
				System.out.println(String.valueOf(ar_stack[i]));
	}

}
