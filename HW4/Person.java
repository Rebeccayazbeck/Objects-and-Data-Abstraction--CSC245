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
 * 		Account.java
 * 		Node.java
 */
public class Person {
	
	private String name;
	private int client_number;
	private LinkedList accounts = new LinkedList();
	
	
	public Person (String n, int cn) {
		name = n;
		client_number = cn;

	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param n the name to set
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * @return the client_number
	 */
	public int getClient_number() {
		return client_number;
	}
	/**
	 * @param cn the client_number to set
	 */
	public void setClient_number(int cn) {
		client_number = cn;
	}
	/**
	 * @return the accounts
	 */
	public LinkedList getAccounts() {
		return accounts;
	}
	/**
	 * @param a the accounts to set
	 */
	public void setAccounts(LinkedList a) {
		accounts = a;
	}
	@Override
	public String toString() {
	
		return "Person name:\n" + name+"\n" + "client_number:\n" + client_number+"\n" + "accounts\n" + accounts.toString();
	}
	
}
