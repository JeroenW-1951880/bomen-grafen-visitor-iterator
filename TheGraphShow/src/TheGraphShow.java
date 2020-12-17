import java.util.*;
import java.time.*;


public class TheGraphShow{


    private Map<AirportNode, List<AirportNode>> $graph1;
    private List<AirportNode>                   $graph2;
    private boolean[][]                         $graph3;

    public TheGraphShow(){
        SetupGraph1();
        SetupGraph2();
    }

    public void SetupGraph1(){
        AirportNode bru = new AirportNode("BRU");
        AirportNode lax = new AirportNode("LAX");
        AirportNode sin = new AirportNode("SIN");
        AirportNode lhr = new AirportNode("LHR");
        AirportNode las = new AirportNode("LAS");
        AirportNode jfk = new AirportNode("JFK");
        AirportNode ams = new AirportNode("AMS");
        AirportNode cdg = new AirportNode("CDG");

        //adjacency graph approach
        $graph1 = new HashMap();
        $graph1.put(bru, Arrays.asList(las, cdg));
        $graph1.put(las, Arrays.asList(bru, jfk, lax));
        $graph1.put(cdg, Arrays.asList(lax, sin));
        $graph1.put(sin, Arrays.asList(lhr));
        $graph1.put(lhr, Arrays.asList(cdg,lax));
        $graph1.put(lax, Arrays.asList(las,jfk));
        $graph1.put(jfk, Arrays.asList(lhr));
        $graph1.put(ams, Arrays.asList(lhr,cdg,jfk,lax));


        //test de searchPath functie voor de compacte representatie:
        AirportNode searchFrom = bru;
        AirportNode searchTo = sin;
        try{
            ArrayList<AirportNode> al = searchPath1(searchFrom, searchTo);
            al.add(searchFrom);
            Collections.reverse(al);
            System.out.println(al);
            ArrayList<FlightEdge> fe = searchPath2(searchFrom, searchTo);
            System.out.println(fe);
        }catch(NoPathException npe){
            System.out.println("no path from " + searchFrom + " to " + searchTo + ".");
        }


    }

    /***
     * method die een pad geeft tussen n1 en n2
     * @param n1 begin van het pad
     * @param n2 bestemming
     * @returnn een pad tussen n1 en n2
     * @throws NoPathException wanneer er geen pad tussenbeiden is
     */
    public ArrayList<AirportNode> searchPath1(AirportNode n1, AirportNode n2) throws NoPathException{
        return BFS(n1, n2);
    }

    /***
     * method die het eerste gevonden pad tussen n1 en n2 teruggeeft
     * @param n1 begin van het pad
     * @param n2 bestemming
     * @param visited een array die je bijhoudt om te kijken welke nodes al bezocht werden
     * @return het pad tussen n1 en n2 dat gevonden werd
     * @pre visited bevat al n1
     * @throws NoPathException wanneer er geen pad is tussen n1 en n2
     */
    private ArrayList<AirportNode> searchPath1Mark(AirportNode n1, AirportNode n2,
                                                   ArrayList<AirportNode> visited) throws NoPathException {
        if ($graph1.get(n1).contains(n2)) {
            return new ArrayList<AirportNode>(Arrays.asList(n2));
        } else {
            for (AirportNode e : $graph1.get(n1)) {
                if (!visited.contains(e))
                    try {
                        visited.add(e);
                        ArrayList<AirportNode> partialPath = searchPath1Mark(e, n2, visited);
                        partialPath.add(e);
                        return partialPath;
                    } catch (NoPathException npe) {
                    }
            }
        }
        throw new NoPathException();
    }


    private ArrayList<AirportNode> BFS(AirportNode n1, AirportNode n2) throws NoPathException
    {
        Map<AirportNode, AirportNode> solved = solve(n1);
        return reconstrueer_pad(n1, n2, solved);
    }

    private Map<AirportNode, AirportNode> solve(AirportNode n){
        ArrayList<AirportNode> queue = new ArrayList<>();
        queue.add(n);
        ArrayList<AirportNode> visited = new ArrayList<>();
        visited.add(n);
        Map<AirportNode, AirportNode> parents = new HashMap<>();
        Set<AirportNode> keys = $graph1.keySet();
        for(AirportNode node: keys){
            parents.put(node, null);
        }
        while(queue.size() > 0){
            AirportNode node = queue.remove(0);
            List<AirportNode> neigbours = $graph1.get(node);
            for(AirportNode next: neigbours){
                if(!visited.contains(next)){
                    queue.add(next);
                    visited.add(next);
                    parents.replace(next, node);
                }
            }
        }
        return parents;
    }

    private ArrayList<AirportNode> reconstrueer_pad(AirportNode start, AirportNode end, Map<AirportNode, AirportNode> parents) throws NoPathException{
        ArrayList<AirportNode> path = new ArrayList<>();
        AirportNode current = end, parent;
        path.add(end);
        try{parent = parents.get(current);}catch (NullPointerException e){throw new NoPathException();}
        while(parent != start){
            current = parent;
            parent = parents.get(current);
            path.add(current);
        }
        return path;
    }


    public void SetupGraph2(){
        //create airports
        AirportNode bru = new AirportNode("BRU");
        AirportNode lax = new AirportNode("LAX");
        AirportNode sin = new AirportNode("SIN");
        AirportNode lhr = new AirportNode("LHR");
        AirportNode las = new AirportNode("LAS");
        AirportNode jfk = new AirportNode("JFK");
        AirportNode ams = new AirportNode("AMS");
        AirportNode cdg = new AirportNode("CDG");
        $graph2 = Arrays.asList(bru,lax,sin,lhr,las,jfk,ams,cdg);

        //set some flights between airports;
        bru.addFlight(new FlightEdge(bru, las));
        bru.addFlight(new FlightEdge(bru, cdg));

        las.addFlight(new FlightEdge(las, bru));
        las.addFlight(new FlightEdge(las, jfk));
        las.addFlight(new FlightEdge(las, lax));

        cdg.addFlight(new FlightEdge(cdg, sin));
        cdg.addFlight(new FlightEdge(cdg, lax));

        sin.addFlight(new FlightEdge(sin, lhr));

        lhr.addFlight(new FlightEdge(lhr, cdg));
        lhr.addFlight(new FlightEdge(lhr, lax));

        lax.addFlight(new FlightEdge(lax, las));
        lax.addFlight(new FlightEdge(lax, jfk));

        jfk.addFlight(new FlightEdge(jfk, lhr));


		try{
			AirportNode searchFrom = bru;
			AirportNode searchTo = sin;
			ArrayList<FlightEdge> itenary = searchPath2(searchFrom, searchTo);

		}catch(NoPathException npe){

		}


    }

    private ArrayList<FlightEdge> searchPath2(AirportNode searchFrom, AirportNode searchTo) throws NoPathException{
        ArrayList<FlightEdge> solved = BFS2(searchFrom, searchTo);
        return solved;
    }

    private ArrayList<FlightEdge> BFS2(AirportNode n1, AirportNode n2) throws NoPathException{
        ArrayList<AirportNode> parentarray = solve2(n1);
        return null; ///later verder afwerken
    }

    private ArrayList<AirportNode> solve2(AirportNode n1){
        ArrayList<AirportNode> queue = new ArrayList<>();
        queue.add(n1);
        ArrayList<AirportNode> visited = new ArrayList<>();
        visited.add(n1);
        ArrayList<AirportNode> parents = new ArrayList<>();
        for(int i = 0; i < $graph2.size(); i++){
            parents.add(null);
        }
        while(queue.size() > 0){
            AirportNode n = queue.remove(0);
            for(FlightEdge flight: n.get$departingFlights()){
                if(!visited.contains(flight.getSecond())){
                    visited.add((AirportNode)flight.getSecond());
                    parents.set($graph2.indexOf((AirportNode)flight.getSecond()), n);
                    queue.add((AirportNode)flight.getSecond());
                }
            }
            for(AirportNode an : $graph2){
                if(!visited.contains(an)){
                    for(FlightEdge flight: an.get$departingFlights()){
                        if(flight.getSecond() == n){
                            visited.add(an);
                            parents.set($graph2.indexOf(an), n);
                            queue.add(an);
                        }
                    }
                }
            }
        }
        return parents;
    }



    public static void main(String[] args){
        TheGraphShow tgs = new TheGraphShow();
    }

}

