/*
 * Author Name: Rebecca Yazbeck
 * ID: 202201494
 * Last Modified: 2/11/2023
 * Description: Program that manages vehicles in a shop
 * -------------------------------------------------------------------------
 * Files:
 * 		Vehicle.java
 * 		Car.java
 * 		Truck.java
 * 		Motorcycle.java
 */ 
package Homework2;
import java.util.Scanner;
import java.util.Vector;

 
/**
 *  Parent class of Car Truck and Motorcycle
 */
public abstract class Vehicle {
	protected String brand_name;
	protected String date_of_make;
	protected String color;

/**
 * get the brand name of the vehicle
 * @return brand_name
 */
	public String getBrandName() {
		return brand_name;
	}


/**
 * set the brand name of the vehicle
 * @param bn the brand name to be set
 */
	public void setBrandName(String bn) {
		brand_name = bn;
	}


/**
 * get the date of make of the vehicle
 * @return date_of_make of the vehicle
 */
	public String getDateOfMake() {
		return date_of_make;
	}


/**
 * set the date of make of the vehicle
 * @param dm date of make to be set
 */
	public void setDate_of_make(String dm) {
		date_of_make = dm;
	}


/**
 * get the color of the vehicle
 * @return color of the vehicle
 */
	public String getColor() {
		return color;
	}

/**
 * set the color of the vehicle
 * @param c the color to be set
 */
	public void setColor(String c) {
		color = c;
	}

	static Scanner scan = new Scanner(System.in);
	static Vector <Vehicle> vehicle = new Vector <Vehicle>();
	
	
	/**
	 * display the menu and ask for the user's choice
	 */
	public static void displayMenu() {
		System.out.println("1.Add a vehicle");
		System.out.println("2.Delete a vehicle");
		System.out.println("3.Display type");
		System.out.println("4.List all");
		System.out.println("5.Exit");
		System.out.println("----------------------");
		System.out.println("Enter your choice:");

	}

	/**
	 * ask the user for the type of the vehicle
	 * @return the choice of the user
	 */
	public static int Type(){
		int choice;	// the choice of the user
		int count = 0; // the number of invalid choices 
		
		do {
			System.out.println("what type is your vehicle");
			System.out.println("1-Car");
			System.out.println("2-Truck");
			System.out.println("3-Motorcycle");
			choice = scan.nextInt();
			switch(choice) {
				case 1:
					System.out.println("your vehicle is a car");
					break;
				case 2: 
					System.out.println("your vehicle is a truck");
					break;
				case 3:
					System.out.println("your vehicle is a motorcycle");
					break;
				default:
					System.out.println("Invalid choice");
					count ++;
					// increment count each time an invalid choice is entered
			}
			
		} while (choice != 1 && choice != 2 && choice != 3 && count != 3);

			
		return choice;
	}
	
	/**
	 * add a new vehicle to the vector "vehicle"
	 */
	public static void AddVehicle() {
		int choice = Type();
		System.out.println("Enter the brand name: ");
		// brand name of the vehicle
		String bn = scan.nextLine();
		System.out.println("Enter the date of make: ");
		// date of make of the vehicle 
		String dm = scan.nextLine();
		System.out.println("Enter the color: ");
		String c = scan.nextLine();
		
		// the color of the vehicle
		
		
		if (choice == 1) {
			// the vehicle is a car
			System.out.println("Enter the number of seats: ");
			int nums = scan.nextInt();
			System.out.println("Enter \n1 if the car is sedan\n2 if the car is hatchaback\n3 if the car is SVU ");
			int choicee = scan.nextInt();
			Boolean sed;
			Boolean hat;
			Boolean svu;
			switch (choicee) {
			// the car can either have one of those characteristics
				case 1:
					 sed = true;
					 hat = false;
					 svu = false;
					break;
				case 2:
					 sed = false;
					 hat = true;
					 svu = false;
					break;
				case 3:
					 sed = false;
					 hat = false;
					 svu = true;
				
				default:
					 sed = false;
					 hat = false;
					 svu = false;
			}
		Car car = new Car(bn, dm, c, nums, sed, hat, svu);
		// create the car and add it to vehicle the vector
		vehicle.addElement(car);
		// increment the count of cars number
		Car.incrementCarCount();
		System.out.println("Vehicle successfully added");
		}
		
		else if (choice == 2) {
			// the vehicle is a truck
			System.out.println("Enter the number of wheels");
			int numw = scan.nextInt();
			
			Truck truck = new Truck (bn , dm, c, numw);
			// create the truck and add it to the vehicle vector
			vehicle.addElement(truck);	
			// increment the count of truck number
			Truck.incrementTruckCount();
			System.out.println("Vehicle successfully added");
		}
		
		else if (choice == 3) {
			// the vehicle is a motorcycle
			
			System.out.println("The engine capacity should be between 70 and 120");
			System.out.println("Enter the engine capacity: ");
			float temp_ec = scan.nextFloat();
			float ec;
			if (temp_ec < 70 ) {
				// the minimum value should be 70 
				// by default each value less than 70 will be set to 70
				ec = 70;
			}
			else if (temp_ec > 120) {
				// the maximum value should be 120
				// by default each value more than 120 will be set to 120
				ec = 120;
			}
			else {
				// each value between 70 & 120 will be assigned as it is
				ec= temp_ec;
			}
			Motorcycle moto = new Motorcycle(bn, dm, c, ec);
			// create the motorcycle and add it to the vehicle vector
			vehicle.addElement(moto);
			// increment the count of motorcycle number
			Motorcycle.incrementMotorcycleCount();
			System.out.println("Vehicle successfully added");
		}
		
		else {
			System.out.println("NO VALID TYPE WAS CHOOSEN");
		}
	}
	
	/**
	 * delete an element from the vector vehicle 
	 */
	public static void DeleteVehicle() {
		int choice = Type();
		switch(choice) {
			case 1:
				// the vehicle is a car
				int count = 0;
				// count is used to number the list
				for (int i = 0; i < vehicle.size(); i++) {
					//loop over the vector
					// check if the object in an instance of Car
					// print all the characteristics of the object
					if (vehicle.elementAt(i) instanceof Car) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString() + " index=" + i);
					}
				}
				System.out.println("Enter the index of the element you want to remove: ");
				int index = scan.nextInt();
				// removed will take the value true if the element was removed
				Boolean removed = vehicle.remove(vehicle.elementAt(index));
				if (removed == true) {
					System.out.println("The element has been successfully removed");
					// decrement the number of cars 
					Car.decrementCarCount();
				}
				else {
					System.out.print("Operation failed");
				}
				
			    break;
			case 2:
				// the vehicle is a truck
				count = 0;
				for (int i = 0; i < vehicle.size(); i++) {
					//loop over the vector
					// check if the object in an instance of Truck
					// print all the characteristics of the object
					if (vehicle.elementAt(i) instanceof Truck) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString()+ " index=" + i);
					}
				}
				System.out.println("Enter the index of the element you want to remove: ");
				index = scan.nextInt();
				// removed will take the value true if the element was removed
				removed = vehicle.remove(vehicle.elementAt(index));
				if (removed == true) {
					System.out.println("The element has been successfully removed");
					// decrement the number of trucks
					Truck.decrementTruckCount();
				}
				else {
					System.out.print("Operation failed");
				}
				
			    break;
			    
			case 3:
				// the vehicle is a Motorcycle
				count = 0;
				for (int i = 0; i < vehicle.size(); i++) {
					//loop over the vector
					// check if the object in an instance of Motorcycle
					// print all the characteristics of the object
					if (vehicle.elementAt(i) instanceof Motorcycle) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString()+ " index=" + i);
					}
				}
				System.out.println("Enter the index of the element you want to remove: ");
				index = scan.nextInt();
				// removed will take the value true if the element was removed
				removed = vehicle.remove(vehicle.elementAt(index));
				if (removed == true) {
					System.out.println("The element has been successfully removed");
					//decrement the number of Motorcycle
					Motorcycle.decrementMotorcycleCount();
				}
				else {
					System.out.print("Operation failed");
				}
				
			    break;
			    
		  default:
			  System.out.println("no valid type entered");
		}
		
    }
	
	/**
	 * list all the element of a specific type and their characteristics
	 */
	public static void DisplayType() {
		int choice = Type();
		switch(choice) {
			case 1:
				// the vehicle is a car
				int count = 0;
				for (int i = 0; i < vehicle.size(); i++) {
					if (vehicle.elementAt(i) instanceof Car) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString());
					}
				}
				System.out.println("Total number of cars: "+ Car.getCarCount());

				
			    break;
			case 2:
				// the vehicle is a truck
				count = 0;
				for (int i = 0; i < vehicle.size(); i++) {
					if (vehicle.elementAt(i) instanceof Truck) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString());
					}
				}
				
				System.out.println("Total number of trucks: "+ Truck.getTruckCount());
				
			    break;
			    
			case 3:
				// the vehicle is a Motorcycle
				count = 0;
				for (int i = 0; i < vehicle.size(); i++) {
					if (vehicle.elementAt(i) instanceof Motorcycle) {
						count++;
						System.out.println(count +" "+ vehicle.elementAt(i).toString());
					}
				}
				System.out.println("Total number of Motorcycle: "+ Motorcycle.getMotorcycleCount());
			    break;
			    
		  default:
			  System.out.println("no valid type entered");
		}
		
    }
	
	/**
	 * list all the element in the vector vehicle and their characteristics
	 */
	public static void ListAll() {
		int count = 0;
		for (int i = 0; i < vehicle.size(); i++) {
			count++;
			System.out.println(count +" "+ vehicle.elementAt(i).toString());
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int choice;
		int count = 0;
	
		do { displayMenu();
			choice = scan.nextInt();
			switch (choice) {
				case 1:
					//add vehicle 
					AddVehicle();
					count = 0 ;
					break;
					
				case 2:
					//Delete a vehicle
					DeleteVehicle();
					count = 0 ;
					break;
					
				case 3:
					//Display type
					DisplayType();
					count = 0 ;
					break;
					
				case 4:
					//list all
					ListAll();
					count = 0 ;
					break;
					
				default:
					// increment count by 1:
					count++;
					if (count<5 && choice!=5) {
						System.out.println("Enter a valid option");
					}
					break;
					
			}
			
		} while (choice != 5 && count != 5);
		System.out.println("Program successfully closed");
		scan.close();
	}

}
