package recursion;

public class Recursion {
	
	/*1) count abc: int count abc(strings)
 * count recursively the total number of "abc" and "aba" substrings that appear in the given string.
 * 2) string remove str(string s1)
 * recursively removes any similar, consecutive character (for example ssstttrrr becomes str.
 * 3) fibonacci sequence: int fib (int n)
 * get the mth fibonacci sequence in the sequence.
 * 4) boolean strCopics (String st, String str, int n)
 * Given a string s and a non-empty substring sub, compute recursively f at least n copies of sub
 * overlaps,n should be non-negative
 * 5) String parentBit(String s)
 * given a string that contains a single pair of parenthesis, compute recursively a new string 
 * made of only the parenthesis and the content s.
 * parentBit("xyz(abc)123" ---> (abc)
 * parentBit("x(hello)")--> (hello)
 * parentBit ("x)(hello)")--->(hello)
 * 
 */
	public static int countABC(String s) {
		if (s.length()<3)
			return 0;
		
		else {
			String temp =s.substring(0,3);
				if (temp.equals("abc") || temp.equals("aba")) {
					return 1 + countABC(s.substring(3));
				}
			}
			return 	countABC(s.substring(1));
	}
	
	public static String removeString(String s) {
		if (s.length()<2)
			return s;
		else if (s.charAt(0)==s.charAt(1)) {
			return removeString(s.substring(1));
		}
		else {
			return s.charAt(0)+ removeString(s.substring(1));
		}
	}
	
	public static int fibonacci(int n) {
		if (n<2) {
			return n;
		}

		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static boolean strCopics(String st, String str, int n) {
		if (n<0) {
			return false;
		}
		else if (n==0) {
			return true;
		}
		else if (st.length()<str.length())
				return false;
			
			else {
				String temp =st.substring(0,str.length());
					if (temp.equals(str)) {
						return strCopics(st.substring(1),str,n-1);
					}
				}
				return 	strCopics(st.substring(1),str,n);
		}
	
	public static String parentBit(String s) {

		if (s.length() == 0) {  
			    return "";
			  }
	     if (s.charAt(0) == '(') {  
			    int endIndex = s.indexOf(')'); 
			    return s.substring(0, endIndex + 1); 
			  } 
	     else {  
			    return parentBit(s.substring(1));			  }
		
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(countABC("abaaabbabababcabcabc"));
		System.out.println(fibonacci(6));
		System.out.println(strCopics("rebecca","c",3));
		System.out.println(removeString("rebeccaaaaa"));
		System.out.println(parentBit(")dgshgdhjj(hi)"));
	}
}