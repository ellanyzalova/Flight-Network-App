import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

public class AlgorithmEngineerTests {

    private AE_Dijkstra<String, Integer> costGraph;
    private AE_Dijkstra<String, Integer> timeGraph;

    // method to create graph with prices as edges and a method to create graph with
    // time as edges
    @BeforeEach
    public void initGraphs() {
        // initialize a graph where the vertexes are cities and the edges are the cost
        // to fly between cities
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
    }

    /**
     * This method tests the getTime and getPrice methods on the cost and time
     * graphs with multiple test cases
     */
    @Test
    public void testGetTimeandPrice() {
        // testing getPrice
        assertTrue(costGraph.getPrice("Chicago", "Madison") == 35);
        assertTrue(costGraph.getPrice("Dubai", "New York") == 80);
        assertTrue(costGraph.getPrice("Singapore", "London") == 90);

        // testing getTime
        assertTrue(timeGraph.getTime("Reykjavik", "Dubai").equals("660"));
        assertTrue(timeGraph.getTime("Chicago", "Singapore").equals("1290"));
        assertTrue(timeGraph.getTime("Madison", "Chicago").equals("70"));

    }

    /**
     * This method tests the functionality of the shortestPathPrice method with
     * three different test cases on the cost graph
     */
    @Test
    public void testShortestPathPrice() {
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
     * This method tests the functionality of the getPathCostPrice method with
     * three different test cases on the cost graph
     */
    @Test
    public void testGetPathCostPrice() {
        // testing if getPathCostPrice accurately returns cost of flying between
        // Singapore
        // and Madison
        assertTrue(costGraph.getPathCostPrice("Singapore", "Madison") == 195);

        // testing if getPathCostPrice accurately returns cost of flying between
        // Reykjavik
        // and Singapore
        assertTrue(costGraph.getPathCostPrice("Reykjavik", "Singapore") == 230);

        // testing if getPathCostPrice accurately returns cost of flying between Dubai
        // and
        // Chicago
        assertTrue(costGraph.getPathCostPrice("Dubai", "Chicago") == 205);

    }

    /**
     * This method tests the functionality of the shortestPathTime method with
     * three different test cases on the time graph
     */
    @Test
    public void testShortestPathTime() {
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
     * This method tests the functionality of the getPathCostTime method with
     * three different test cases on the time graph
     */
    @Test
    public void testGetPathCostTime() {
        // testing if getPathCostTime accurately returns fastest flight time between
        // Chicago and Dubai
        assertTrue(timeGraph.getPathCostPrice("Chicago", "Dubai") == 1130);

        // testing if getPathCostTime accurately returns fastest flight time between
        // Madison and Singapore
        assertTrue(timeGraph.getPathCostPrice("Madison", "Singapore") == 1300);

        // testing if getPathCostTime accurately returns fastest flight time between
        // London and Madison
        assertTrue(timeGraph.getPathCostPrice("London", "Madison") == 585);

    }

}