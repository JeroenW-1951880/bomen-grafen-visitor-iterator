import java.util.Date;

//merk op dat from in feite niet nodig is
class FlightEdge extends Edge{
    public int $flightCapacity;
    public int $freeSeats;
    public Date $departTime;

    /***
     * constructor om een FlightEdge zonder label te maken of vertrektijd in te stellen
     * @param from vertrekpunt van de vlucht
     * @param to bestemming van de vlucht
     */
    public FlightEdge(AirportNode from, AirportNode to){
        super(from, to, true);
    }

    /***
     * constructor van een flightEdge die wel een label toevoegt aan de edge en ook een tijd van vertrek toevoegt
     * @param from vertrekpunt van de vlucht
     * @param to bestemming van de vlucht
     * @param carrierName naam van de maatschappij
     * @param departTime tijd van vertrek
     */
    public FlightEdge(AirportNode from, AirportNode to, String carrierName, Date departTime){
        super(from, to, carrierName, true);
        $departTime = departTime;
    }

    /***
     * constructor van een flightEdge die wel een label toevoegt aan de edge en ook een tijd van vertrek toevoegt en het aantal plaatsen op de vlucht
     * @param from vertrekpunt van de vlucht
     * @param to bestemming van de vlucht
     * @param carrierName naam van de maatschappij
     * @param departTime tijd van vertrek
     * @param capacity aantal plaatsen op de vlucht
     */
    public FlightEdge(AirportNode from, AirportNode to, String carrierName, Date departTime, int capacity){
        super(from, to, carrierName, true);
        $departTime = departTime;
        $flightCapacity = capacity;
        $freeSeats = capacity;
    }

    /***
     * method om een aantal stoelen op een vlucht te reserveren
     * @param seats het aantal stoelen dat je op de vlucht wil reserveren
     * @throws NoMoreSeatsException wanneer er minder dan het gevraagde aantal stoelen overzijn op de vlucht
     */
    public void reserveSeat(int seats) throws NoMoreSeatsException{
        if($freeSeats < seats)
            throw new NoMoreSeatsException(this);
        $freeSeats = $freeSeats-seats;
    }

    public int getFreeSeats(){ return $freeSeats; }
    public int getFlightCapacity(){ return $flightCapacity; }

}
