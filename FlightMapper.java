import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
                                            
public class FlightMapper{

    public static void main(String[] args)
    {
        try
        {
            PlaneMapperLoader loader = new PlaneMapperLoader("cost_graph.gv", "time_graph.gv");
            Map<String, List<Flights>> data = loader.dataReader("cost_graph.gv", "time_graph.gv");
                System.out.println(data.toString());
            FlightMapperBackend backend = new FlightMapperBackend(data);
            Scanner scan = new Scanner(System.in);

            FlightMapperFrontend frontend = new FlightMapperFrontend(scan, backend);
            frontend.runCommandLoop(); 
        }
        catch(Exception e)
        {

        }

    }
    
}