package lab5;

import java.util.Scanner;
/*
 * Ex 1: Given a string and a non-empty substring sub,
 * compute recursively the largest substring which starts
 * and ends with sub and return its length
 * strDist("catcowcat","cat")--> 9
 * strDist("cat,cow,cat","cow")-->3
 * strDist("c,catcowcatxx,catcowscat","cat")-->9
 * 
 * Ex2: Define class person that has a name and an age.
 * Define interface DataStructure that has the following 
 * methods: add, find, countOccurences
 * Define class LinkedList that implements dataStructure
 * and allows to store instances of class Person
 * the linkedlist class must implement the following recursively
 * add: which adds to the end of the list
 * find which search for an object in the list
 * countOccurences (Person p ):returns how many times p
 * appear in the list
 * max:returns a pointer to the person that has the highest Age
 * 
 * persons are equal if they have the same name and age.
 */

public class RecursionPractice2 {
	
	public static void main(String[] arg) {
		int choice;
		LinkedList ll = new LinkedList();
		Scanner scan = new Scanner(System.in);
		
		do{
			displayMenu();
			choice = scan.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter the person's name: ");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println("Enter the person's age: ");
					int age = scan.nextInt();
					scan.nextLine();
					Person p = new Person(name , age);
					ll.add(p,ll.getHeader());
					System.out.println(ll.getHeader().getInfo());
					System.out.println(ll.size());
					ll.updateMax(ll.getHeader());
					System.out.println(ll.getMax().getInfo());
					break;
				
				case 2:
					System.out.println("Enter the person's name: ");
					scan.nextLine();
					name = scan.nextLine();
					System.out.println("Enter the person's age: ");
					age = scan.nextInt();
					scan.nextLine();
					p = new Person(name , age);
					System.out.println(ll.getHeader().getInfo());
					ll.find(p, ll.getHeader());
					break;
			
				case 3:
					System.out.println("Enter the person's name: ");
					scan.nextLine();
					name = scan.nextLine();
					System.out.println("Enter the person's age: ");
					age = scan.nextInt();
					scan.nextLine();
					p = new Person(name , age);
					System.out.println(ll.countOccurences(p, ll.getHeader()));
					break;
			}
		} while(choice!=4);
		
		System.out.println(strDist("cca,ccarebecca,ccarebxecca", "cca"));
}
	
	
	
	
	
	
	public static void displayMenu() {
		System.out.println("1) add a person");
		System.out.println("2) find a person");
		System.out.println("3) return occurence of a person");
		System.out.println("------------------------------");
		System.out.println("ENTER YOUR CHOICE: ");
	}
	
	public static int strDist(String s, String sub) {
		 String[]str = s.split(",");
		 int lsub = sub.length();
		 int ls = str[0].length();
		 		
		if (ls < lsub) {
			return 0;
		}
		if (str.length != 1) {
			if ((str[0].substring(0,lsub).equals(sub) )&& (str[0].substring(ls-lsub,ls).equals(sub)) ){
				if (ls+1<s.length()) {
					if (strDist(s.substring(ls+1, s.length()),sub) < str[0].length()) {
						return str[0].length();
					}
					else
						return strDist(s.substring(ls+1, s.length()),sub);
				}
			}
		}
	
			if((str[0].substring(0,lsub).equals(sub) )&& (str[0].substring(ls-lsub,ls).equals(sub)) ) {
				return str[0].length();
			}
			else {
				return 0;
			}
			
	 }    
}	    	
	    	
	    
