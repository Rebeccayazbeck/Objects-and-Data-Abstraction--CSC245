package question1;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
import java.util.Scanner;

public class BST {
	private Definition root;
	
	/**
	 * 
	 * @return the root of the tree
	 */
	public Definition getRoot() {
		return root;
	}
	
	
	public boolean add(String word, String description) {
	    if (root == null) {
	        root = new Definition(word, description);
	        return true;
	    }
	    return add(word, description, root);
	}

	private boolean add(String word, String description, Definition current) {
	    if (current.isEqual(word, description)) {
	        return false;
	    }
	    if (current.getWord().equalsIgnoreCase(word)) {
	    	current.getDescription().addLast(description);
	    	return true;
	    }
	    if (word.compareToIgnoreCase(current.getWord()) < 0) {
	        if (current.getLeft() == null) {
	            current.setLeft(new Definition(word, description));
	            return true;
	        }
	        return add(word, description, current.getLeft());
	    } else {
	        if (current.getRight() == null) {
	            current.setRight(new Definition(word, description));
	            return true;
	        }
	        return add(word, description, current.getRight());
	    }
	}

	
	/**
	 * delete a definition of a word inside the tree
	 * @param word the word to delete the definition for
	 * @return true if the definition was found 
	 */
	public boolean delete(String word) {
	    Definition current = root;
	    Scanner scan = new Scanner (System.in);
	    while (current!=null) {
	    	if (current.getWord().equalsIgnoreCase(word)) {
	    		System.out.println(current.getDescription());
	    		System.out.println("Enter the number of the definition you want to delete: ");
	    		int num = scan.nextInt();
	    		LL temp = current.getDescription();
	    		System.out.println(temp);
	    		boolean deleted = temp.delete(num-1);
	    		if (deleted) {
	    			System.out.println("Definition deleted successfully");
	    		    return true;
	    		}
	    			System.out.println("invalid number");
	    			return false;
	    		}
	    	if (word.toLowerCase().charAt(0)<=current.getWord().toLowerCase().charAt(0)) {
	    		current = current.getLeft();
	    	}
	    	else {
	    		current = current.getRight();
	    	}
	    }
	    return false;
	   
	}


	
	
	/**
	 * Search for an element inside the tree
	 * @param word the world to search for
	 * @return "No definition found" if the word was not found
	 */
	public String search(String word) {
		return search(word,root);
		
	}
	public String search(String word, Definition node) {
	    if (node == null) {
	        return "No definition found";
	    }
	    if(word.equalsIgnoreCase(node.getWord())) {
	    	return node.getWord()+":" +"\n"+ node.getDescription();
	    }
	    if (word.toLowerCase().charAt(0)<=node.getWord().toLowerCase().charAt(0))
	    return search(word, node.getLeft());
	    
	    else {
	        return search(word, node.getRight());
	    }
	}







}
