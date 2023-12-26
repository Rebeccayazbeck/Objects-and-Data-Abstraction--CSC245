package question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
public class Main {
	
	public static void displayMenu() {
		System.out.println("1.	Create the dictionary\r\n"
				+ "2.	Add a definition\r\n"
				+ "3.	Delete a definition\r\n"
				+ "4.	Search for a definition\r\n"
				+ "5.	Exit\r\n"
				+ "-----------------------------------\r\n"
				+ "Enter your choice:\r\n"
				+ "");
	}
	
	public static BST buildTree(String file) {
	    BST tree = new BST();
	    try  {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(":");
	            if (parts.length == 2) {
	                String word = parts[0];
	                String definition = parts[1];
	                tree.add(word, definition);
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("The file could not be found");
	    }
	    return tree;
	}

	
	public static void writeToFile(BST tree,String filename) {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	        writeInOrder(tree.getRoot(), writer);
	        writer.close();
	        System.out.println("Definitions written to file ");
	    } catch (IOException e) {
	        System.out.println("Error writing to file ");
	    }
	}

	private static void writeInOrder(Definition n, BufferedWriter writer) throws IOException {
	    if (n == null) {
	        return;
	    }
	    writeInOrder(n.getLeft(), writer);
	    writer.write(n.getWord() + ": " + n.getDescription());
	    writer.newLine();
	    writeInOrder(n.getRight(), writer);
	}


	public static void main(String[] args) {
		int choice;
		String word;
		BST dictionary = new BST();
		Scanner scan = new Scanner(System.in);
		do{
			displayMenu();
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			case 1 :
				int count = 0;
				System.out.println("Enter the name of the file to create the dictionary: ");
				String textFile = scan.nextLine();
				dictionary = buildTree(textFile);
				if (dictionary.getRoot() == null && count !=3) {
					count++;
					System.out.println("Enter the name of the file again to create the dictionary: ");
					textFile = scan.nextLine();
					dictionary = buildTree(textFile);
				}
				break;
				
			case 2 :
				System.out.println("Enter the word you would like to add:");
				word = scan.nextLine();
				System.out.println("Enter the description of the word: ");
				String definition = scan.nextLine();
				boolean added = dictionary.add(word,definition);
				if (added) {
					System.out.println("Definition added successfully");
				}
				else {
					System.out.println("Could not add the definition");
				}
				
				break;
				
			case 3:
				System.out.println("Enter the word you would like to delete: ");
				word = scan.nextLine();
				boolean deleted = dictionary.delete(word);
				if(deleted) {
					System.out.println("Operation completed successfully");
				}
				else {
					System.out.println("The word could not be found");
				}
				break;
			case 4:
				System.out.println("Enter the word you would like to search for: ");
				word = scan.nextLine();
				System.out.println(dictionary.search(word)); 
				break;
			case 5: 
				break;
			default:
				System.out.println("Enter a valid key");
				break;
			}	
		}while(choice != 5);
		
		System.out.println("Enter the file name where you need to save your dictionary");
		String textFile = scan.nextLine();
		writeToFile(dictionary,textFile);	
	}

	
}
