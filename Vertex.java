//a data type to store the vertices of the graph
class Vertex
{
    String name;
    int clr;
    List edges;
    /* name - stores the name of the vertex.
     * clr - stores the colour assigned to the vertex.
     * edges - stores all the vertices that are adjacent to this vertex.
     */
    public Vertex(String n)
    {//n takes the name of the vertex
        name = n;
        //setting default colour to -1
        clr = -1;
        edges = new List();
    }
    public Vertex(String n, int c)
    {//n takes the name and c the colour of the vertex
        name = n;
        clr = c;
        edges = new List();
    }
    void addEdge(Vertex v)
    {//adding adjacent vertex
        edges.add(v);
    }
    public String toString()
    {
        return name;
    }
}//end of class