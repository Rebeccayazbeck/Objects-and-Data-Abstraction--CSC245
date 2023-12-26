package question2;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 3/30/2023 
 * Description: Automated Teller Machine (ATM) that process several transactions per day
 * -------------------------------------------------------------------------
 * Files:
 * 		Queue.java
 * 		LinkedList.java
 * 		ATM.java
 * 		Account.java
 * 		Person.java
 * 		Node.java
 */

import java.time.LocalDate;
import java.time.LocalTime;
public class Transaction {
	
	private Person person;
	private LocalDate date;
	private LocalTime time;
	private boolean debit;
	private boolean credit;
	private boolean transfer;
	private float debited;
	private float credited;
	private float transferred;
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param p the person to set
	 */
	public void setPerson(Person p) {
		person = p;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param d the date to set
	 */
	public void setDate(LocalDate d) {
		date = d;
	}
	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}
	/**
	 * @param time2 the time to set
	 */
	public void setTime(LocalTime time2) {
		time = time2;
	}
	/**
	 * @return the debit
	 */
	public boolean isDebit() {
		return debit;
	}
	/**
	 * @param d the debit to set
	 */
	public void setDebit(boolean d) {
		debit = d;
	}
	/**
	 * @return the credit
	 */
	public boolean isCredit() {
		return credit;
	}
	/**
	 * @param c the credit to set
	 */
	public void setCredit(boolean c) {
		credit = c;
	}
	/**
	 * @return the transfer
	 */
	public boolean isTransfer() {
		return transfer;
	}
	/**
	 * @param tr the transfer to set
	 */
	public void setTransfer(boolean tr) {
		transfer = tr;
	}
	/**
	 * @return the debited
	 */
	public float getDebited() {
		return debited;
	}
	/**
	 * @param deb the debited to set
	 */
	public void setDebited(float deb) {
		debited = deb;
	}
	/**
	 * @return the credited
	 */
	public float getCredited() {
		return credited;
	}
	/**
	 * @param cred the credited to set
	 */
	public void setCredited(float cred) {
		credited = cred;
	}
	/**
	 * @return the transferred
	 */
	public float getTransferred() {
		return transferred;
	}
	/**
	 * @param trans the transferred to set
	 */
	public void setTransferred(float trans) {
		transferred = trans;
	}
	public Transaction() {
		
		debited = 0;
		transferred = 0;
		credited = 0;
		debit = false;
		credit = false;
		transfer = false;
	}
	@Override
	public String toString() {
		if (debit) {
		return "person:\n" + person.toString() + "\ndate: " + date + "\ntime: " + time + "\ndebit\ndebited= " + debited;
		}
		else if (credit) {
			return "person:\n" + person.toString() + "\ndate: " + date + "\ntime: " + time + "\ncredit\ncreditedted= " + credited;
		}
		else {
			return "person:\n" + person.toString() + "\ndate: " + date + "\ntime: " + time + "\ntransfer\ntransfered= " + transferred;
		}
	
	}

}
