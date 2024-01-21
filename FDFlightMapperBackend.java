import java.util.ArrayList;
import java.util.List;

public class FDFlightMapperBackend implements  IFlightMapperBackend{
    /**
     * This method returns a list of cities in the path that will comprise the shortest possible
     * path for arriving at a chosen destination from a given departure location
     *
     * @param departure   The departure location user is flying from
     * @param destination The destination location user is flying to
     * @return Returns a path object containing the shortest path to the destination
     */
    @Override
    public String searchByShortestPath(String departure, String destination) {
    return departure + " " + destination;
    }

    /**
     * This method returns a list of cities in the path that will comprise the cheapest possible
     * path for arriving at a chosen destination from a given departure location
     *
     * @param departure   The departure location user is flying from
     * @param destination The destination location user is flying to
     * @return Returns a path object containing the cheapest path to the destination
     */
    @Override
    public String searchByCheapestCost(String departure, String destination) {
            return departure + " " + destination;
        }


}