package assignment_5;

//class inherits from the Ship class
public class CargoShip extends Ship {
	//sets instance variable for tonnage
	private int tonnage;
	
	//constructor for cargo ship which passes in parameters for the parent class as well
	public CargoShip(String ship_name, int year_built, int tonnage) {
		//uses the super keyword to pass in the parameters into the parent constructor
		super(ship_name, year_built);
		//sets the instance variable equal to the tonnage passed in
		this.tonnage = tonnage;
	}
	//sets tonnage value
	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}
	//returns tonnage value
	public int getTonnage() {
		return tonnage;
	}
	//toString method to return information of the the ship name and its tonnage
	public String toString() {
		return("Ship Name: " + ship_name + "\nTonnage: " + tonnage);
	}
}
