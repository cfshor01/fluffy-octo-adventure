package assignment_5;

//ship class implements the Comparable interface
public class Ship implements Comparable<Ship> {
	//instance variables for the ship name and year built
	protected String ship_name;
	protected int year_built;
	//constructor to initialize the values
	public Ship (String ship_name, int year_built) {
		this.ship_name = ship_name;
		this.year_built = year_built;
	}
	//sets the ship name
	public void setShipName(String ship_name) {
		this.ship_name = ship_name;
	}
	//sets the year the ship was built
	public void setYearBuilt(int year_built) {
		this.year_built = year_built;
	}
	//returns the the ship name
	public String getShipName() {
		return ship_name;
	}
	//returns the year the ship was built
	public int getYearBuilt() {
		return year_built;
	}
	//toString method which returns the ship name along with the year it was built
	public String toString() {
		return("Ship Name: " + ship_name + "\n Year Built: " + year_built);
	}
	//commpareTo method which compares the values of different ship names
	public int compareTo(Ship ship) {
		int nameD = ship_name.compareToIgnoreCase(ship.getShipName());
		if(nameD != 0) {
			return nameD;
		}
		else return 0;
	}

}
