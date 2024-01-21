// --== CS400 Fall 2022 File Header Information ==--
// Name: Ellany Zalova
// Email: ezalova@wisc.edu
// Team: CQ
// TA: Llay (email: iraz@wisc.edu)
// Lecturer: Gary Dahl

public interface IFlights
{
    public String getTarget(String startCity);

    public int getCost(String startCity);

    public int getDistance(String startCity);
}