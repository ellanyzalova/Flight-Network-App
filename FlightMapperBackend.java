import java.util.*;
import java.util.Map.Entry;

/**
 * This is the backend implementation of the Flight Mapper project which interfaces
 * between the frontend, algorithm engineer, and data wrangler implementations for the project. It
 * allows shortest and cheapest flight paths to be calculated by the algorithm engineer
 * and returns this information to the frontend developer. 
 * 
 * @author Sarah Gerovac
 *
 */
public class FlightMapperBackend implements IFlightMapperBackend{

        // graph implementation of djikstra's algorithm to keep track of our paths in terms of both shortest
        // path and best cost
    private static AE_Dijkstra<String,Integer> flightMapperCost = new AE_Dijkstra<>();
    private static AE_Dijkstra<String,Integer> flightMapperDistance = new AE_Dijkstra<>();

    
    
     /**
     * Parameterized constructor that creates a FlightMapperBackend object and
     * initializes the Djikstra's graph implementation
     * 
     * @param HashMap of all possible flights and destinations from Data Wrangler's implementation
     */

    public FlightMapperBackend(Map<String, List<Flights>> flight) {
        // if not passed anything then throw exception
        if(flight==null) {
                throw new NoSuchElementException("passed null flights list");
        }
    
        // create an iterator to parse through the data wrangler's hashmap
        Iterator<Entry<String, List<Flights>>> flightsIterator = flight.entrySet().iterator();

        // travel through all values in the passed hashmap to collect all needed values
        while(flightsIterator.hasNext()) {
                // create a hashmap element for values passed in the iterator
                HashMap.Entry<String, List<Flights>> mapElement = (HashMap.Entry)flightsIterator.next();
    
                // add to the djikstra's implementation map all of the flights
                // that have been read in from the data wrangler pertaining to cost and distance
    
                // create variables based on all values received from hash map for each of the items in each Place object
                for(int i=0; i<mapElement.getValue().size(); i++) {
                        String startingCity = mapElement.getKey().toString();
                        String destination = mapElement.getValue().get(i).destinationCity;
                        int cost = mapElement.getValue().get(i).cost;
                        int distance = mapElement.getValue().get(i).distance;
                        if(i==0){        
                        // add element pertaining to cost
                        flightMapperCost.insertVertex(startingCity);
                        flightMapperCost.insertVertex(destination);
                        flightMapperCost.insertEdge(startingCity, destination, cost);
        
                        // add element pertaining to distance
                        flightMapperDistance.insertVertex(startingCity);
                        flightMapperDistance.insertVertex(destination);
                        flightMapperDistance.insertEdge(startingCity, destination, distance);
                        }else{
                        flightMapperCost.insertVertex(destination);
                        flightMapperCost.insertEdge(startingCity,destination,distance);
        
                        flightMapperDistance.insertVertex(destination);
                        flightMapperDistance.insertEdge(startingCity, destination, distance);
                        }    
        }
    
    

        }
  
    }
      
    
    /**
     * Finds the shortest path from the given departure location to the requested destination
     * 
     * @param departure the location the user wants to depart from
     * @param destination the location the user wants to arrive at
     * @return String of the shortest path
     */
        @Override
        public String searchByShortestPath(String departure, String destination) {
                return flightMapperDistance.shortestPathTime(departure, destination).toString();
        }
    
        /**
         * Finds the cheapest path from the given departure location to the requested destination
         * 
         * @param departure the location the user wants to depart from
         * @param destination the location the user wants to arrive at
         * @return String of the cheapest path
         */
        @Override
        public String searchByCheapestCost(String departure, String destination) {
                return flightMapperCost.shortestPathPrice(departure, destination).toString();
        }

}