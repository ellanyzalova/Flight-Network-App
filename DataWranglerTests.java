// --== CS400 Fall 2022 File Header Information ==--
// Name: Ellany Zalova
// Email: ezalova@wisc.edu
// Team: CQ
// TA: Llay (email: iraz@wisc.edu)
// Lecturer: Gary Dahl
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataWranglerTests
{
    @Test
    void DataWranglerTest1()
    {

        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");

        //testing that graph files could be found
        try 
        {
            tester.dataReader("cost_graph.gv", "time_graph.gv");
        } 
        catch (FileNotFoundException e) 
        {
            assertEquals("true", "false"); //return false if exception is thrown
        }

    }

    @Test
    void DataWranglerTest2()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        Map<String, List<Flights>> data = new HashMap<>();
        int iteration = 0;

        try
        {
            data = tester.dataReader("cost_graph.gv", "time_graph.gv");
            for(String key: data.keySet())
            {
                iteration++;
                if(iteration == 1)
                {
                    if(key.equals("Madison")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 2)
                {
                    if(key.equals("Detroit")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 3)
                {
                    if(key.equals("Sacramento")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 4)
                {
                    if(key.equals("Chicago")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 5)
                {
                    if(key.equals("Atlanta")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 6)
                {
                    if(key.equals("Columbus")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 7)
                {
                    if(key.equals("St_Louis")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 8)
                {
                    if(key.equals("Houston")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 9)
                {
                    if(key.equals("Boston")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
            }
        
        }
        catch(Exception e)
        {
            assertEquals(true, false);
        }
        
    }

    @Test
    void DataWranglerTest3()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        Map<String, List<Flights>> data = new HashMap<>();
        int iteration = 0;

        try
        {
            data = tester.dataReader("cost_graph.gv", "time_graph.gv");
            for(String key: data.keySet())
            {
                iteration++;
                if(iteration == 1)
                {
                    if(data.values().size() != 9)  assertEquals(true, false); //true, false
                    else assertEquals(true, true); //true, true
                }
                if(iteration == 2)
                {
                    if(data.values().size() != 9) assertEquals(true, false); //true, false
                    else assertEquals(true, true); //true, true
                }
                if(iteration == 3)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 4)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 5)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 6)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 7)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 8)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
                if(iteration == 9)
                {
                    if(data.values().size() != 9) assertEquals(true, false);
                    else assertEquals(true, true);
                }
            }
        }
        catch(Exception e)
        {
            assertEquals(true, false);
        }
    }

    @Test
    void DataWranglerTest4()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        //testing that nonexistent files are not read
        try 
        {
            tester.dataReader("SomethingIncorrect1.xml", "SomethingIncorrect2.xml");
        } 
        catch (FileNotFoundException f) 
        {
            assertEquals("true", "true"); //return true if exception is thrown
        }
    }

    @Test
    void DataWranglerTest5()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        Map<String, List<Flights>> data = new HashMap<>();
        int iteration = 0;

        try
        {
            data = tester.dataReader("cost_graph.gv", "time_graph.gv");
            for(String key: data.keySet())
            {
                iteration++;
                if(iteration == 1)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 2)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 3)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 4)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 5)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 6)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 7)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 8)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 9)
                {
                    if(data.keySet().toString().equals("[Madison, Detroit, Sacramento, Chicago, Atlanta, Columbus, St_Louis, Houston, Boston]")) assertEquals(true, true);
                    else assertEquals(true, false);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void DataWranglerTest6()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        Map<String, List<Flights>> data = new HashMap<>();
        int iteration = 0;

        try
        {
            data = tester.dataReader("cost_graph.gv", "time_graph.gv");
            for(String key: data.keySet())
            {
                iteration++;
                if(iteration == 1)
                {
                    if(key.length() == 7) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 2)
                {
                    if(key.length() == 7) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 3)
                {
                    if(key.length() == 10) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 4)
                {
                    if(key.length() == 7) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 5)
                {
                    if(key.length() == 7) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 6)
                {
                    if(key.length() == 8) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 7)
                {
                    if(key.length() == 8) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 8)
                {
                    if(key.length() == 7) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 9)
                {
                    if(key.length() == 6) assertEquals(true, true);
                    else assertEquals(true, false);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void DataWranglerIntegrationTest7()
    {
        PlaneMapperLoader tester = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
        Map<String, List<Flights>> data = new HashMap<>();
        int iteration = 0;

        try
        {
            data = tester.dataReader("cost_graph.gv", "time_graph.gv");
            for(String key: data.keySet())
            {
                iteration++;
                if(iteration == 1)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 2)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 3)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 4)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 5)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 6)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 7)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 8)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
                if(iteration == 9)
                {
                    if(!data.values().isEmpty()) assertEquals(true, true);
                    else assertEquals(true, false);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @Test
    void DataWranglerIntegrationTest8()
    {
        Flights f1 = new Flights("Boston", "Chicago", 40, 2000);

        HashMap<String, List<Flights>> data = new HashMap<>();

        ArrayList<Flights> flightInfo = new ArrayList<>();
        flightInfo.add(f1);

        data.put("Chicago", flightInfo);

        for(int i=0; i<flightInfo.size(); i++)
        {
            if(flightInfo.get(i).distance == 2000) assertEquals(true, true);
            else assertEquals(true, false);

            if(flightInfo.get(i).cost == 40) assertEquals(true, true);
            else assertEquals(true, false);

            if(flightInfo.get(i).destinationCity.equals("Chicago")) assertEquals(true, true);
            else assertEquals(true, false);
        }
    }

    @Test
    public void CodeReviewOfFrontendDeveloperTest1(){
    Map<String, List<Flights>> temp = new HashMap<>();
    List<Flights> flights = new ArrayList<>();
    Flights obj1 = new Flights("Chicago", "Madison", 150, 5000);
    Flights obj2 = new Flights("Madison", "Houston", 50, 4000);
    Flights obj3 = new Flights("Chicago", "Houston", 250, 10000);
    flights.add(obj1);
    flights.add(obj3);
    temp.put("Chicago", flights);
    flights = new ArrayList<>();
    flights.add(obj2);
    temp.put("Madison", flights);
    FlightMapperBackend be = new FlightMapperBackend(temp);
    Scanner scn = new Scanner(System.in);
    FlightMapperFrontend fe = new FlightMapperFrontend(scn, be);
    TextUITester test = new TextUITester("2\nChicago\nHouston\n3\n");
    fe.runCommandLoop();
    String output = test.checkOutput();
    if(!output.contains("[Chicago, Madison, Houston]")){
        assertEquals(true, false);
    }
    if(!output.startsWith("Welcome to the Flight Mapper Application!")){
        assertEquals(true, false);
    }
     assertEquals(true, true);
    }

    @Test
    public void CodeReviewOfFrontendDeveloperTest2(){
        Map<String, List<Flights>> temp = new HashMap<>();
        List<Flights> flights = new ArrayList<>();
        Flights obj1 = new Flights("LA", "Madison", 1000, 5000);
        Flights obj2 = new Flights("Madison", "New York", 500, 2000);
        Flights obj3 = new Flights("Madison", "Chicago", 250, 1000);
        Flights obj4 = new Flights("LA", "Chicago", 1350, 6100  );
        Flights obj5 = new Flights("New York", "Chicago", 700, 1200);
        flights.add(obj1);
        flights.add(obj4);
        temp.put("LA", flights);
        flights = new ArrayList<>();
        flights.add(obj2);
        flights.add(obj3);
        temp.put("Madison", flights);
        flights = new ArrayList<>();
        flights.add(obj5);
        temp.put("New York", flights);
        FlightMapperBackend be = new FlightMapperBackend(temp);
        Scanner scn = new Scanner(System.in);
        FlightMapperFrontend fe = new FlightMapperFrontend(scn, be);
        TextUITester test = new TextUITester("2\nLA\nChicago\n3\n");
        fe.runCommandLoop();
        String output = test.checkOutput();
        if(!output.contains("[LA, Madison, Chicago]")){
            assertEquals(true, false);
        }
        if(!output.startsWith("Welcome to the Flight Mapper Application!")){
            assertEquals(true, false);
        }

        TextUITester test2 = new TextUITester("1\nLA\nChicago\n3\n");
        fe.runCommandLoop();
        String output2 = test2.checkOutput();
        if(!output2.contains("[LA, Madison, Chicago]")){
            assertEquals(true, false);
        }
        if(!output2.startsWith("Welcome to the Flight Mapper Application!")){
            assertEquals(true, false);
        }

        assertEquals(true, true);

    }
}




    
        

