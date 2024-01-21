// --== CS400 Fall 2022 File Header Information ==--
// Name: Ellany Zalova
// Email: ezalova@wisc.edu
// Team: CQ
// TA: Llay (email: iraz@wisc.edu)
// Lecturer: Gary Dahl

public class Flights implements IFlights
{
    String startingCity;
    String destinationCity;
    int cost;
    int distance;

    public Flights(String startingCity, String destinationCity, int cost, int distance)
    {
        this.startingCity = startingCity;
        this.destinationCity = destinationCity;
        this.cost = cost;
        this.distance = distance;
    }

    @Override
    public String getTarget(String startCity){
        return this.destinationCity;
    }

    @Override
    public int getCost(String startCity){  
            return this.cost;
    }
    
    @Override
    public int getDistance(String startCity){
        return this.distance;
    }
   

}