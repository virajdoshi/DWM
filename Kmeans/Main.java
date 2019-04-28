import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Main
{
	public static int getRandom(int[] array)           //Random Mean generator from an given array or dataset
	{
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
	}
	public static void main(String[] args) 
	{
		int len, m1, m2, temp1, temp2, Oldm1 = 0, Oldm2 = 0 , k = 0, j = 0, summ1 = 0, summ2 = 0;
		int[] dataset, c1, c2;
		Scanner s = new Scanner(System.in);
		System.out.println("How many Elements do you want to enter: ");
		len = s.nextInt();
		dataset = new int[len];
		c1 = new int[len];
		c2 = new int[len];
		System.out.println("Enter the Elements in dataset: ");
		for(int i=0; i<len; i++)
		{
			dataset[i] = s.nextInt();
		}
		m1 = getRandom(dataset);                  //mean 1 is generated
		m2 = getRandom(dataset);                  //mean 2 is generated
		if(m1 == m2)                            //if my mean 1 and mean 2 is same
		{
		    m2 = getRandom(dataset);    
		}
		else if(m1 > m2)                        //if my mean 1 is greater than mean 2
		{
		    int a = m1;
		    m1 = m2;
		    m2 = a;
		}
		System.out.println("m1 = " + m1 + " " +" m2 = " + m2);
		do
		{
    	    for(int i=0; i<len; i++)                //calculated clusters on random mean only for 1st time
    		{
    			temp1 = Math.abs(m1-dataset[i]);
    			temp2 = Math.abs(m2-dataset[i]);
    			if(temp1 <= temp2)
    			{
    				c1[i] = dataset[i];
    				k++;
    			}
    			else
    			{
    				c2[i] = dataset[i];
    				j++;
    			}
    		}
    		System.out.print("\nc1 = ");                        //printing centroid 1
    		for(int i=0; i<len; i++)
    		{
    		    System.out.print(c1[i]+ " ");
    		}
    		System.out.print("\nc2 = ");                        //printing centroid 2
    		for(int i=0; i<len; i++)
    		{
    		    System.out.print(c2[i]+ " ");
    		}
    		Oldm1 = m1;
    		Oldm2 = m2;
    		for(int i=0; i<len; i++)                //filling null 
    		{
    		    summ1 = summ1 + c1[i];
    		    summ2 = summ2 + c2[i];
    		}
    		m1 = (summ1/k);                         //mean of centroid 1
    		m2 = (summ2/j);                       //mean of centroid 2
    		System.out.println("\n\nm1 = " + m1 + " " +" m2 = " + m2);
    		for(int i=0; i<len; i++)                //calculated mean for clusters 1 and 2
    		{
    		    c1[i]=0;
    		    c2[i]=0;
    		}
    		k = 0;                      //reset counts
    		j = 0;                      //reset counts
    		summ1 = summ2 = 0;          //reset counts
		}while(Oldm1!=m1 && Oldm2!=m2);
	}
}
