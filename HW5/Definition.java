package question1;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
public class Definition {
	private String word;
	private LL description =  new LL();
	private Definition left;
	private Definition right;
	
	
	/**
	 * Constructor of class Node
	 * @param w the word stored inside the node
	 * @param des the description of the node inside the node
	 * @return 
	 */
	public Definition(String w, String d) {
		word = w ;
		description.addLast(d);
		
	}


	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}


	/**
	 * @param w the word to set
	 */
	public void setWord(String w) {
		word = w;
	}


	/**
	 * @return the description
	 */
	public LL getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(LL d) {
		description = d;
	}


	/**
	 * @return the left
	 */
	public Definition getLeft() {
		return left;
	}


	/**
	 * @param l the left to set
	 */
	public void setLeft(Definition l) {
		left = l;
	}


	/**
	 * @return the right
	 */
	public Definition getRight() {
		return right;
	}


	/**
	 * @param r the right to set
	 */
	public void setRight(Definition r) {
		right = r;
	}
	
	public boolean isEqual(String w, String desc) {
		Node current = description.getHeader();
		
		while (current!=null) {
			if (w.equalsIgnoreCase(word)&&desc.equalsIgnoreCase(current.getInfo())) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
}
