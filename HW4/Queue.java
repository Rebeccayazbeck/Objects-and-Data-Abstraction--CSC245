package question2;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 4/1/2023 
 * Description: Automated Teller Machine (ATM) that process several transactions per day
 * -------------------------------------------------------------------------
 * Files:
 * 		LinkedList.java
 * 		Transaction.java
 * 		ATM.java
 * 		Account.java
 * 		Person.java
 * 		Node.java
 */
public class Queue {
	
	Transaction[] q = new Transaction[10];
	private int front = 0;
	private int rear = 0;
	private int count = 0;
	
	public void enqueue(Transaction p) {
		if (rear == q.length) {
			if (q[0] == null)
				rear = 0;
			else {
				if (rear == front) {
					ensure_capacity();
				}
			}
		}
		q[rear] = p;
		rear++;
		count++;
	}
	

	public Transaction dequeue() {
		Transaction temp = q[front];
		
		if(rear == q.length-1 && front<rear) {
			rear = 0;
		}
		q[front] = null;
		front++;
		count--;
		
		return temp  ;
	}
	
	public int getCount() {
		return count;
	}
	
	private void ensure_capacity() {
		Transaction [] q_prime = new Transaction [q.length*2];
		int count = 0;
		for(int i = front ; i < q.length ; i++) {
			q_prime[count] = q[i];
			count++;
		}
		for (int i = 0; i <= rear; i++) {
			q_prime[count] = q[i];
			count++;
		}
		
		q = q_prime;
		front = 0;
		rear = count;
	}
	
	public Transaction getFront() {
		
		return q[front];
	}
	
	public String toString() {
		String temp = "";
		if (front > rear) {
		for(int i = front ; i < q.length ; i++) {
			if (q[i]!=null) {
				System.out.println("hi");
			temp +="\n\n"+ q[i].toString();
		}
		}
		for (int i = 0; i <= rear; i++) {
			if (q[i]!=null) {
			temp += "\n\n"+q[i].toString();
		}
		}
		return "Remaining transactions:\n"+ temp;
		}
		else {
			for(int i = front ; i < q.length ; i++) {
				if (q[i]!=null) {
				temp +="\n\n"+ q[i].toString();
				}
			}
			return "Remaining transactions:\n "+ temp+"\n\n\n";
		}
	}


}
