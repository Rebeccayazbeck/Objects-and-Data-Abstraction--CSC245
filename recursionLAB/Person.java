package lab5;

public class Person {
		private String name;
		private int age;
		/**
		 * constructor of the class person 
		 * @param n name of the person
		 * @param a age of the person
		 */
		public Person(String n , int a) {
			name = n;
			age = a;
		}
		
		/**
		 * get the age
		 * @return age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * set the age
		 * @param a the age to be set
		 */
		public void setAge(int a) {
			age = a;
		}
		/**
		 * set the name 
		 * @param n the name to be set
		 */
		public void setName(String n) {
			name = n;
		}
		/**'
		 * get the name
		 * @return name
		 */
		public String getName() {
			return name;
		}
		/**
		 * return all the information of the person
		 */
		 public String toString() {
			 return "name: "+name+" age: "+age;
		 }
		 
		 public boolean isEqual( Person p) {
			 if (name.equals( p.getName() )&& age == p.getAge()) {
				 return true;
			 }
			 return false;
		 }
	}
	

