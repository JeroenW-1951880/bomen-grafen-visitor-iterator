public abstract class Edge{
    private boolean $directed = false;
    private DataNode $firstNode, $secondNode;
    private String $label = "";

    /***
     * constructor van een edge met een label
     * @param n1 de node waaruit de edge vertrekt
     * @param n2 de node waar de edge aankomt
     * @param label het label van de edge
     * @param directed een boolean die voorsteld of een pad alleen maar van n1 richting n2 geldt, of beiden kanten op
     */
    public Edge(DataNode n1, DataNode n2, String label, boolean directed){
        this(n1, n2, directed);
        $label = label;
    }

    /***
     * constructor van een edge zonder label
     * @param n1 de node waaruit de edge vertrekt
     * @param n2 de node waar de edge aankomt
     * @param directed een boolean die voorsteld of een pad alleen maar van n1 richting n2 geldt, of beiden kanten op
     */
    public Edge(DataNode n1, DataNode n2, boolean directed){
        $firstNode = n1;
        $secondNode = n2;
        $directed = directed;
    }

    public void setLabel(String label){ $label=label; }
    public String getLabel(){ return $label; }
    public void setDirected(boolean direct){ $directed = direct; }
    public boolean getDirected(){ return $directed; }

    public DataNode getFirst(){ return $firstNode; }
    public DataNode getSecond(){ return $secondNode; }


}

