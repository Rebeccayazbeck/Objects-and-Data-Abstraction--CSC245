package question1;
/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 23/3/2023 
 * Description: program that processes postfix
 * -------------------------------------------------------------------------
 * Files:
 * 		Node.java
 * 		Stack.java
 */
public class Main {
	
	public static boolean postfixValidate(String s,Stack numbers, Stack signs)  {
		if (s == "") {
			return true;
		}
		else if (Character.isDigit(s.charAt(s.length()-1))) {
			return false;
		}
		else if (Character.isDigit(s.charAt(0))) {
			
			int i =0;
			String temp="";
			while(Character.isDigit(s.charAt(i))) {
				
				temp += s.charAt(i);
				i++;
			}
			numbers.push(temp);
			return postfixValidate (s.substring(i), numbers, signs);
		}
		else if (s.charAt(0) == '/' ||s.charAt(0) == '*'||s.charAt(0) == '+'||s.charAt(0) == '-' ) {
			signs.push((Character.toString(s.charAt(0))));
			
			if (numbers.getCount() <= signs.getCount()) {
				
				return false;
			}
			else {
				
				return postfixValidate (s.substring(1), numbers, signs);
			}
		}
		else if (s.charAt(0) == ' ') {
		
		return postfixValidate (s.substring(1), numbers, signs);
	}
		return false;
	}
	
	public static int postfixEvaluate(String s, Stack numbers) {
		if (s == "") {
			int result = Integer.parseInt(numbers.pop());
			return result;
		}
		else if (Character.isDigit(s.charAt(0))) {
			
			int i =0;
			String temp="";
			while(Character.isDigit(s.charAt(i))) {
				temp += s.charAt(i);
				i++;
			}
			numbers.push(temp);
			return postfixEvaluate (s.substring(i), numbers);
		}
		else if (s.charAt(0) == '/') {
			int z2 = Integer.parseInt(numbers.pop());
			int z1 = Integer.parseInt(numbers.pop());
			int result = z1/z2;
			numbers.push(Integer.toString(result));
		}
		else if (s.charAt(0) == '*') {
			int z2 = Integer.parseInt(numbers.pop());
			int z1 = Integer.parseInt(numbers.pop());		
			int result = z1 * z2;
			numbers.push(Integer.toString(result));
		}
		else if (s.charAt(0) == '+') {
			int z2 = Integer.parseInt(numbers.pop());
			int z1 = Integer.parseInt(numbers.pop());
			int result = z1 + z2;
			numbers.push(Integer.toString(result));
		}
		else if (s.charAt(0) == '-') {
			int z2 = Integer.parseInt(numbers.pop());
			int z1 = Integer.parseInt(numbers.pop());
			int result = z1-z2;
			numbers.push(Integer.toString(result));
		}
		return postfixEvaluate (s.substring(1), numbers);
		
	}
	
	public static void postfix(String s) {
		Stack numbers = new Stack ();
		Stack signs = new Stack();
		if (postfixValidate(s,numbers,signs)) {
			System.out.println("result of the operation: "+ postfixEvaluate(s,numbers));
		}
		else {
			System.out.println("operation failed");
		}
	}
		
	public static void main(String[] args) {
		String s = "7 3 5 * + 4 -";
		postfix(s);
		
		
	}

}
