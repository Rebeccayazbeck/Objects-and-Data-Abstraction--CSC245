package question2;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 3/28/2023 
 * Description: Automated Teller Machine (ATM) that process several transactions per day
 * -------------------------------------------------------------------------
 * Files:
 * 		Queue.java
 * 		Transaction.java
 * 		ATM.java
 * 		Account.java
 * 		Person.java
 * 		Node.java
 */
public class LinkedList {
	
	private Node header ;
	
	/**
	 * 
	 * @return the header of the LinkedList
	 */
	public Node getHeader() {
		return header;
	}
	
	public void addLast(Account a) {
		Node n = new Node(a);
		if (header == null) {
			header = n;
			return;
		}
		Node current = header;
		while (current.getNext()!=null) {
			current = current.getNext();
		}
		current.setNext(n);
		
	}
	
	public boolean insert(Account a, int index) {
		
		if (index<0 || index>size()) {
			return false;
		}
    	else if (index == size()) {
			addLast(a);
			return true;
		}
		else if (index == 0) {
			Node n = new Node(a);
			n.setNext(header.getNext());
			header = n;	
			return true;
		}
		else {
			Node n = new Node(a);
			Node current = header;
			int count = 0;
			while (count<index) {
				current = current.getNext();
			}
			n.setNext(current.getNext());
			current.setNext(n);
			return true;
		}
		
	}
	


	public int size() {
		Node current = header;
		int count = 0;
		while (current.getNext()!= null) {
			count++;
		}
		return count;
	}
	
	public String toString() {
		
		String temp = header.getInfo().toString();
		Node current = header;
		while (current.getNext()!=null) {
			current = current.getNext();
			temp += "\n"+current.getInfo().toString();
		}
		return temp;

	}
	
}
	
	
	

