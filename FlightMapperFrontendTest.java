import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester for the FlightMapperFrontend class
 */
class FlightMapperFrontendTest {

    /**
     * Tests the displayMenu method of the FlightMapperFrontend class.
     */
    @Test
    public void Test1(){
    Scanner scan = new Scanner(System.in);
    FDFlightMapperBackend backend = new FDFlightMapperBackend();
    FlightMapperFrontend temp = new FlightMapperFrontend(scan, backend);
    TextUITester test = new TextUITester("");
    temp.displayMainMenu();
    String output = test.checkOutput();
    if(!output.startsWith("You are in the Main Menu:")||!output.contains("1) Search by shortest distance")
            ||!output.contains("2) Search by cheapest route")||!output.contains("3) Exit Application")){
        assertEquals(true, false);
    }
    else{
        assertEquals(true, true);
    }

}

    /**
     * Tests the priceSearch function of the FlightMapperFrontend class.
     */
    @Test
    public void Test2(){
    TextUITester test = new TextUITester("2\nNew York\nLos Angeles\n3\n");
    test.run();
    String output = test.checkOutput();
    if(!output.contains("New York Chicago Los Angeles")){
        assertEquals(true, false);
    }
    if(!output.startsWith("Welcome to the Flight Mapper Application!")){
        assertEquals(true, false);
    }
    assertEquals(true, true);

}

    /**
     * Tests the timeSearch function of the FlightMapperFrontend class.
     */
    @Test
    public void Test3(){
    TextUITester test = new TextUITester("1\nNew York\nLos Angeles\n3\n");
    test.run();
    String output = test.checkOutput();
    if(!output.contains("New York Los Angeles")){
        assertEquals(true, false);
    }
    if(!output.startsWith("Welcome to the Movie Mapper Application!")){
        assertEquals(true, false);
    }
    assertEquals(true, true);

}
    /**
     * Tests if the commanLopp terminates whent the input is 3.
     */
    @Test
    public void Test4(){
    TextUITester test = new TextUITester("3\n");
    test.run();
    String output = test.checkOutput();
    if(output.contains("New York")||output.contains("Chicago")||output.contains("Los Angeles")){
        assertEquals(true, false);
    }
    if(!output.startsWith("Welcome to the Flight Mapper Application!")){
        assertEquals(true, false);
    }
    assertEquals(true, true);
}

    /**
     * Tests if the output tells the user about the invalid input when the input is invalid.
     */
    @Test
    public void Test5(){
    TextUITester test = new TextUITester("4\n3\n");
    test.run();
    String output = test.checkOutput();
    if(!output.contains("Invalid input, try again!!.")){
        assertEquals(true, false);
    }
    if (!output.startsWith("Welcome to the Flight Mapper Application!")){
        assertEquals(true, false);
    }
    assertEquals(true, true);
}
}