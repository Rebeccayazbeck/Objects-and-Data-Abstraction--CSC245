package lab5;

public class Node {
	private Person info;
	private Node next;
	
	/**
	 * constructor of the class node
	 * @param p the person to be stored inside the node
	 */
	public Node(Person p) {
		info = p;
		next =  null;
	}
	
	/**
	 * get the person inside the node
	 * @return info of type person
	 */
	public Person getInfo() {
		return info;
	}
	/**
	 * set the person inside the node
	 * @param p of type person
	 */
	public void setInfo(Person p) {
		info =p;
	}
	/**
	 * get the next node pointed to by this node
	 * @return next of type node
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * set the node pointer to a node
	 * @param n of type node
	 */
	public void setNext(Node n) {
		next = n;
	}
}
