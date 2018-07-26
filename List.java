/* a linked list to store all the
 * vertices adjacent to a paticular vertex
 */
class List
{
    Node ptr, head, tail;
    /* ptr - pointer to store temporarily the refrence of a node
     * head - stores the refrence of the first node
     * tail - stores the refrence of the last node
     */
    void add(Vertex v)
    {// apending a node to the linked list
        //v is the Vertex corresponding to the node that has to added
        if(head == null)
        {//creating the first node if the list is empty
            head = new Node(v);
            tail = head;
            return;
        }
        tail.next = new Node(v);
        tail.next.prev = tail;
        tail = tail.next;
    }
    boolean search(String n)
    {//searcing for a node in the list
        //n is the name of the vertex that has to be searched
        ptr = head;
        while(ptr!=null)
        {
            if(n.equals(ptr.v.name))
            return true;
            ptr = ptr.next;
        }
        return false;
    }
}//end of class List
    