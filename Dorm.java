package assignment_5;

//imported javafx packages for program functionality
import javafx.application.Application;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dorm extends Application {

	//Text object to display the final result
	private Text result = new Text();
	//instance variables created for the dorm name and meal plan
	private String dormName;
	private String meal;
	private int dormCost = 0;
	private int mealCost = 0;
	//NumberFormat object created to set information to currenct format
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	//Two ChoiceBoxes for choosing meal plan and room choice
	ChoiceBox<String> roomChoice;
	ChoiceBox<String> mealChoice;

	//launches the program
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		//Gridpane object used to set the style and organize the nodes of the program
		GridPane grid = new GridPane();
		//uses gridpane functionality for appearance editing
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(15);
		grid.setHgap(15);
		//creates the choice boxes
		roomChoice = new ChoiceBox<String>();
		mealChoice = new ChoiceBox<String>();
		//button used which will perform a function upon event
		Button button1 = new Button("Calculate Costs");
		//String array which holds the dorm names
		String[] dormName = new String[5];
		dormName[1] = new String("Allen Hall");
		dormName[2] = new String("Smith Hall");
		dormName[3] = new String("William Hall" );
		dormName[4] = new String("University Suites");
		dormName[0] = new String("None");
		//String array which holds the meal plans
		String[] mealPlan = new String[4];
		mealPlan[1] = new String("7 Meals Per Week");
		mealPlan[2] = new String("14 Meals Per Week");
		mealPlan[3] = new String("Unlimited Meals");
		mealPlan[0] = new String("None");

		//Creates new labels asking for user input
		Label roomLabel = new Label("Select a Room Plan:");
		Label mealLabel = new Label("Select a Meal Plan:");

		//adds the dormName String object to the roomChoice ChoiceBox
		roomChoice.getItems().addAll(dormName);
		//sets the action that will be processed when choice is selected
		roomChoice.setOnAction(this::processRoomChoice);
		//sets the default choice to the first in the dormName array
		roomChoice.getSelectionModel().select(0);

		//adds the mealPlan String object to the MealChoice ChoiceBox
		mealChoice.getItems().addAll(mealPlan);
		//sets the action that will be processed when choice is selected
		mealChoice.setOnAction(this::processMealChoice);
		//sets the default choice to the first in the mealPlan array
		mealChoice.getSelectionModel().select(0);

		//sets the positioning of all of the nodes of the function
		grid.setConstraints(roomLabel, 0, 0);
		grid.setConstraints(mealLabel, 1, 0);
		grid.setConstraints(roomChoice, 0, 1);
		grid.setConstraints(mealChoice, 1, 1);
		grid.setConstraints(button1, 0, 2);
		grid.setConstraints(result, 1, 2);
		//adds all of the nodes to the grid
		grid.getChildren().addAll(roomLabel, mealLabel, roomChoice, mealChoice, button1, result);
		//sets the action that will be called upon the event of pressing the button
		button1.setOnAction(this::processButtonPush);
		//sets the scene by passing in the grid and dimensions
		Scene scene = new Scene(grid, 300, 150);
		//passes scene into the stage
		primaryStage.setScene(scene);
		//shows the stage
		primaryStage.show();

	}

	//method that sets the dormName equal to the value of roomChoice
	public void processRoomChoice(ActionEvent event) {
		this.dormName = roomChoice.getValue();
	}
	//method that sets the meal plan equal to the value of mealChoice
	public void processMealChoice(ActionEvent event) {
		this.meal = mealChoice.getValue();
	}
	//method that sets the result and is called upon once the button is pushed
	public void processButtonPush(ActionEvent event) {
		int dcost = getDormPrices();
		int mcost = getMealPrices();
		//sets text equal to sum of meal and dorm cost and returns in currency format
		result.setText("Total Cost is: " + fmt.format(dcost + mcost));
	}
	//method that returns the dorm cost
	public int getDormPrices() {
		if(dormName.equals("Allen Hall")) {
			dormCost = 1800;
		}
		else if(dormName.equals("Smith Hall")) {
			dormCost = 2000;
		}
		else if(dormName.equals("William Hall")) {
			dormCost = 2800;
		}
		else if (dormName.equals("University Suites")) {
			dormCost = 3000;
		}
		else if(dormName.equals("None")) {
			dormCost = 0;
		}
		return dormCost;
	}
	//method that returns the meal cost
	public int getMealPrices() {
		if(meal.equals("7 Meals Per Week")) {
			mealCost = 600; 
		}
		else if (meal.equals("14 Meals Per Week")) {
			mealCost = 1000;
		}
		else if (meal.equals("Unlimited Meals")) {
			mealCost = 1800;
		}
		else if (meal.equals("None")) {
			mealCost = 0;
		}
		return mealCost;
	}

}
