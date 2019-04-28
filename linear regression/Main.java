import java.util.Scanner;
import java.lang.Math;

public class Main
{
    public static void main (String[] args) 
    {
        int len, summx = 0, summy = 0;   
        float mx, my, sumxixbar2 = 0, sumxixbarXyiybar = 0, mxixbar2, mxixbarXyiybar, b0, b1, predicty, givenx;   //mx and my is mean of x and y respectively
        int[] x, y;
        float[] xixbar, yiybar, xixbar2, xixbarXyiybar;
        Scanner s=new Scanner(System.in);
        System.out.println("How many elements do you have to enter for X and Y: ");
        len = s.nextInt();
        x = new int[len];
        y = new int[len];
        xixbar = new float[len];
        yiybar = new float[len];
        xixbar2 = new float[len];
        xixbarXyiybar = new float[len];
        System.out.println("Enter the values of X:");
        for(int i = 0; i<len; i++)
        {
            x[i] = s.nextInt();
            summx = summx + x[i];           //sum of x
        }
        System.out.println("Enter the values of Y:");
        for(int i = 0; i<len; i++)
        {
            y[i] = s.nextInt();
            summy = summy + y[i];           //sum of y
        }
        mx = (float)summx/len;               //mean of x
        my = (float)summy/len;               //mean of y
        System.out.println("summx = "+summx+" summy = "+summy);
        System.out.println("mean x = "+mx+" mean y = "+my);
        for(int i = 0; i<len; i++)
        {
            xixbar[i] = x[i] - mx;
            yiybar[i] = y[i] - my;
        }
        for(int i = 0; i<len; i++)
        {
            xixbar2[i] = xixbar[i] * xixbar[i];
            sumxixbar2 = sumxixbar2 + xixbar2[i];       //sum of xi-xbar ka square
        }
        mxixbar2 = (float)sumxixbar2/len;        //mean of xi-xbar ka square
        for(int i = 0; i<len; i++)
        {  
            xixbarXyiybar[i] = xixbar[i] * yiybar[i];
            sumxixbarXyiybar = sumxixbarXyiybar + xixbarXyiybar[i];
        }
        mxixbarXyiybar = (float)sumxixbarXyiybar/len;
        b1 = mxixbarXyiybar/mxixbar2;
        b0 = my - (b1 * mx);
        System.out.println("b1 = "+b1+" b0 = "+b0);
        System.out.println("Enter the value of X to predict Y");
        givenx = s.nextInt();
        predicty = b0 + (b1 * givenx);
        System.out.println("The predicted value of Y is " + predicty);
    }
}