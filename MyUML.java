import java.util.Scanner;
import java.util.ArrayList;

public class MyUML {

	public static void main(String[] args) {
		boolean bOrderCompleted = false;
		Scanner myScan = new Scanner(System.in);
		String response;
		GenericUser user = null;
		while (user == null) {
			System.out.println("Create an user - 1: National, 2: International");
			int nInput = myScan.nextInt();
			if (nInput == 1)
				user = new NationalUser("Sam", "Young", "Samuel", "63030");
			else if (nInput == 2)
				user = new InternationalUser("Sam", "Yang", "Samuel", "Ukraine");
			else
				System.out.println("You can only choose either 1 or 2");
		}

		String[] products = {"computer", "water bottle", "AeroVironment Switchblade", "tent", "FGM-148 Javelin"};
		int[] NumAvailable = {100, 500, 1000, 100, 200};
		double[] Prices = {1100.99, 6.99, 100000.0, 150.99, 1000000.0};
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (int i=0; i<products.length; i++)
			itemList.add(new Item(products[i], NumAvailable[i], Prices[i]));
		int index = 1;
		for (Item itm: itemList)
                        System.out.print(index++ + ": " + itm.name + " | ");
		System.out.println();
		ArrayList<Item> itemsOrdered = new ArrayList<Item>();
		while (!bOrderCompleted) {
			System.out.println("Type item number to order and type 0 when done");
			int nInput = myScan.nextInt();
			if (nInput == 0) {
				bOrderCompleted = true;
				continue;
			}
			if (nInput > itemList.size()) {
				System.out.println("Invalid item");
				continue;
			}
			itemsOrdered.add(itemList.get(nInput - 1));
		}

		Order mainOrder = user.makeOrder(itemsOrdered);
		mainOrder.printInfo();
	}
}

class Order {
	private ArrayList<Item> itemArr;
	Order() {
		itemArr = new ArrayList<Item>();
	}
	public void addItem(Item itemParam) {
		itemArr.add(itemParam);
	}
	public void printInfo() {
		itemArr.forEach(
			(item) -> System.out.println(item.name)
		);
	}

}

class GenericUser {
	String userName;
	String lastName;
	String firstName;
	String zipCode;
	boolean isLocal;

	public Order makeOrder(ArrayList<Item> lItems) {
		Order returnedOrder = new Order();
		lItems.forEach(
			(item) -> returnedOrder.addItem(item)
		);
		return returnedOrder;
	}
}

class NationalUser extends GenericUser {

	public NationalUser(String uN, String lN, String fN, String zip) {
		userName = uN;
		lastName = lN;
		firstName = fN;
		zipCode = zip;
		isLocal = false;
	}

	public boolean checkZip() {
		if (zipCode.length() == 5) {
			for (int i=0; i<5; i++) {
				if (zipCode.charAt(i) < '0' || zipCode.charAt(i) > '9')
					return false;
			}
			return true;
		}

		return false;
	}
}

class InternationalUser extends GenericUser {
	String Country;

	public InternationalUser(String uN, String lN, String fN, String c) {
		userName = uN;
		lastName = lN;
		firstName = fN;
		Country = c;
		isLocal = false;
	}
}

class Item {
	String name;
	int nInStock;
	double price;

	public Item(String sName, int n, double p) {
		name = sName;
		nInStock = n;
		price = p;
	}
/*
	public void listItems() {
		int i = 1;
		for (String itm: itemArr)
			System.out.print(i++ + ": " + itm + " | ");
		System.out.println();
	}

	public String getItem(int inex) {
		if (index < itemArr.size())
			return itemArr.get(index);
		else
			return null;
	}
*/
}
