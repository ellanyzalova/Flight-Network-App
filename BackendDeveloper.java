import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

/**
 * This class contains JUnitTesters for the methods defined in the
 * FlightMapperBackend class
 * 
 * @author Sarah Gerovac
 */
class BackendDeveloperTests {
        private List<Flights> flights;
        private AE_Dijkstra<String, Integer> costGraph;
        private AE_Dijkstra<String, Integer> timeGraph;

        /**
     * JUnitTest to test if the FlightMapperBackend constructor works and initialzes
     * an implementation of djikstra's algorithm
     */
        @Test
        void testConstructor() {
                try {
                FlightMapperBackend backend = new FlightMapperBackend(null);
                fail("didn't throw exception");
                }catch(NoSuchElementException e) {
                        // should throw a no such element if trying to create backend object with null argument
                }
                try {
                        Map<String, List<Flights>> flights2 = new HashMap<>();
                        List<Flights> flights = new ArrayList<Flights>();
                        Flights place2 = new Flights("Chicago","DC",8,20);
                        flights.add(place2);
                        flights2.put("Chicago", flights);

                        FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
                        // check that the backend was able to create objects with given parameters passed
                        assertEquals(1,1);
                }catch(NoSuchElementException e) {
                        fail("threw wrong exception");
                }
        }

        /**
     * JUnitTest to test if the searchByShortestPath method in the FlightMapperBackend class
     * works with a possible direct flight between a departure location and destination 
     */
    @Test
    public void testSearchByShortestPath1() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                List<Flights> flights2 = new ArrayList<Flights>();
                flights2.add(place);
                flights2.add(place2);
                flights.put("Madison", flights2);
                flights.put("Chicago", flights2);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
                // checking that the shortest path for a direct flight correctly returns the right list of cities
                assertEquals(backend.searchByShortestPath("Madison", "Chicago"), "[Madison, Chicago]");

        // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights4 = new HashMap<>();
                Flights place3 = new Flights("Minneapolis","JFK",200,11);
                Flights place4 = new Flights("JFK","Boston",679,54);
                List<Flights> flights5 = new ArrayList<Flights>();
                flights5.add(place3);
                flights5.add(place4);
                flights4.put("Minneapolis", flights5);
                flights4.put("JFK", flights5);
                FlightMapperBackend backend2 = new FlightMapperBackend(flights4);
                // checking that the shortest path for a direct flight correctly returns the right list of cities
                assertEquals(backend2.searchByShortestPath("JFK", "Boston"), "[JFK, Boston]");
    }
    /**
     * JUnitTest to test if the searchByCheapestPath method in the FlightMapperBackend class
     * works with a possible direct flight between a departure location and destination
     */
    @Test
    public void testSearchByCheapPath1() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                List<Flights> flights5 = new ArrayList<Flights>();
                flights5.add(place2);
                flights5.add(place);
                flights.put("Madison", flights5);
                flights.put("Chicago", flights5);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
                // checking that the cheapest path for a direct flight correctly returns the right list of cities
                assertEquals(backend.searchByCheapestCost("Madison", "Chicago"), "[Madison, Chicago]");

        // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights2 = new HashMap<>();
                Flights place3 = new Flights("Minneapolis","JFK",200,11);
                Flights place4 = new Flights("JFK","Boston",679,54);
                List<Flights> flights6 = new ArrayList<Flights>();
                flights6.add(place4);
                flights6.add(place3);
                flights2.put("Minneapolis", flights6);
                flights2.put("JFK", flights6);
                FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
                // checking that the cheapest path for a direct flight correctly returns the right list of cities
                assertEquals(backend2.searchByCheapestCost("JFK", "Boston"), "[JFK, Boston]");
        
    }


    /**
     * JUnitTest to test if the searchByShortestPath method in the FlightMapperBackend class
     * works with no possible direct flights between a departure location and destination 
     */
    @Test
    public void testSearchByShortestPath2() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                Flights place3 = new Flights("DC","Oregon",18,30);
                List<Flights> flights6 = new ArrayList<Flights>();
                List<Flights> flights8 = new ArrayList<Flights>();
                List<Flights> flights9 = new ArrayList<Flights>();
                flights6.add(place);
                flights8.add(place2);
                flights9.add(place3);
                flights.put("Madison", flights6);
        flights.put("Chicago", flights8);
        flights.put("DC", flights9);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
        // checking that the shortest path for indirect flights correctly returns the right list of cities
        assertEquals(backend.searchByShortestPath("Madison", "DC"), "[Madison, DC]");
        assertEquals(backend.searchByShortestPath("Chicago", "Oregon"), "[Chicago, DC, Oregon]");
        assertEquals(backend.searchByShortestPath("Madison", "Oregon"), "[Madison, DC, Oregon]");
    
        // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights2 = new HashMap<>();
        Flights place5 = new Flights("Minneapolis","JFK",200,11);
        Flights place4 = new Flights("JFK","Boston",679,54);
        Flights place6 = new Flights("Boston","New England",20,30);
                List<Flights> flights7 = new ArrayList<Flights>();
                List<Flights> flights10 = new ArrayList<Flights>();
                List<Flights> flights11 = new ArrayList<Flights>();
        flights7.add(place4);
        flights10.add(place5);
        flights11.add(place6);
                flights2.put("Minneapolis", flights7);
        flights2.put("JFK", flights10);
        flights2.put("Boston", flights11);
        FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
        // checking that the shortest path for indirect flights correctly returns the right list of cities
        assertEquals(backend2.searchByShortestPath("Minneapolis", "Boston"), "[Minneapolis, Boston]");
        assertEquals(backend2.searchByShortestPath("Minneapolis", "New England"), "[Minneapolis, Boston, New England]");
        assertEquals(backend2.searchByShortestPath("JFK", "New England"), "[JFK, Boston, New England]");
   
        
    }
/**
     * JUnitTest to test if the searchByCheapestPath method in the FlightMapperBackend class
     * works with no possible direct flights between a departure location and destination
     */
    @Test
    public void testSearchByCheapPath2() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                Flights place3 = new Flights("DC","Oregon",18,30);
                List<Flights> flights7 = new ArrayList<Flights>();
                List<Flights> flights8 = new ArrayList<Flights>();
                List<Flights> flights9 = new ArrayList<Flights>();
                flights7.add(place);
                flights8.add(place2);
                flights9.add(place3);
                flights.put("Madison", flights7);
                flights.put("Chicago", flights8);
        flights.put("DC", flights9);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
                // checking that the cheapest path for indirect flights correctly returns the right list of cities
                System.out.println(backend.searchByCheapestCost("Madison", "DC"));
        assertEquals(backend.searchByCheapestCost("Madison", "DC"), "[Madison, DC]");
        assertEquals(backend.searchByCheapestCost("Chicago", "Oregon"), "[Chicago, DC, Oregon]");
        assertEquals(backend.searchByCheapestCost("Madison", "Oregon"), "[Madison, DC, Oregon]");

        // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                Map<String, List<Flights>> flights2 = new HashMap<>();
                Flights place5 = new Flights("Minneapolis","JFK",200,11);
                Flights place4 = new Flights("JFK","Boston",679,54);
                Flights place6 = new Flights("Boston","New England",20,30);
                Flights place7 = new Flights("Boston","New Hamp",20,30);
                List<Flights> flights10 = new ArrayList<Flights>();
                List<Flights> flights11 = new ArrayList<Flights>();
                List<Flights> flights12 = new ArrayList<Flights>();
                flights10.add(place5);
                flights11.add(place4);
                flights12.add(place6);
                flights12.add(place7);
                flights2.put("Minneapolis", flights10);
                flights2.put("JFK", flights11);
        flights2.put("Boston", flights12);
                FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
                // checking that the cheapest path for indirect flights correctly returns the right list of cities
        assertEquals(backend2.searchByCheapestCost("Minneapolis", "Boston"), "[Minneapolis, Boston]");
        assertEquals(backend2.searchByCheapestCost("Minneapolis", "New England"), "[Minneapolis, Boston, New England]");
        assertEquals(backend2.searchByCheapestCost("JFK", "New England"), "[JFK, Boston, New England]");

        
    }
    
    /** 
     * JUnitTest to do a code review of the Algorithm Engineer (by the BackendDeveloper) and ensure
     * that the shortest path price method works as expected(this is one of the two main methods we utilize
     * in the project)
     */

    @Test
    public void CodeReviewOfAlgorithmEngineer1() {
        
        costGraph = new AE_Dijkstra<>();
        // inserting cities
        costGraph.insertVertex("Madison");
        costGraph.insertVertex("Chicago");
        costGraph.insertVertex("London");
        costGraph.insertVertex("Singapore");
        costGraph.insertVertex("New York");
        costGraph.insertVertex("Dubai");
        costGraph.insertVertex("Reykjavik");
        // inserting costs to fly between cities
        costGraph.insertEdge("Madison", "Chicago", 25);
        costGraph.insertEdge("Chicago", "Madison", 35);
        costGraph.insertEdge("London", "Chicago", 70);
        costGraph.insertEdge("Chicago", "New York", 45);
        costGraph.insertEdge("New York", "Madison", 115);
        costGraph.insertEdge("New York", "Singapore", 100);
        costGraph.insertEdge("Chicago", "Singapore", 120);
        costGraph.insertEdge("Singapore", "London", 90);
        costGraph.insertEdge("London", "Reykjavik", 45);
        costGraph.insertEdge("Reykjavik", "Dubai", 50);
        costGraph.insertEdge("New York", "London", 55);
        costGraph.insertEdge("London", "New York", 60);
        costGraph.insertEdge("New York", "Reykjavik", 75);
        costGraph.insertEdge("Dubai", "New York", 80);
        // initialize a graph where the vertexes are cities and the edges are the time
        // to fly between cities in minutes
        timeGraph = new AE_Dijkstra<>();
        // inserting cities
        timeGraph.insertVertex("Madison");
        timeGraph.insertVertex("Chicago");
        timeGraph.insertVertex("London");
        timeGraph.insertVertex("Singapore");
        timeGraph.insertVertex("New York");
        timeGraph.insertVertex("Dubai");
        timeGraph.insertVertex("Reykjavik");
        // inserting time to fly between cities
        timeGraph.insertEdge("Madison", "Chicago", 70);
        timeGraph.insertEdge("Chicago", "Madison", 55);
        timeGraph.insertEdge("London", "Chicago", 530);
        timeGraph.insertEdge("Chicago", "New York", 130);
        timeGraph.insertEdge("New York", "Madison", 165);
        timeGraph.insertEdge("New York", "Singapore", 1100);
        timeGraph.insertEdge("Chicago", "Singapore", 1290);
        timeGraph.insertEdge("Singapore", "London", 840);
        timeGraph.insertEdge("London", "Reykjavik", 195);
        timeGraph.insertEdge("Reykjavik", "Dubai", 660);
        timeGraph.insertEdge("New York", "London", 420);
        timeGraph.insertEdge("London", "New York", 490);
        timeGraph.insertEdge("New York", "Reykjavik", 340);
        timeGraph.insertEdge("Dubai", "New York", 870);
        
        // testing cheapest path between Singapore and Madison, should go through london
        // and chicago
        assertTrue(costGraph.shortestPathPrice("Singapore", "Madison").toString()
                .equals("[Singapore, London, Chicago, Madison]"));

        // testing cheapest path between Reykjavik and Singapore, should go through
        // dubai and new york
        assertTrue(costGraph.shortestPathPrice("Reykjavik", "Singapore").toString()
                .equals("[Reykjavik, Dubai, New York, Singapore]"));

        // testing cheapest path between Dubai and Chicago, should go through london and
        // new york
        assertTrue(costGraph.shortestPathPrice("Dubai", "Chicago").toString()
                .equals("[Dubai, New York, London, Chicago]"));
    }
  
/** 
     * JUnitTest to do a code review of the Algorithm Engineer (by the BackendDeveloper) and ensure
     * that the shortest path price method works as expected (this is the other main method we utilize in this
     * project)
     */

    @Test
    public void CodeReviewOfAlgorithmEngineer2() {
        
        costGraph = new AE_Dijkstra<>();
        // inserting cities
        costGraph.insertVertex("Madison");
        costGraph.insertVertex("Chicago");
        costGraph.insertVertex("London");
        costGraph.insertVertex("Singapore");
        costGraph.insertVertex("New York");
        costGraph.insertVertex("Dubai");
        costGraph.insertVertex("Reykjavik");
        // inserting costs to fly between cities
        costGraph.insertEdge("Madison", "Chicago", 25);
        costGraph.insertEdge("Chicago", "Madison", 35);
        costGraph.insertEdge("London", "Chicago", 70);
        costGraph.insertEdge("Chicago", "New York", 45);
        costGraph.insertEdge("New York", "Madison", 115);
        costGraph.insertEdge("New York", "Singapore", 100);
        costGraph.insertEdge("Chicago", "Singapore", 120);
        costGraph.insertEdge("Singapore", "London", 90);
        costGraph.insertEdge("London", "Reykjavik", 45);
        costGraph.insertEdge("Reykjavik", "Dubai", 50);
        costGraph.insertEdge("New York", "London", 55);
        costGraph.insertEdge("London", "New York", 60);
        costGraph.insertEdge("New York", "Reykjavik", 75);
        costGraph.insertEdge("Dubai", "New York", 80);
        // initialize a graph where the vertexes are cities and the edges are the time
        // to fly between cities in minutes
        timeGraph = new AE_Dijkstra<>();
        // inserting cities
        timeGraph.insertVertex("Madison");
        timeGraph.insertVertex("Chicago");
        timeGraph.insertVertex("London");
        timeGraph.insertVertex("Singapore");
        timeGraph.insertVertex("New York");
        timeGraph.insertVertex("Dubai");
        timeGraph.insertVertex("Reykjavik");
        // inserting time to fly between cities
        timeGraph.insertEdge("Madison", "Chicago", 70);
        timeGraph.insertEdge("Chicago", "Madison", 55);
        timeGraph.insertEdge("London", "Chicago", 530);
        timeGraph.insertEdge("Chicago", "New York", 130);
        timeGraph.insertEdge("New York", "Madison", 165);
        timeGraph.insertEdge("New York", "Singapore", 1100);
        timeGraph.insertEdge("Chicago", "Singapore", 1290);
        timeGraph.insertEdge("Singapore", "London", 840);
        timeGraph.insertEdge("London", "Reykjavik", 195);
        timeGraph.insertEdge("Reykjavik", "Dubai", 660);
        timeGraph.insertEdge("New York", "London", 420);
        timeGraph.insertEdge("London", "New York", 490);
        timeGraph.insertEdge("New York", "Reykjavik", 340);
        timeGraph.insertEdge("Dubai", "New York", 870);
        
     // testing fastest flight path between chicago and dubai, should go through new
        // york and reykjavik
        assertTrue(timeGraph.shortestPathPrice("Chicago", "Dubai").toString()
                .equals("[Chicago, New York, Reykjavik, Dubai]"));
        // testing fastest flight path between madison and singapore, should go through
        // chicago and new york
        assertTrue(timeGraph.shortestPathPrice("Madison", "Singapore").toString()
                .equals("[Madison, Chicago, New York, Singapore]"));

        // testing fastest flight path between london and madison, should go through
        // chicago
        assertTrue(timeGraph.shortestPathPrice("London", "Madison").toString()
                .equals("[London, Chicago, Madison]"));
    }

 /** 
     * JUnitTest to ensure backend still works as expected. These testers are now similar to backend tests above
     * (but different from the originally submitted testers) because original testers were also rewritten for 
     * integration since backend implementation had to change when other roles altered
     * their data structures after individual role code week. This tests cheapest cost algorithms without placeholders.
     */
    @Test
    public void BackendDeveloperIntegration1() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
        HashMap<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                List<Flights> flights7 = new ArrayList<Flights>();
                List<Flights> flights8 = new ArrayList<Flights>();
                flights7.add(place);
                flights8.add(place2);
                flights.put("Madison", flights7);
                flights.put("Chicago", flights8);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
                // checking that the cheapest path for a direct flight correctly returns the right list of cities
                assertEquals(backend.searchByCheapestCost("Madison", "Chicago"), "[Madison, Chicago]");

        // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                HashMap<String, List<Flights>> flights2 = new HashMap<>();
                Flights place3 = new Flights("Minneapolis","JFK",200,11);
                Flights place4 = new Flights("JFK","Boston",679,54);
                List<Flights> flights9 = new ArrayList<Flights>();
                List<Flights> flights10 = new ArrayList<Flights>();
                flights9.add(place3);
                flights10.add(place4);
                flights2.put("Minneapolis", flights9);
                flights2.put("JFK", flights10);
                FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
                // checking that the cheapest path for a direct flight correctly returns the right list of cities
                assertEquals(backend2.searchByCheapestCost("JFK", "Boston"), "[JFK, Boston]");
    }

    /** 
     * JUnitTest to ensure backend still works as expected. These testers are now similar to backend tests above
     * (but different from the originally submitted testers) because original testers were also rewritten for 
     * integration since backend implementation had to change when other roles altered
     * their data structures after individual role code week. This tests shortest path algorithms without placeholders.
     */
    @Test
    public void BackendDeveloperIntegration2() {
        // creating hashmap and adding place objects to it containing cities, costs, and flight distances
        HashMap<String, List<Flights>> flights = new HashMap<>();
                Flights place = new Flights("Madison","Chicago",6,7);
                Flights place2 = new Flights("Chicago","DC",8,20);
                List<Flights> flights7 = new ArrayList<Flights>();
                List<Flights> flights8 = new ArrayList<Flights>();
                flights7.add(place);
                flights8.add(place2);
                flights.put("Madison", flights7);
                flights.put("Chicago", flights8);
                FlightMapperBackend backend = new FlightMapperBackend(flights);
                // checking that shortest path for a direct flight correctly returns the right list of cities
                assertEquals(backend.searchByShortestPath("Madison", "Chicago"), "[Madison, Chicago]");

                // creating another hashmap and adding place objects to it containing cities, costs, and flight distances
                HashMap<String, List<Flights>> flights2 = new HashMap<>();
                Flights place3 = new Flights("Minneapolis","JFK",200,11);
                Flights place4 = new Flights("JFK","Boston",679,54);
                List<Flights> flights9 = new ArrayList<Flights>();
                List<Flights> flights10 = new ArrayList<Flights>();
                flights9.add(place3);
                flights10.add(place4);
                flights2.put("Minneapolis", flights9);
                flights2.put("JFK", flights10);
                FlightMapperBackend backend2 = new FlightMapperBackend(flights2);
                // checking that the cheapest path for a direct flight correctly returns the right list of cities
                assertEquals(backend2.searchByShortestPath("JFK", "Boston"), "[JFK, Boston]");
    }

}