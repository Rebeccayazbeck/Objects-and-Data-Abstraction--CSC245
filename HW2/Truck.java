package Homework2;

public class Truck extends Vehicle {
	
	private int number_of_wheels;
	
	// this count will be incremented by 1 every time a new truck is initialized 
	//and decremented every time a Truck is deleted
	private static int  truck_count = 0;
	
	/**
	 * constructor with all Truck attributes
	 * @param bn brand name of the Truck
	 * @param dm date of make of the Truck
	 * @param c color of the Truck
	 * @param numw number of wheels of the Truck
	 */
	public Truck(String bn,String dm, String c, int numw) {
		brand_name = bn;
		date_of_make = dm;
		color = c;
		number_of_wheels = numw;
		
	}
	
	/**
	 * get the number of wheels of the truck
	 * @return number_of_wheels of the truck
	 */
	public int getNumberOfWheels() {
		return number_of_wheels;
		}
	
	/**
	 * set the number of wheels of the Truck
	 * @param numw the number of wheels to be set
	 */
	public void setNumberOfWheels(int numw) {
		number_of_wheels = numw;		
	}
	
	/**
	 * get the number of truck 
	 * @return truck_count
	 */
	public static int getTruckCount() {
		return truck_count;
	}
	
	/**
	 * increment by one the value of the truck_count
	 */
	public static void incrementTruckCount() {
		truck_count ++ ;
	}
	/**
	 * decrement by one the value of truck_count
	 */
	public static void decrementTruckCount() {
		truck_count --;
	}
	
	@Override 
	/**
	 * return all attribute of the Truck
	 */
	public String toString() {
		return "Brand name: " + brand_name +
				" Date of make: "+ date_of_make +
				" Color: "+ color +
				" Number of wheels: "+ number_of_wheels +
				" Truck.";
	}

}
