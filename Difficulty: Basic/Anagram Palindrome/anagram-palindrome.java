//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        int len = S.length();
        int mid = len/2;
        String s1 = "";
        String s2 = "";
        if(len % 2==0)
        {
            s1 = S.substring(0,mid);
            s2 = S.substring(mid,len);
        }
        else
        {
            s1 = S.substring(0,mid);
            s2 = S.substring(mid+1, len);
        }
        if(s1.equals(s2))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}