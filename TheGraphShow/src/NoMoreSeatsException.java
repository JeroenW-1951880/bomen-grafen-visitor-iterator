public class NoMoreSeatsException extends Exception{
    private FlightEdge $fEdge;

    public NoMoreSeatsException(FlightEdge fe){
        $fEdge = fe;
    }

    public String toString(){
        return "There are no more seats available on flight to " + $fEdge.getSecond();
    }
}
