package question2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 4/5/2023 
 * Description: Automated Teller Machine (ATM) that process several transactions per day
 * -------------------------------------------------------------------------
 * Files:
 * 		Queue.java
 * 		Transaction.java
 * 		LinkedList.java
 * 		Account.java
 * 		Person.java
 * 		Node.java
 */
public class ATM {
	
	/**
	 * disolay the menu
	 */
	public static void displayMenu() {
		
		System.out.println("1.	Withdraw money");
		System.out.println("2.	Deposit money");
		System.out.println("3.	Transfer of Money");
		System.out.println("4.	Display account info");
		System.out.println("5.	Exit");
		System.out.println("--------------------------");
		
	}
	
	/**
	 * check if the user has a valid id number and password
	 * @param idNum the id number
	 * @return true if the user is valid false otherwise
	 */
	public static boolean identification(String idNum) throws FileNotFoundException {
		String[][] verification;
		verification = Reader("ID&pass.txt");
		Scanner scan = new Scanner(System.in);
		for (int index=0; index < verification.length; index++) {
			if (idNum.equals(verification[index][0])) {
				System.out.println("Enter your password");
				String pass = scan.nextLine();
				if (pass.equals(verification[index][1])) { 
					return true;
				}
				else 
					System.out.println("Invalid password!");
					return false;
				}
			}
		System.out.println("Invalid Username");
		return false;
	}
	
	/**
	 * read from a file
	 * @param file
	 * @return 2D array
	 * @throws FileNotFoundException
	 */
	public static String[][] Reader(String file){
		try {		
		FileInputStream fi = new FileInputStream (file);
		InputStreamReader is = new InputStreamReader (fi);
		BufferedReader br = new BufferedReader(is);
		String line = br.readLine(); 
		int totalColumn = line.split(";").length;
		int totalRow = 0;
		ArrayList<String> array = new ArrayList<String>();
		while (line != null ) {
			array.add(line);
			line = br.readLine();
			totalRow +=1;
		}
		String [][] verification = new String[totalRow][totalColumn];
		int index = 0;
		while (index!=totalRow ) {
			verification[index] = array.get(index).split(";");
			//line = br.readLine();
			index++;
		}
		br.close(); 
		return verification;
		}
		catch(IOException e) {
			return null;
		}
	}
	
	/**
	 * get the users from a file into an arrayList
	 * @return an arraylist of persons
	 */
	public static ArrayList<Person> getUsers() throws FileNotFoundException {
		String [][] user;
		ArrayList<Person>users = new ArrayList<Person>();
		user = Reader("users.txt");
		int index = 0;
		while (index < user.length) {
			Person p = new Person (user[index][0] , Integer.parseInt(user[index][1]));
			LinkedList accounts = new LinkedList();
			for (int i = 2 ; i< user[index].length; i++) {
				String[] account = user[index][i].split(",");
				int account_number = Integer.parseInt(account[0]);
				float balance = Float.parseFloat(account[2]);
				Account a;
				if (account[1].equals("checking")) {
					a = new Account(account_number, true,false,balance);
				}
				else{
					a = new Account(account_number, false, true ,balance);
				}
			accounts.addLast(a);
			}
			p.setAccounts(accounts);
			users.add(p);
			index++;
		}
		return users;
		
	}
	 /**
	  * checks if the transaction inside the queue is valid to process
	  * @param q the queue 
	  * @return true if the transaction should be processed false otherwise
	  */
	public static boolean checkToProcess(Queue q) {
		if(q.getFront()==null) {
			System.out.println("no more transactions");
			return false;
		}
		if (q.getFront().getTime().isAfter(LocalTime.of(18, 0))) {
			if (LocalTime.now().isBefore(LocalTime.of(18, 0))) {
				return true;
			}
			else {
				System.out.println("It is past 6:00 PM.");
				System.out.println("Transactions will be processed the next working day");
				return false;
			}
		}
		
		else 
			return true;
	}
	
	/**
	 * process the valid transactions inside the queue 
	 * @param q 
	 * @return true if the transaction has been processed and false otherwise
	 */
	public static boolean process(Queue q) {
		if (checkToProcess(q)) {
			Transaction t = q.dequeue();
			System.out.println(t);
			if(t.isDebit()) {				
				float debited = t.getDebited();
				
				LinkedList list = t.getPerson().getAccounts();
				Node current = list.getHeader();
				
				
				while(current != null && current.getInfo().getBalance() < debited) {
					
					current = current.getNext();
				}
				if (current == null) {
					System.out.println("Insufficiant funds");
					return true;
				}
				System.out.println("proceeding with the payment");
				float account_balance = current.getInfo().getBalance();
				
				if (account_balance >= debited) {
					float newB = account_balance - debited;
					
					current.getInfo().setBalance(newB);
					System.out.println("Transaction processed succesfully");
					System.out.println("account: "+current.getInfo());
				}
				return true;
				
			}
			
			else if (t.isCredit()) {

				float account_balance = t.getPerson().getAccounts().getHeader().getInfo().getBalance();
				float credited = t.getCredited();
				float newB = account_balance + credited;
				t.getPerson().getAccounts().getHeader().getInfo().setBalance(newB);
				System.out.println("Transaction processed succesfully");
				System.out.println("account: "+t.getPerson().getAccounts().getHeader().getInfo().toString());
				return true;
			}
			
			else {
				int count = 0;
				float transferred = t.getTransferred();
				Node current = t.getPerson().getAccounts().getHeader();
				while(current != null && current.getInfo().getBalance() < transferred) {
					current = current.getNext();
					count++;
				}
				if (current == null) {
					System.out.println("Insufficiant funds");
					return true;
				}
				float account_balance = current.getInfo().getBalance();
				if (account_balance >= transferred) {
					float newB = account_balance - transferred;
					current.getInfo().setBalance(newB);
					System.out.println("Transaction processed succesfully");
					System.out.println("account: "+current.getInfo());
					
				}
				return true;
				
			}
		}
		else {
			System.out.println(q.toString());
			return false;
		}
	}
	
	
	
	public static void main(String[] arg) throws FileNotFoundException {  
		LocalDate day;
		LocalTime time;
		DayOfWeek dayOfTheWeek = LocalDate.now().getDayOfWeek();
		boolean process;
		Queue q = new Queue();
		ArrayList<Person> users = getUsers();
		String idNum;
		boolean proceed;
		Person user = null;
		 do{
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome");
			System.out.println("Enter your identification number:");
			idNum = scan.nextLine();
			proceed = identification(idNum);	
		}while (!proceed);
		 for (int i= 0; i< users.size(); i++) {
			 if (users.get(i).getClient_number() == Integer.parseInt(idNum)) {
				 user = users.get(i);
				 System.out.println("Welcome "+ user.getName()+"!");
				break;
			 }
		 }		
		while(proceed) {
			displayMenu();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			Transaction t = new Transaction();
			t.setPerson(user);
			scan.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter the ammount you need to withdrawal: ");
				int debited = scan.nextInt();
				scan.nextLine();
				day = LocalDate.now();
				time = LocalTime.now();
				t.setDebited(debited);
				t.setDebit(true);
				t.setDate(day);
				t.setTime(time);
				q.enqueue(t);
				System.out.println("--------------------------");
				break;
			case 2:
				System.out.println("Enter the ammount you need deposit: ");
				int credited = scan.nextInt();
				scan.nextLine();
				t.setCredited(credited);
				day = LocalDate.now();
				time = LocalTime.now();
				t.setCredit(true);
				t.setDate(day);
				t.setTime(time);
				q.enqueue(t);
				System.out.println("-------------------------");
				break;
			case 3:
				System.out.println("Enter the ammount you need transfer: ");
				int transfered = scan.nextInt();
				scan.nextLine();
				t.setTransferred(transfered);
				day = LocalDate.now();
				time = LocalTime.now();
				t.setTransfer(true);
				t.setDate(day);
				t.setTime(time);
				q.enqueue(t);
				System.out.println("--------------------------");
				break;
			case 4:
				System.out.println(user.toString());
				System.out.println("--------------------------");
				break;
			case 5:
				System.out.println("Account closed");
				System.out.println("--------------------------");
				proceed = false;
				break;
			}
			
		}

		while (dayOfTheWeek.equals(DayOfWeek.SUNDAY)) {
			//transaction cannot be processed on Sundays
			System.out.println("It is Sunday\nTransactions will be processed tommrow");
			process = false;
			main(arg);
		}
		process = true;
		if (process) {
			do {
				//the transactions in the queue can still be processed the same day
				process(q);	
			}
			while (process(q));	
			// the transactions cannot be processed till the next working day

		}			
		/**
		 * call the main method again to start again
		 */
		main(arg);

	}
	

}
