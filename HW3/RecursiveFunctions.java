package homework3;

import java.util.Arrays;
import java.util.Vector;

public class RecursiveFunctions {

	/**
	 * Recursive function that returns the number of times c occurs in s. 
	 * @param s String 
	 * @param c character to be checked
	 * @return number of occurrences
	 */
	public static int CountOccurrences(String s, char c) {
	
		if (s.length() == 0)
			return 0;
		if (s.charAt(0)== c)
			return 1 + CountOccurrences(s.substring(1),c);
		else 
			return CountOccurrences(s.substring(1),c); 
	}
	/**
	 * Iterative function that returns the number of times c occurs in s.
	 * @param s String
	 * @param c character to be checked
	 * @return number of occurrences
	 */
	public static int iterativeCountOccurrences(String s,char c){
		int count = 0;
		for (int i = 0; i< s.length() ; i++) {
			if (c == s.charAt(i))
				count++;	
		}
		return count;
	}
	
	/**
	 * Recursive function returns the number of times sub occurs in s.
	 * @param s String 
	 * @return the number of occurrences
	 */	
	public static int CountSubstrings(String s, String sub) {
		if (s.length()<sub.length())
			return 0;
		
		else {
			String temp = s.substring(0,sub.length());
				if (temp.equals(sub)) {
					return 1 + CountSubstrings(s.substring(1), sub);
				}
			
			return 	CountSubstrings(s.substring(1), sub);
		}
	}
	
	/**
	 * Iterative function returns the number of times sub occurs in s.
	 * @param s String 
	 * @param sub String to be checked 
	 * @return the number of occurrences
	 */	
	public static int iterativeCountSubstrings(String s, String sub) {
		int count = 0;
		for (int i = 0; i<s.length(); i++) {
			String temp = "";
			int steps = 0;
			for (int j=i; j < s.length();j++){
				steps++;
				temp += s.charAt(j);
				if (temp.equals(sub)) {
					count++;
				}
				if (steps==sub.length())
					break;
			}
		}
		return count;
	}
	
	/**
	 * Recursive method that prints k subsets that form a partition of a
	 * @param a the original array
	 * @param k the number of subsets
	 */
	public static void Partition(int[] a, int k) {	
		if ((k>a.length)|| (k==0))  {
			System.out.println("Please enter a number of subsets equal or smaller to the number of elements in the array and diffrent than 0");
			return;
		}
		if (a.length == 0 ) {
			return;
		}
		else if (k<=1) {
			System.out.println(Arrays.toString(a));
			return;
		}
		else {
			int[] b = Arrays.copyOfRange(a,0,a.length/2);
			int[] c = Arrays.copyOfRange(a,a.length/2,a.length);
			if (k%2==0) {
				Partition(b,k/2);
				Partition(c,k/2);
			}
			else {
				Partition(b,k/2);
				Partition(c,k/2 + 1);
			}
		}
	}
	/**
	 * prints all possible permutations of the characters in a
	 * @param a the array 
	 * @param index should be set to 0 while calling the method.
	 */
	private static void permute(char[] a, int index) {
	    if (index == a.length - 1) {
	        System.out.println(new String(a));
	        return;
	    }
	    permute(a, index + 1);
	    for (int i = index + 1; i < a.length; i++) {
	        if (a[i] != a[index]) {
	            char temp = a[index];
	            a[index] = a[i];
	            a[i] = temp;
	            permute(a, index + 1);
	            a[i] = a[index];
	            a[index] = temp;
	        }
	    }
	}
	
	/**
	 * prints all elements in the array that are bigger than their neighbors.
	 * @param a the array
	 * 
	 */
		public static void greatNeighbor(int[] a) {	
			if (a.length == 0) {
				return;
			}
			else if (a.length==1) {
				System.out.println(a[0]);
				return;
			}
			else if (a.length==2) {
				if (a[1]>a[0]) {
					System.out.println(a[1]);
					return;
				}
				else {
					System.out.println(a[0]);
					return;
				}
			}
			else {
				boolean printed = false;
				int[] b = Arrays.copyOfRange(a,0,3);
				if (b[1]>b[0] && b[1]>b[2]) {
					printed = true;
					System.out.println(b[1]);
				}
				int[] c = Arrays.copyOfRange(a,1,a.length);
				
				if (c.length==2 && printed == true) {
					return;
				}

				greatNeighbor(c);
				
				
			}
			
			}
		
	
	
	
	
	public static void main(String[] args) {
		
		char [] c = {'a','b','c'};
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[]b = {2, 6, 7, 5, 9, 3, 13};
		System.out.println(CountOccurrences("REBECCA", 'a'));
		System.out.println(iterativeCountOccurrences("rebecca",'e'));
		System.out.println(CountSubstrings("rebeccayazbeckrebecca", "reb"));
		System.out.println(iterativeCountSubstrings("rebeccayazbeckrebecca","reb"));
		Partition(a , 7);
		permute(c, 0);
		greatNeighbor(b);
		
	}

}
