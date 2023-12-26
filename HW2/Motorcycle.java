package Homework2;

public class Motorcycle extends Vehicle {
	
	private float engine_capacity;
	
	// this count will be incremented by 1 every time a new motorcycle is initialized 
	//and decremented every time a Motorcycle is deleted
	private static int  motorcycle_count = 0;
	
	/**
	 * Constructor with all Motorcycle attributes
	 * @param bn brand name of the motorcycle
	 * @param dm date of make of the motorcycle
	 * @param c color of the motorcycle
	 * @param ec engine capacity of the motorcycle (vary between 70 and 120 ml)
	 */
	public Motorcycle (String bn, String dm, String c,float ec) {
		brand_name = bn;
		date_of_make = dm;
		color = c;
		engine_capacity = ec;
	}
	
	/**
	 * get the engine capacity of the motorcycle
	 * @return the engine_capacity
	 */
	public float getEngineCapacity() {
		return engine_capacity;
	}
	
	/**
	 * set the engine capacity of the motorcycle 
	 * @param ec the engine capacity to be set
	 */
	public void setEngineCpacity(float ec) {
		engine_capacity = ec;

	}
	
	/**
	 * get the number of motorcycle 
	 * @return motorcycle_count
	 */
	public static int getMotorcycleCount() {
		return motorcycle_count;
	}
	
	/**
	 * increment by one the value of motorcycle_count
	 */
	public static void incrementMotorcycleCount() {
		motorcycle_count ++ ;
	}
	
	/**
	 * decrement by one the value of motorcycle_count
	 */
	public static void decrementMotorcycleCount() {
		motorcycle_count --;
	}
	
	@Override
	/**
	 * return all attribute of the motorcycle
	 */
	public String toString() {
		return "Brand name: " + brand_name +
				" Date of make: "+ date_of_make +
				" Color: "+ color +
				" Engine Capacity "+ engine_capacity +
				" Motorcycle.";
	}
}
