//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int lps(String str) 
    {
        // code here
        int n = str.length();
        int[] suff = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++)
        {
            while (j > 0 && str.charAt(i) != str.charAt(j))
            {
             j = suff[j - 1];
            }
            if (str.charAt(i) == str.charAt(j))
            {
             j++;
            }
            suff[i] = j;
        }
       return suff[n - 1];
    }
    
}