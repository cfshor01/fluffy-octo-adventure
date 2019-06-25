package assignment_5;

//class inherits from the Ship class
public class CruiseShip extends Ship {
	//instance variable for the maximum number of passengers
	private int max_numPassengers;
	//constructor for the class which passes in parent class parameters as well
	public CruiseShip(String ship_name, int year_built, int max_numPassengers) {
		//uses the super keyword to pass the parameters to the parent constructor
		super(ship_name, year_built);
		//sets the instance variable equal to the max num of passengers passed in
		this.max_numPassengers = max_numPassengers;
	}
	//sets the max number of passengers
	public void setMaxPassengers(int max_numPassengers) {
		this.max_numPassengers = max_numPassengers;
	}
	//returns the value of the max number of passengers
	public int getMaxPassengers() {
		return max_numPassengers;
	}
	//toString method which returns a string with the ship name and max number of passengers
	public String toString() {
		return("Ship Name: " + ship_name + "\nMax Passengers: " + max_numPassengers);
	}

	
	
	
}
