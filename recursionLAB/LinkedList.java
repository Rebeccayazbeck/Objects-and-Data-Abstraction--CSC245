package lab5;

public class LinkedList implements DataStructure{
	
	private Node header = null;
	private Node max = null;

	/**
	 * @return the header
	 */
	public Node getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(Node h) {
		header = h;
	}
	/**
	 * @return the max
	 */
	public Node getMax() {
		return max;
	}
	
	/**
	 * @param max the max to set
	 */
	public void setMax(Node m) {
		max = m;
	}

	@Override
	public void add(Person p, Node current) {
		Node n = new Node(p);
		if (header == null) {
			header = n;
			return;
		}
		if (current.getNext()== null) {
			current.setNext(n);
			System.out.println("Person successfully added");
		}
		else {
			current = current.getNext();
			add(p,current);
		}
	}

	@Override
	public Node find(Person p, Node current) {
		if (current == null) {
			return null;
		}
		if (current.getInfo().isEqual(p)) {	
			return current;
		}
		else {
		current = current.getNext();
		return find(p, current);
		}
	}

	@Override
	public int countOccurences(Person p, Node current) {
		if (find (p,current)==null) {
			return 0;
		}
		else {
			current = find(p,current);
			return 1 + countOccurences(p,current.getNext());
		}
	}
	
	public int size() {
		int count = 0;
		Node current = header;
		if (header == null)
			return count;
		if (current != null)
			count++;
		while (current.getNext()!= null) {
			current = current.getNext();
			count++;
		}
		return count;
	}
	
	public void updateMax(Node current) {
		if (current == null) {
			return;
		}
		if ( max == null ||max.getInfo().getAge()< current.getInfo().getAge()) {
			max =  current;
		}
		current = current.getNext();
		updateMax(current);
	}

	
}
