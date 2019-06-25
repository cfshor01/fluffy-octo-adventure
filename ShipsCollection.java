package assignment_5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class ShipsCollection {

	public static void main(String[] args) {
		//local variables to initialize values
		boolean menu = true;
		int user_choice = 0;
		int ship_number = 0;
		int ship_choice;
		String ship_name;
		int year_built = 0;
		int max_cap = 0;
		int tonnage = 0;
		//Scanner object to receive user input
		Scanner scan = new Scanner(System.in);
		//creates an array of ship objects
		Ship[] ship = new Ship[10];
		//creates an array list of ship objects
		ArrayList <Ship> list = new ArrayList<Ship>();
		
		//sets the menu value to true for continued display
		while(menu == true) {
			//creates the interface of the menu
			System.out.println("\nShips");
			System.out.println("1. Add Ship");
			System.out.println("2. View Ships");
			System.out.print("Selection: ");
			user_choice = scan.nextInt();
			//uses switch-case to perform program functionality based upon user response
			switch(user_choice) {
			case 1:
				//asks user for type of ship to record
				System.out.println("1. Cruise Ship");
				System.out.println("2. Cargo Ship");
				System.out.print("Selection: ");
				ship_choice = scan.nextInt();
				if(ship_choice == 1) {
					//makes sure that ship number is less or equal than allocated amount
					if(ship_number < 10) {
						System.out.println("What's the ship's name: ");
						scan.nextLine();
						ship_name = scan.nextLine();
						System.out.println("What year was it built: ");
						year_built = scan.nextInt();
						System.out.println("What's the max capacity: ");
						max_cap = scan.nextInt();
						//sets ship object to new CruiseShip object
						ship[ship_number] = new CruiseShip(ship_name, year_built, max_cap);
						//adds ship object to arrayList
						list.add(ship[ship_number]);
						ship_number = ship_number + 1;
					}
					else {
						System.out.println("Out of space!");
					}
				}
				if(ship_choice == 2) {
					//makes sure that the number of ships is less or equal to allocated amount
					if(ship_number < 10) {
						System.out.println("What's the ship's name: ");
						scan.nextLine();
						ship_name = scan.nextLine();
						System.out.println("What year was it built: ");
						year_built = scan.nextInt();
						System.out.println("What's the max tonnage: ");
						tonnage = scan.nextInt();
						//sets ship object to a new Cargo Ship
						ship[ship_number] = new CargoShip(ship_name, year_built, tonnage);
						//adds ship to array list
						list.add(ship[ship_number]);
						ship_number = ship_number + 1;
					}
					else {
						//displays when more than ten ships have been made
						System.out.println("Out of space!");
					}
				}
				
				break;
			case 2:
				//uses the imported Collections class to sort the arrayList
				Collections.sort(list);
				//prints out the list of ships in the arrayList in alphabetic order
				for(Ship s : list) {
						System.out.println(s);
				}
				
				break;

			}
		}
	}

}
