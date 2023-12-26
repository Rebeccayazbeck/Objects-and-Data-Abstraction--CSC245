package question1;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
public class LL {
private Node header ;
	
	/**
	 * 
	 * @return the header of the LinkedList
	 */
	public Node getHeader() {
		return header;
	}

	
	public void addLast(String a) {
		Node n = new Node(a);
		if (header == null) {
			header = n;
			return;
		}
		Node current = header;
		while (current.getNext()!=null) {
			current = current.getNext();
		}
		current.setNext(n);
		
	}
	
	public boolean insert(String a, int index) {
		
		if (index<0 || index>size()) {
			return false;
		}
    	else if (index == size()) {
			addLast(a);
			return true;
		}
		else if (index == 0) {
			Node n = new Node(a);
			n.setNext(header.getNext());
			header = n;	
			return true;
		}
		else {
			Node n = new Node(a);
			Node current = header;
			int count = 0;
			while (count<index) {
				current = current.getNext();
			}
			n.setNext(current.getNext());
			current.setNext(n);
			return true;
		}
		
	}
	
	public boolean delete (int k) {
		

		if (k<0 || k > size()-1)
			return false;
		
		else {
			if (k == 0) {
				Node current = header;
				header = header.getNext();
				current.setNext(null);
				current = null;
				
				return true;	
			}
			else if (k==size()-1) {
				Node current = header;
				for (int j = 0 ; j< size()-1; j++) {
					current = current.getNext();
				}
				current.setNext(null);
				current = null;
				
				return true;
			}
			else {
				Node current = header;
				for (int j = 0 ; j< k; j++) {
					
					current = current.getNext();
				}
				
				Node temp = current.getNext();
				current.setNext(current.getNext().getNext());
				temp.setNext(null);
				temp = null;
				current = null;
				return true;
			}
		}
	}


	public int size() {
	    Node current = header;
	    int count = 0;
	    while (current != null) {
	        count++;
	        current = current.getNext();
	    }
	    return count;
	}

	
	public String toString() {
		
		String temp = 1 +" "+ header.getInfo().toString();
		Node current = header;
		int i = 2;
		while (current.getNext()!=null) {
			current = current.getNext();
			temp += "\n"+i+" "+current.getInfo().toString();
			i++;
		}
		return temp;

	}
}
