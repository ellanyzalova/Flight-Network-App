import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * This class serves for the frontend framework of the FlightMapper application where the users can interact
 * with the application.
 */
public class FlightMapperFrontend implements IFlightMapperFrontend{

    // declaring private fields.
    private String departure;
    private String arrival;
    private Scanner userInput;
    private IFlightMapperBackend backend;
    
    //constrcutor for Class object.
    public FlightMapperFrontend(Scanner userInput, IFlightMapperBackend backend){
        this.userInput = userInput;
        this.backend = backend;
    }

    /**
     * This method creates the command loop for the frontend, and will end when the user exits
     * the application
     */
    @Override
    public void runCommandLoop() {
        System.out.println("Welcome to the Flight Mapper Application!");
        System.out.println("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x");
        System.out.println();
        displayMainMenu(); //displays the menu for users.

        userInput = new Scanner(System.in); //takes the input from the user after they look at the menu.
        int num = Integer.parseInt(userInput.nextLine()); //the int value of the user's input.
        while(num!=3){
            if(num==1) {
                timeSearch(); //if user inputs 1 - they are looking for the shortest path - takes them to the
                //timeSearch
            }
            else if(num ==2){
                priceSearch(); // if input is 2, the user wants the cheapest flight route.
            }
            else{
                System.out.println("Invalid input, try again!!."); //if the input isn't 1,2,or 3- invalid input.
            }
            displayMainMenu(); //display menu again unless input is 3.
            num = Integer.parseInt(userInput.nextLine());


        }}

    /**
     * Creates the main menu output in the console
     */
    @Override
    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");
        System.out.println("          1) Search by shortest distance");
        System.out.println("          2) Search by cheapest route");
        System.out.println("          3) Exit Application");
    }

    /**
     * Outputs the shortest possible flight path
     */
    @Override
    public void displayFlight(String path) {
        System.out.println(path);

    }


    /**
     * Takes user input and finds the shortest path between the two locations.
     */
    @Override
    public void timeSearch() {
        System.out.println("Enter the departure location: ");
        departure = userInput.nextLine();
        System.out.println("Enter the arrival location: ");
        arrival = userInput.nextLine();
        String path = backend.searchByShortestPath(departure, arrival); //uses the backend's searchByShortestPath 
        //implementation.
        displayFlight(path);
    }

    /**
     *Takes user input and finds the cheapest path between the two locations.
     */
    @Override
    public void priceSearch() {
        System.out.println("Enter the departure location: ");
        departure = userInput.nextLine();
        System.out.println("Enter the arrival location: ");
        arrival = userInput.nextLine();
        String path = backend.searchByCheapestCost(departure, arrival);  //uses the backend's searchByCheapestCost. 
        //implementation.
        displayFlight(path);
    }

}