// --== CS400 Fall 2022 File Header Information ==--
// Name: Ellany Zalova
// Email: ezalova@wisc.edu
// Team: CQ
// TA: Llay (email: iraz@wisc.edu)
// Lecturer: Gary Dahl

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaneMapperLoader implements IPlaneMapperLoader
{
    protected Map<String,IFlights> temp;

    //declaring the file path string 
    String costGraphFile;
    String timeGraphFile; 

    /**
     * Constructor for the class
     * @param filePath
     */
    public PlaneMapperLoader(String costGraphFile, String timeGraphFile)
    {
        this.costGraphFile = costGraphFile;
        this.timeGraphFile = timeGraphFile;
    }

    @Override
    public Map<String, List<Flights>> dataReader(String costGraphFile, String timeGraphFile) throws FileNotFoundException
    {
        //File costGraph = new File("cost_graph.gv");
        File costGraph = new File(costGraphFile);

        //File timeGraph = new File("time_graph.gv");
        File timeGraph = new File(timeGraphFile);

        Map<String, List<Flights>> data = new HashMap<>();

        String startingCity = "";
        String destinationCity = "";
        int cost = 0;
        int distance = 0;
        
        Scanner scan;
        Scanner scan2;

        try
        {
            scan = new Scanner(costGraph);
            scan2 = new Scanner(timeGraph);

            while(scan.hasNextLine() && scan2.hasNextLine())
            {
                String currentLineOfScan1 = scan.nextLine();
                String currentLineOfScan2 = scan2.nextLine();

                if(currentLineOfScan1.equals("}") || currentLineOfScan2.equals("}")) break;

                else if((currentLineOfScan1.startsWith("graph") || currentLineOfScan2.startsWith("digraph")) || 
                (currentLineOfScan2.startsWith("graph") || currentLineOfScan2.startsWith("digraph")))
                continue;

                String[] parseStrScan1 = currentLineOfScan1.split(" ");
                String[] parseStrScan2 = currentLineOfScan2.split(" ");

                startingCity = parseStrScan1[2];

                /* 
                for(int i=0; i<parseStrScan1.length; i++)
                {
                    System.out.println(i + ": " + parseStrScan1[i]);
                    
                }
                */

                destinationCity = parseStrScan1[4];

                cost = Integer.parseInt(parseStrScan1[5].substring(parseStrScan1[5].indexOf("=") + 1, parseStrScan1[5].indexOf("]")));
                distance = Integer.parseInt(parseStrScan2[5].substring(parseStrScan2[5].indexOf("=") + 1, parseStrScan2[5].indexOf("]")));

                //lights flight = new Flights(startingCity, destinationCity, cost, distance);

                /* 
                System.out.println("startingCity: " + startingCity);
                System.out.println("destinationCity: " + destinationCity);
                System.out.println("cost: " + cost);
                System.out.println("distance: " + distance);
                */

                if(data.containsKey(startingCity))
                {
                    List<Flights> flights = data.get(startingCity);
                    flights.add(new Flights(startingCity, destinationCity, cost, distance));
                    data.put(startingCity, flights);

                }
                else 
                {
                    List<Flights> flights = new ArrayList<>();
                    flights.add(new Flights(startingCity, destinationCity, cost, distance));
                    data.put(startingCity, flights);

                }
                
            }
        }
        catch(FileNotFoundException e)
        {

        }
        return data;
    }

}