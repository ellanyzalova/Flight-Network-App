// --== CS400 Fall 2022 File Header Information ==--
// Name: Ellany Zalova
// Email: ezalova@wisc.edu
// Team: CQ
// TA: Llay (email: iraz@wisc.edu)
// Lecturer: Gary Dahl

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.List;

public interface IPlaneMapperLoader
{

    /**
    * Reads in a DOT file and returns a graph
    *
    * @param file - the DOT file that contains the data to parse through
     * @return 
    * 
    */
    public Map<String, List<Flights>> dataReader(String costGraphFile, String timeGraphFile) throws FileNotFoundException;

}