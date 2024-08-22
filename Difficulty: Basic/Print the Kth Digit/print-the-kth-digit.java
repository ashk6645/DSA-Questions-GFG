//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0)
        {
            int A = in.nextInt();
            int B = in.nextInt();
            int K = in.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.kthDigit(A,B,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long kthDigit(int A,int B,int K)
    {
        // code here
        double x = Math.pow(A,B);
        String result = String.valueOf((long)x);
        if(K>result.length())
        {
            return -1;
        }
        char Kth = result.charAt(result.length() - K);
        return Character.getNumericValue(Kth);
        
    }
}