class Node
{//nodes of the linked list
    Vertex v;
    Node next, prev;
    /* v - stores the refrence of vertex associated to the node
     * next - stores the refrence of the next node
     * prev - stores the refrence of the previous node
     */
    public Node(Vertex v)
    {//v takes the vertex for initialising the node
        this.v = v;
        next = prev = null;
    }
}//end of class