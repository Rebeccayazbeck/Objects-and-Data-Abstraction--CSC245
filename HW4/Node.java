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
 * 		LinkedList.java
 * 		Person.java
 * 		Account.java
 */
public class Node {
	private  Account info;
	private Node next;
	
	public Node (Account a) {
		info = a ;
		next = null;			
	}

	public Account getInfo() {
		return info;
	}
	public void setInfo(Account a) {
		 info = a;
	}
	public Node getNext() {
		return next;
	}
	public void setNext( Node n) {
		next = n;
	}	

}
