package Homework2;

public class Car extends Vehicle {
	
	private int number_of_seats;
	private Boolean sedan;
	private Boolean hatchback;
	private Boolean SVU;
	
	// this count will be incremented by 1 every time a new car is initialized 
	//and decremented every time a car is deleted
	private static int  car_count = 0;
	
	/**
	 * Constructor with all attributes of car
	 * @param bn brand name of the car
	 * @param dm date of make of the car
	 * @param c color of the car
	 * @param nos number of seats of the car
	 * @param sed if the car is sedan
	 * @param hat if the car is hatchback
	 * @param svu if the car is svu
	 */
	public Car(String bn, String dm, String c, int nos, Boolean sed, Boolean hat, Boolean svu) {
		brand_name = bn;
		date_of_make = dm;
		color = c;
		number_of_seats = nos;
		sedan = sed;
		hatchback = hat;
		SVU = svu;
	}
	
	/**
	 * get the number of seats of the car
	 * @return number_of_seats
	 */
	public int getNumberOfSeats() {
		return number_of_seats;
		
	}
	
	/**
	 * set the number of seats of the car
	 * @param nos the number of seats to be set
	 */
	public void setNumberOfSeats(int nos) {
		number_of_seats = nos;
	}
	
	/**
	 * get if the car is sedan or not
	 * @return True if the car is sedan and false if not
	 */
	public Boolean getIfSedan() {
		return sedan;
	}
	
	/**
	 * set if the car is sedan or not
	 * @param sed true if the car is sedan and false elsewhere 
	 */
	public void setIfSedan(Boolean sed) {
		sedan = sed;
		
	}

	/**
	 * get if the car is hatchback or not
	 * @return true if the car is hatchback and false elsewhere
	 */
	public Boolean getIfHatchback() {
		return hatchback;
	}
	
	/**
	 * set if the car is hatchback or not
	 * @param hat true if the car is hatchback and false if not
	 */
	public void setIfHatchback(Boolean hat) {
		hatchback = hat;
	}
	
	/**
	 * get if the car is SVU or not
	 * @return true if the car is SVU and false if not
	 */
	public Boolean getIfSVU(){
		return SVU;
	}
	
	/**
	 * set if the car is SVU or not
	 * @param svu true if the car is SVU and false if not
	 */
	public void setIfSVU(Boolean svu) {
		SVU = svu;
	}

	/**
	 * get the number of cars
	 * @return car_count
	 */
	public static int getCarCount() {
		return car_count;
	}
	
	/**
	 * increment by one the value of the car_count
	 */
	public static void incrementCarCount() {
		car_count ++ ;
	}
	
	/**
	 * decrement by one the value of car_count
	 */
	public static void decrementCarCount() {
		car_count --;
	}
	
	@Override
	/**
	 * return all attribute of the car
	 */
	public String toString() {
		return "Brand name: " + brand_name +
				" Date of make: "+ date_of_make +
				" Color: "+ color +
				" Sedan: "+ sedan +
				" Htachback: "+ hatchback+
				" SVU: " + SVU+
				" Car.";
		
	}
	
}
