import java.io.*;
import java.util.Scanner;

class Node {
	int value;
	Node left_child;
	Node right_child;

	Node(int s) {
		value = s;
		left_child = null;
		right_child = null;
	}

	Node(int s, Node n, boolean left) {
		value = s;
		if (left) {
			left_child = n;
			right_child = null;
		} else {
			right_child = n;
			left_child = null;
		}
	}

	Node(int s, Node l, Node r) {
		value = s;
		left_child = l;
		right_child = r;
	}

	public void print(int level, String steps) {
		System.out.println("value {" + value + "} at level " + level);
		System.out.println("after travelling " + steps);
		if (left_child != null)
			left_child.print(level + 1, steps + "L");
		if (right_child != null)
			right_child.print(level + 1, steps + "R");
	}

}

class BinTree1 {
	public static void main(String[] args) {
		Node root = new Node(5, new Node(3, new Node(4), false), new Node(7));
		root.print(1, "");
	}
}
