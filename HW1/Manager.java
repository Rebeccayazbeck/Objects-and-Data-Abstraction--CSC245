package Homework1;

public class Manager extends Employee {
	private String secretary;
	protected String firstName;
	/**
	 * Constructor with all manager attributes
	 * @param fn the first name of the manager
	 * @param ln the last name of the manager
	 * @param hd the hire date if the manager
	 * @param s the salary of the manager
	 * @param sec the secretary name of the manager
	 */
	public Manager(String fn, String ln, String hd, Double s, String sec) {
		// call superclass constructor with provided first name, last name, hire date and salary
		super(fn, ln, hd, s);
		// Assign secretary name
		secretary = sec;
	}
	 /**
	  * Construction with first name, hire date, salary and secretary, last name set to " "
	  * @param fn first name of the manager
	  * @param hd hire date of the manager
	  * @param s salary of the manager
	  * @param sec secretary of the manager
	  */
	public Manager(String fn, String hd, Double s, String sec) {
		// call superclass constructor with provided first name, hire date and salary
		super(fn, hd, s);
		//set last name to null
		lastName = " ";
		// assign secretary name 
		secretary = sec;
	}
	public void raiseSalary(float raise) {

		salary +=  salary*raise;

	}
	

	/**
	 * raise the salary by the percentage passed through the parameter and then by 2%
	 * @param raise the raise percentage 
	 */ 
/*	public void raiseSalary(float raise) {

		salary += salary * raise;
		salary += salary * 0.02;
	}
	*/
// Accessors:
/**
 * Get the secretary name of the manager
 * @return the secretary name
 */
	public String getSecretary() {
		return secretary;
	}
/**
 * Set the secretary name of the manager
 * @param sec the secretary name to set
 */
	public void setSecretary(String sec) {
		secretary = sec;
	}

	/**
	 * Get the string representation of the manager
	 * @return the string representation of the employee
	 */
	@Override
	public String toString() {
		return "firstName= " + firstName + ", lastName= " + lastName +
				", hireDate= "+ hireDate + ", salary= " + salary + " secretary= " + secretary;
	}
	

}
