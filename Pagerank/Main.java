import java.util.Scanner;

public class Main
{
    public static void main (String[] args) 
    {
        int nodes, iterations = 1;
        int [][] path;
        double [] Pagerank, TempPagerank;
        double InitialPagerank;
        double dampingfactor = 0.85, OutgoingLinks;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of webpages: ");
        nodes = s.nextInt();
        path = new int[nodes][nodes];
        Pagerank = new double[nodes];
        TempPagerank = new double[nodes];
        System.out.println("Enter the path of one webpage to another webpage by using 1 for path and 0 for no path");
        for(int i = 0; i<nodes; i++)
        {
            for(int j = 0; j<nodes; j++)
            {
                path[i][j] = s.nextInt();
                if(i==j)
                    path[i][j]=0;
            }
        }
        InitialPagerank = (1/(double)nodes);
        System.out.println("Total Number of Nodes: "+nodes);
        System.out.println("Initial Pagerank: "+InitialPagerank+"\n");
        System.out.println("Initial Pagerank values for all the nodes 0th iterations: ");
        for(int i = 0; i<nodes; i++)
        {
            Pagerank[i] = InitialPagerank; 
            System.out.println("The pagerank of "+i+" is:  "+Pagerank[i]);
        }
        while(iterations<3)
        {
            for(int i = 0; i<nodes; i++)
            {
                TempPagerank[i] = Pagerank[i];    
                Pagerank[i] = 0;
            }
            for(int i = 0; i<nodes; i++)
			{
				for(int j = 0; j<nodes; j++)
				{
					if(path[j][i] == 1)
					{
						int k=0;
						OutgoingLinks=0;
						while(k<nodes)
						{
							if(path[j][k] == 1 )
								OutgoingLinks=OutgoingLinks+1;
							k=k+1;  
						}	       
						Pagerank[i]+=TempPagerank[j]*(1/OutgoingLinks);
					}
				}
			}
            System.out.println("\nAfter "+iterations+" iterations:");
            for(int i = 0; i<nodes; i++)
                System.out.println("The pagerank of "+i+" is:  "+Pagerank[i]);
            iterations++;
        }
        for(int i = 0; i<nodes; i++)
            Pagerank[i] = (1 - dampingfactor) + dampingfactor * Pagerank[i]; 
        System.out.println("\nFinal Pagerank is: ");
            for(int i = 0; i<nodes; i++)
                System.out.println("The pagerank of "+i+" is:  "+Pagerank[i]);
    }
}