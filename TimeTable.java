//the main class of the program
//importing packages from java class library
import java.io.*;
import java.util.*;
public class TimeTable
{
    public static void main(String args[])
    {
        File f = new File(args[0]);
        //taking the file from the command line argument
        boolean chk = true;
        try{
            //handling errors in the IO streams
        FileInputStream fis = new FileInputStream(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String v[];
        //s stores the lines from the file
        String s;
        //st breaks s to tokens to create the graph
        StringTokenizer st;
        //initialising the graph
        Graph g = new Graph(Integer.parseInt(args[1]));
        //reading from the file and crating the graph
        while((s=br.readLine())!= null)
        {
            int i = 0;
            st = new StringTokenizer(s);
            v = new String[st.countTokens()];
            //adding each element to the list
            while(st.hasMoreTokens())
                g.add(v[i++] = st.nextToken());
            //selecting one element from the list at a time and adding edge to others
            for(int x = 0; x < i; x++)
            for(int y = 0; y < i; y++)
            g.addEdge(v[x], v[y]);
        }
        //printing the graph
        g.printGraph();
        //reading the choice for coloring and perforing accordingly
        int n = Integer.parseInt(args[2]);
        if(n==1)
        chk = g.colorGreedy();
        else if(n==2)
        chk = g.colorBack(0, Integer.parseInt(args[3]));
        else
        g.color();
        if(chk)
        g.print();
        else
        System.out.println("Colouring not possible!");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid Format!");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid Format!");
        }
        catch(Exception e){
            System.out.println("Error during execuion!");
            System.out.println(e);
        }
    }
}//end of main class
    