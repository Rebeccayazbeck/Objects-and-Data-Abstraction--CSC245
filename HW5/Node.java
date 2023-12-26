package question1;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
public class Node {
	private  String info;
	private Node next;
	
	public Node (String a) {
		info = a ;
		next = null;			
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String a) {
		 info = a;
	}
	public Node getNext() {
		return next;
	}
	public void setNext( Node n) {
		next = n;
	}	

}

