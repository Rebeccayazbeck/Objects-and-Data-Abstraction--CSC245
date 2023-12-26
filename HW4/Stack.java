package question1;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 23/3/2023 
 * Description: program that processes postfix
 * -------------------------------------------------------------------------
 * Files:
 * 		Node.java
 * 		Main.java
 */
public class Stack {
	
	private Node1 top;
	private int count = 0;
	
	public void push(String i) {
		Node1 n = new Node1 (i);
		n.setNext(top);
		top = n;
		count++;
	}
	
	public String pop() {
		Node1 temp = top;
		top = top.getNext();
		temp.setNext(null);
		
		count--;
		return temp.getInfo();
	}
	
	 public String getTop() {
		 return top.getInfo();
	 }

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}





}
