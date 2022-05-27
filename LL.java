import java.io.*;
import java.util.Scanner;

class Node implements Cloneable, Serializable {
	Node next;
	Mall inf;

	Node(String name, int price) {
		inf = new Mall(name, price);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class LL implements Cloneable, java.io.Serializable {
	static Scanner sc = new Scanner(System.in);
	Node head;
	int fianlamount;

	public void add(String name, int price) {
		Node new_node = new Node(name, price);
		new_node.next = head;
		head = new_node;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void displayCategories() {
		Node temp = head;
		System.out.println("Categorys of products as follows");
		int index = 1;
		while (temp != null) {
			System.out.println("                 " + index + "                 " + temp.inf.prname + "              "
					+ temp.inf.prprice);
			temp = temp.next;
			index++;
		}

	}

	void addbynode(Node n) {
		n.next = head;
		head = n;
	}

	Node addCart() throws CloneNotSupportedException {
		System.out.println("Enter your choice as per follwing");

		int a = sc.nextInt();
		Node temp = findbyindex(a - 1);
		System.out.println("Enter your quantity");
		Node current = (Node) temp.clone();
		temp.inf.qantity = sc.nextInt();
		return current;

	}

	public int count() {
		Node n = head;
		int count1 = 0;
		while (n != null) {
			count1++;
			n = n.next;
		}
		return count1;
	}

	Node findbyindex(int a) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node prev = null;
		for (int i = 0; i < a && i < count(); i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void printbill() {
		System.out.println(" ________________________________________________________________");
		System.out.println("|srno |   product Name          |   Price  | Quantity | Bill    |");
		System.out.println("|_____|_________________________|__________|__________|_________|");
		Node temp = head;
		int index = 1;
		fianlamount = 0;
		while (temp != null) {
			String s1 = Integer.toString(temp.inf.prprice);
			String s2 = Integer.toString(temp.inf.qantity);
			String s3 = Integer.toString(temp.inf.prprice * temp.inf.qantity);
			int j = s1.length();
			int k = 0;
			String s5 = " ";
			for (int i = j; i < 8; i++) {
				s1 = s1 + s5;
			}
			j = s2.length();
			for (int i = j; i < 8; i++) {
				s2 = s2 + s5;
			}
			j = s3.length();
			for (int i = j; i < 8; i++) {
				s3 = s3 + s5;
			}

			fianlamount = fianlamount + temp.inf.prprice * temp.inf.qantity;
			System.out
					.println("|" + index + "    |     " + temp.inf.prname + " |" + s1 + "  |" + s2 + "  |" + s3 + " |");
			temp = temp.next;
			index++;
		}

		String s5 = " ";
		int j = 0;
		String f = Integer.toString(fianlamount);
		j = f.length();
		for (int i = j; i < 8; i++) {
			f = f + s5;
		}

		System.out.println(" ________________________________________________________________");
		System.out.println("|                    |                                          |");
		System.out.println("|   TOTAL -:         |                       " + f + "           |");
		System.out.println("|____________________|__________________________________________|");

	}
}