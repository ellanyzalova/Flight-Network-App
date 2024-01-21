import java.util.List;

public interface IFlightMapperFrontend {

    /**
     * This method creates the command loop for the frontend, and will end when the user exits
     * the application
     */
    public void runCommandLoop();

    /**
     * Creates the main menu output in the console
     */
    public void displayMainMenu();

    /**
     * Outputs the shortest possible flight path
     */
    public void displayFlight(String path);

    /**
     * Method used to output the shortest time path
     */
    public void timeSearch();

    /**
     * Method used to output the cheapest flight path
     */
    public void priceSearch();

}