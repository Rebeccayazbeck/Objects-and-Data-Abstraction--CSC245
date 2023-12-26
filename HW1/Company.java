package Homework1;
import java.util.Scanner;

public class Company {
	
	// declare array of type Employees
	protected static Employee[] employees;
	//counter will be incremented every time a new employee is added
	protected static int counter = 0;
	/**
	 * create a new array of employees 
	 * @param size the size of the array
	 */
	public Company (int size) {
		employees = new Employee[size];
	}
	/**
	 * ensure the capacity of the array to add a new employees
	 */
	public static void ensureCapacity() {
		
		// declare variable nulls to track the number of nulls in the  array
		int nulls = 0;
		// create the array new_employees
		Employee[] new_employees =  new Employee[employees.length + 10];
		// iterate through the main array
		for (int i = 0; i < employees.length; i++) {
			
			if (employees[i] != null) {
				/*add elements not equal to null to the new array
				 *using the index [i-nulls] to keep the objects juxtaposed inside the new array
				 */
				new_employees[i - nulls] = employees[i];
			} else {
				nulls += 1;
			}
			
		}
		employees= new_employees ;
		}
	
		/**
		 * checks if the employee already exists in the array
		 * @param e Employee that needs be be checked
		 * @return true if the employee doesn't already exists and false otherwise
		 */
	public static Boolean checkNewEmployee(Employee e) {
		
		for ( Employee employee: employees) {
			if (employee != null && employee.equals(e)) return false;
		}
		if (counter == employees.length) ensureCapacity();
		employees[counter] = e;
		counter ++;
		// increment counter by 1 
		return true;
		
	}
	
	/**
	 *  display the menu and ask for the user's choice
	 */
	public static void displayMenu() {
		
		System.out.println("1.Add employee\n"+"2.Delete employee\n"+ "3.Raise salary\n"+ "4.List all\n"+ "5.Exit");
		System.out.println("-----------------------");
		System.out.println("ENTER YOUR CHOICE");
	}
	
	/**
	 * ask if the employee is a manager or not 
	 * @return true if the employee is a manager and false otherwise
	 */
	public static Boolean isManager() {
	
		Scanner scan = new Scanner(System.in);
       	System.out.println("IS YOUR EMPLOYEE A MANAGER?\n"+"1-YES\n"+"2-NO");
    	int choice = scan.nextInt();
    	
    	if (choice == 1) {
    		return true;
    	}
    	else if (choice == 2) {
    		return false;		
    	}
    	else {
    		// if the user enter any other option the employee will not be considered as a manager by default
    		System.out.println("your employee will not be considered as a manager");
    		return false;
    	}
	}
	
	/**
	 * Creates a new employee by reading the information from keyboard
	 * @return true if the employee was successfully added to the array and false otherwise
	 */
	public static Boolean addEmployee() {

		// this boolean will take the value true if the employee was successfully added to the array
		Boolean added = false;
		Scanner scan = new Scanner(System.in);

		// the input should have this format: first name , last name
    	System.out.println("ENTER FIRST NAME , LAST NAME: ");
    	String firstLastName = scan.nextLine();
    	// temp is a temporary array to separate the first name and last name
    	String[] temp = firstLastName.split(" , ");
    	
    	System.out.println("ENTER HIRE DATE: ");
    	String hireDate = scan.nextLine();
    	
    	System.out.println("ENTER SALARY: ");
    	Double salary = scan.nextDouble();
    	// result is to determine whether a manager or Employee should be created
       	Boolean result = isManager();
       
       	
       	if (result==true) {
       		// if the employee is a manager it asks for the secretary name
       		System.out.println("Enter Secretary Name");
       		String secretary = scan.next();
       		
       		if (temp.length == 2) {
       			// assign the first world to first name and second world to last name as 2 names are entered
        		String firstName = temp[0];
        		String lastName = temp [1];
        		// creates the new manager
       			Employee m = new Manager( firstName ,lastName ,hireDate,salary,secretary);
       			added = checkNewEmployee(m);
       			
       			}
       		else if (temp.length == 1) {
       			// assign the input only to the first name as one name is entered
       			String firstName = temp[0];
       			// creates a new manager
       			Employee m = new Manager(firstName, hireDate , salary, secretary);
       			added = checkNewEmployee(m);
       			
       		}
       	}
       		
       	else {
       		if (temp.length == 2) {
       			// assign the first world to first name and second world to last name as 2 names are entered
        		String firstName = temp[0];
        		String lastName = temp [1];
       			Employee e = new Employee( firstName ,lastName ,hireDate,salary);
       			added = checkNewEmployee(e);
       			
       			}
       		else if (temp.length == 1) {
       			// assign the input only to the first name as one name is entered
       			String firstName = temp[0];
       			// creates a new employee 
       			Employee e = new Employee(firstName, hireDate , salary);
       			added = checkNewEmployee(e);
       			
       		}
       	}
       return added;	
}
	/**
	 * take input from the user and create an employee
	 * @return e Employee with either first name and last name or first name only
	 */
	
	public static Employee readEmployeeFromKeyboard() {

		// the input should have this format: first name , last name
		Scanner scan = new Scanner (System.in);
		Employee e = null;
    	System.out.println("ENTER FIRST NAME , LAST NAME: ");
    	String firstLastName = scan.nextLine();
    	// temp is a temporary array to separate the first name and last name
    	String[] temp = firstLastName.split(" , ");
    	if (temp.length == 2) {
   			// assign the first world to first name and second world to last name as 2 names are entered
    		String firstName = temp[0];
    		String lastName = temp [1];
    		 e = new Employee(firstName , lastName);
    		}
   		else if (temp.length == 1) {
   			// assign the input only to the first name as one name is entered
   			String firstName = temp[0];
   		    e = new Employee(firstName);

   			}
		return e;
	}
	
	/**
	 * checks for the employee inside the array and if found changes it's location to null 
	 * @param e Employee with first name and last name that needs to be checked
	 * @return true if the employee is found and changes are successfully made and false if not
	 */
	
	public static Boolean deleteEmployee( Employee e) {

		for (int i = 0; i < employees.length; i ++) {
			if (employees[i]!= null && employees[i].equals(e)) {
				employees[i] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * iterate through the array of employees 
	 * check if each employee is a manager or not
	 * display all the employee's information with "M-" at the beginning of the line if the employee is a manager
	 */
	public static void displayAll() {

		for ( Employee employee: employees) {
			if (employee instanceof Manager == true) {
				System.out.printf("M- " + employee.toString()+"\n");
				
			}
			else {
				if(employee != null) {
				System.out.printf(employee.toString()+"\n");
				}
			}
		}	
	}
	 /**
	  * checks if the employee exists in the array and if found asks for the raise percentage
	  * @param e Employee to be checked
	  * @return true if changes are made and false if not
	  */
	
	public static Boolean raiseSalary( Employee e) {
		
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < employees.length; i ++) {
			if (employees[i]!= null && employees[i].equals(e)) {
				System.out.print("Enter the raise percentage\n%");
				float raise = scan.nextFloat();
				raise = raise/100;
				employees[i].raiseSalary(raise);
				return true;	
			}
		}
		return false;
	}
	
	
	
	
	//main method:
	public static void main(String[] args) {
		Company employees = new Company (10);
		// declare variable choice to store the user's choice
		int choice;
		// declare variable count to count numbers of consecutive invalid input
		int count = 0;
		// use the scanner to read from keyboard the user's choice
		Scanner scan = new Scanner(System.in);
		
		do {displayMenu();
			choice = scan.nextInt();
	
			switch(choice) {
			
				case 1 :
					// Add Employee
					Boolean added = addEmployee();
					// check if addEmployee was successfully executed or not
					if (added == true) {
						System.out.println("Employee successfully added");
					}
					else {
						System.out.println("Operation failed\nEmployee already added");
					}
					
					count = 0;
					break;
					
					
				case 2 :
					// delete employee
					Employee e = readEmployeeFromKeyboard();
					Boolean deleted = deleteEmployee(e);
					if (deleted == true) {
						System.out.println("Records successfully deleted");
					}
					else {
						System.out.println("Operation failed\nEmployee not found");
					}
					count = 0;
					break;
				
				
				case 3:
					 e = readEmployeeFromKeyboard();
					 Boolean raised = raiseSalary(e);
					 if (raised == true) {
						 System.out.println("salary successfully modified");
					 }
					else {
						 System.out.println("Operation failed\nEmployee not found");
						} 
					
					count = 0;
					break;
				
				
				case 4:
					displayAll();
					count = 0 ;
					break;
				
				
				default:
					/* 5 default options entered will result in the closure of the program.
					 * every default choice different than "5" will increment count by 1
					 * choosing "5" will automatically close the program.
					 */
					if (count < 4 && choice !=5) {
						System.out.println("Enter a valid option!");}
					count++;
					break;
			}
		}while (choice!= 5 && count != 5);
		System.out.println("The Program has been closed");

	}
}
