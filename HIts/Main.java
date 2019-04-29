import java.util.Scanner;

public class Main
{
    public static void bubbleSort(double[] arr) 
    {  
        int n = arr.length;  
        double temp = 0;  
        for(int i=0; i < n; i++)
        {  
            for(int j=1; j < (n-i); j++)
            {  
                if(arr[j-1] > arr[j])
                {  
                    //swap elements  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }  
            }  
        }
    }
    public static void main(String[] args)
    {
        double[][] A, ATranspose;
        double[] U,V;          //U is hub weight vector V is Authority weight vector           
        int nodes, k, z = 1; 
        double U1 = 0, V1 = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of webpages: ");
        nodes = s.nextInt();
        A = new double[nodes][nodes];
        U = new double[nodes];
        V = new double[nodes];
        ATranspose = new double[nodes][nodes];
        System.out.println("Enter the path of one webpage to another webpage by using 1 for path and 0 for no path");
        for(int i=0; i<nodes; i++)
            for(int j=0; j<nodes; j++)
                A[i][j] = s.nextInt();      //taking input in matrix A
        System.out.println("Enter how many iteration do you want: ");
        k = s.nextInt();
        for(int i=0; i<nodes; i++)
            for(int j=0; j<nodes; j++)
                ATranspose[j][i] = A[i][j];  //transpose of A matrix
        for(int i=0; i<nodes; i++)
            U[i] = 1;                       //initialize U values as 1 only for first time
        for (int i = 0; i<nodes; i++)
        {
            for (int j = 0; j<nodes; j++)
            {
                V[i] = V[i] + ATranspose[i][j] * U[j];       //calculating V = ATranspose * U
            }
        }
        for(int i=0; i<nodes; i++)
            U[i] = 0;                           //emptying the U to fill the values
        for (int i = 0; i<nodes; i++)
        {
            for (int j = 0; j<nodes; j++)
            {
                U[i] = U[i] + A[i][j] * V[j];       //calculating U = A * V to get actuall U
            }
        }
        System.out.println("\nFor k = 1");
        for(int i = 0; i<nodes; i++)
        {
            System.out.println("Node "+i+" Hub = "+U[i]+" Authority = "+V[i]);    //listing the Hub and Authorithies for nodes For k=1
        }
        bubbleSort(U);
        bubbleSort(V);
        while(z!=k)
        {
            for(int i=0; i<nodes; i++)
            {
                V1 = V1 + V[i] * V[i];                  //v1 = v[0]^2 + v[1]^2 + .....
                U1 = U1 + U[i] * U[i];
            }
            for(int i=0; i<nodes; i++)
            {
                V[i] = V[i] / Math.sqrt(V1);        
                U[i] = U[i] / Math.sqrt(U1);
            }
            z++;
            System.out.println("\nFor k = "+z);
            for(int i = 0; i<nodes; i++)
            {
                System.out.println("Node "+i+" Hub = "+U[i]+" Authority = "+V[i]);    //listing the Hub and Authorithies for nodes For kth
            }
            bubbleSort(U);
            bubbleSort(V);
        }
        /*for(int i = 0; i<nodes; i++)
        {
            if(U[i] > V[i])
                System.out.println("Node "+i+" is Hub since "+U[i]+" > "+V[i]);
            else
                System.out.println("Node "+i+" is Authority since "+U[i]+" < "+V[i]);
        }*/
    }
}