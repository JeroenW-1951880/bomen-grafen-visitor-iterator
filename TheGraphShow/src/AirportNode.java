import java.util.ArrayList;

public class AirportNode extends DataNode{
    private ArrayList<FlightEdge> $departingFlights = new ArrayList<FlightEdge>();

    public AirportNode(String airportName){
        super(airportName);
    }

    public ArrayList<FlightEdge> get$departingFlights(){ return $departingFlights; }

    public void addFlight(FlightEdge flight){
        $departingFlights.add(flight);
    }
}