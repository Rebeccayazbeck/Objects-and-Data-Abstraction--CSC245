package question1;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 23/3/2023 
 * Description: program that processes postfix
 * -------------------------------------------------------------------------
 * Files:
 * 		Main.java
 * 		Stack.java
 */
public class Node1 {

	private  String info;
	private Node1 next;
	
	public Node1 (String i) {
		info = i ;
		next = null;			
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String i) {
		 info = i;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext( Node1 n) {
		next = n;
	}	

}
