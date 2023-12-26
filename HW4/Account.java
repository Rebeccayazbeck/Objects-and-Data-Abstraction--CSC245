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
 * 		Node.java
 */
public class Account {
	
	private int account_number;
	private boolean checking;
	private boolean savings;
	private float balance;
	
	public Account(int an, boolean c, boolean s, float b) {
		account_number = an;
		checking = c;
		savings = s;
		balance = b;
	}

	/**
	 * @return the account_number
	 */
	public int getAccount_number() {
		return account_number;
	}

	/**
	 * @param an the account_number to set
	 */
	public void setAccount_number(int an) {
		account_number = an;
	}

	/**
	 * @return the checking
	 */
	public boolean isChecking() {
		return checking;
	}

	/**
	 * @param c the checking to set
	 */
	public void setChecking(boolean c) {
		checking = c;
	}

	/**
	 * @return the savings
	 */
	public boolean isSavings() {
		return savings;
	}

	/**
	 * @param s the savings to set
	 */
	public void setSavings(boolean s) {
		savings = s;
	}

	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * @param b the balance to set
	 */
	public void setBalance(float b) {
		balance = b;
	}

	@Override
	public String toString() {
		if (checking) {
			return "checking "+ account_number +": "+ balance;
		}
		else {
			return "savings "+ account_number +": "+ balance;
		}
	}
}