/* the class Graph creates a graph data structure to 
 * store the various vertices and colours the vertices in such a way
 * that no two verices get the same colour.
 */
class Graph
{
    Vertex[] subs;
    int ind;
    /* subs - stores all the vertices of the graph
     * ind - stores the index of the last vertex
     */
    public Graph(int n)
    {//n takes the maximum size of the graph
        subs = new Vertex[n];
        ind = -1;
    }
    void add(String name)
    {//name is the name of the vertex to be appended
        //appendind a vertex only if it does not alredy exist
        if(!check(name))
        subs[++ind] = new Vertex(name);
    }
    void addEdge(String s1, String s2)
    {//creating edges between two vertices - s1 and s2
       //s1 and s2 are to be diffrent and present in graph
       if(s1.equals(s2)) return;
       Vertex v1, v2;
       //v1 and v2 are vertices corresponding to the names s1 and s2
       /* an edge between the two vertices will be made in both
        * directions, i.e., from v1 to v2 as well as from v2 to v1.
        * Thus, making it an undirected graph.
        */
       for(int i = 0; i <= ind; i++)
       {
           if(s1.equals(subs[i].name))
           {//findind the vertex with name s1
               v1 = subs[i];
               //an edge will be made only if the edge does not already exists
               if(!v1.edges.search(s2))
               {
                   for(int j = 0; j <= ind; j++)
                   {
                       if(s2.equals(subs[j].name))
                       {//creating budirectional edge
                           v2 = subs[j];
                           v1.addEdge(v2);
                           v2.addEdge(v1);
                           break;
                        }
                    }
                }
               break;
            }
        }
    }
    //utility function to check whether current colouring of graph is valid
    boolean checkColoring()
    {
        Node ptr;
        //ptr is the pointer node to store each edge of a vertex at a time
        for(int i = 0; i <= ind; i++)
        {
            int c = subs[i].clr;
            ptr = subs[i].edges.head;
            /* checking if the colour of the current vertex does not clash
             * with any of the vertices it has a edge with.
             */
            while(ptr!=null)
            {
                if(ptr.v.clr == c)
                return false;
                ptr = ptr.next;
            }
        }
        return true;
    }
    //utility functions to get the number of colours in the graph
    int getColors()
    {
        /* checking which vertex has the maximum colour value and accordingly
         * returning the number of colour used currently to colour
         * the graph.
         */
        int g = 0;
        for(int i = 0; i <= ind; i++)
        if(subs[i].clr > g) g = subs[i].clr;
        return g+1;
    }
    //the main colouring functions whuch gives the optimum colouring
    void color()
    {
        /* getting a rough estimate of colours required to colour the
         * graph using greedy colouring algorithm. Using this number, then using
         * the back tracking algorithm to check the graph for lesser number of colours.
         * Repeating the same until the minimum possible colour is reached.
         */
        colorGreedy();
        //getting an estimate of colours
        int n = getColors();
        reset();
        for(int i = 1; i < n; i++)
        {
            //checking colouring with oe less color each time.
        boolean chk = colorBack(0, n-i);
        if(!chk)
        {
            reset();
            colorBack(0, n-i+1);
            return;
        }
        reset();
    }
    }
    //utility function to print the final colours of vertices
    void print()
    {
        for(int i = 0; i <= ind; i++)
        {
            System.out.println(subs[i] + ", " + subs[i].clr);
        }
    }
    //utility function to print the graph
    void printGraph()
    {
        Node ptr;
        //ptr is a pointer for edges
        for(int i = 0; i <= ind; i++)
        {//printing the name of vertex followed by edges
            System.out.print(subs[i] + " - ");
            ptr = subs[i].edges.head;
            while(ptr != null)
            {
                System.out.print(ptr.v.name + " ");
                ptr = ptr.next;
            }
            System.out.println();
        }
    }
    //function to implement the greedy colouring algorithm
    boolean colorGreedy()
    {
        Node ptr;//pointer for edges
        L1:for(int i = 0; i<=ind; i++)
        {//taking one colour at a time
            L2:for(int j = 0; j <= ind; j++)
            {//coloring all possible vertices with 'i'
                if(subs[j].clr == -1)
                {
                    ptr = subs[j].edges.head;
                    while(ptr!=null)
                    {
                        if(ptr.v.clr == i)
                        continue L2;
                        ptr = ptr.next;
                    }
                    subs[j].clr = i;
                }
            }
        }
        return(checkColoring());
    }
    //utility function to reset the graph to default colours
    void reset()
    {
        for(int i = 0; i <= ind; i++)
        subs[i].clr = -1;
    }
    //utility function to search for a vertex in graph
    boolean check(String n)
    {//n is the name of the vertex to be searched for
        for(int i = 0; i <= ind; i++)
            if(subs[i].name.equals(n)) return true;
        return false;
    }
    //implementing the backtracking algorithm for colouring the graph
    boolean colorBack(int k, int c)
    {
        if(k>ind) return true;//base condition
        Node ptr;
        L1:for(int j = 0; j < c; j++)
                {
                    /* alloting the minimum possible colour to the vertex
                     * with respect to the colour of vertices before it.
                     */
                    ptr = subs[k].edges.head;
                    while(ptr!=null)
                    {
                        if(ptr.v.clr == j)
                        continue L1;
                        ptr = ptr.next;
                    }
                    subs[k].clr = j;
                    if(colorBack(k+1, c)) return true;//recursion statement
                }
        return false;
    }
}// end of class Graph
    