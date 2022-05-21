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

	public void in_order() {
		if (left_child != null)
			left_child.in_order();

		System.out.println(value);

		if (right_child != null)
			right_child.in_order();
	}

	public void add(int v) {
		if (v < value) {
			if (left_child == null)
				left_child = new Node(v);
			else
				left_child.add(v);
		} else if (v > value) {
			if (right_child == null)
				right_child = new Node(v);
			else
				right_child.add(v);
		}
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

class BinTree3 {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.add(3);
		root.add(2);
		root.add(4);
		root.add(7);
		root.add(6);
		root.add(9);
		root.add(8);
		root.add(10);
		root.in_order();
	}
}
