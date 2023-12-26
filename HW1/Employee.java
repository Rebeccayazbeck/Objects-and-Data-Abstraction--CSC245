package Homework1;

public class Employee {
	protected String firstName;
	protected String lastName;
	protected String hireDate;
	protected Double salary;
	
	/**
	 * Constructor with all employee attributes
	 * @param fn first name of the employee
	 * @param ln last name of the employee
	 * @param hd hire date of the employee
	 * @param s salary of the employee
	 */
	public Employee(String fn, String ln, String hd, Double s) {
	
		firstName = fn;
		lastName = ln;
		hireDate = hd;
		salary = s;
	}
	/**
	 * Constructor with first name, hire date and salary and last name set to " "
	 * @param fn first name of the employee
	 * @param hd hire date of the employee
	 * @param s salary of the employee
	 */
	public Employee(String fn, String hd, Double s) {

		firstName = fn;
		lastName = " ";
		hireDate = hd;
		salary = s;
	}
	/**
	 * Constructor with the first name and last name of the employee
	 * @param fn first name of the employee
	 * @param ln last name of the employee
	 */
	public Employee(String fn, String ln) {

		super();
		firstName = fn;
		lastName = ln;
	}
	/**
	 * Constructor with only the first name of the employee and set last name to " "
	 * @param fn first name of the employee
	 */
	public Employee(String fn) {

		super();
		firstName = fn;
		lastName = " ";

	}
	
// Accessors:
	/**
	 * Get the first name of the employee
	 * @return the first name of the employee
	 */
	public String getFirstName() { 
		return firstName;
	}
	/**
	 * set the name of the employee
	 * @param fn the first name to be set 
	 */
	public void setFirstName(String fn) {
		firstName = fn;
	}
	/**
	 * Get the last name of the employee
	 * @return the last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Set the last name of the employee
	 * @param ln the last name to be set
	 */
	public void setLastName(String ln) {
		lastName = ln;
	}
	/**
	 * 	Get hire date of the employee
	 * @return the hire date of the employee
	 */
	public String getHireDate() {
		return hireDate;
	}
	/**
	 * Set the hire date of the employee
	 * @param hd the hire date to be set
	 */
	public void setHireDate(String hd) {
		hireDate = hd;
	}
	/**
	 * Get the salary of the employee
	 * @return the salary of the employee
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * Set salary of the employee
	 * @param s the salary to be set
	 */
	public void setSalary(Double s) {
		salary = s;
	}
	
	/**
	 * Raise the salary of the employee
	 * @param raise the raise percentage
	 */
	public void raiseSalary(float raise) {

		salary +=  salary*raise;

	}
	
	/**
	 * Get the string representation of the employee
	 * @return the string representation of the employee
	 */
	@Override
	public String toString() {

		return "firstName= " + firstName + ", lastName= " +lastName + ", hireDate= " +
				hireDate + ", salary= " + salary;
	}

	/**
	 *checks if this employee is equal to another employee 
	 * @param e the other employee to compare
	 * @return true if the employees are equal, false otherwise
	 */
	public Boolean equals(Employee e) {
		return firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName());
	}
	

}
