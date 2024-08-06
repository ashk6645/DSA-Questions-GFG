//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{

    public boolean isValid(String str) 
    {
        // Write your code here
         int len=str.length();
        String arr[]=str.split("\\.");
        
        
        if(arr.length!=4) {
            return false;
            
        }
        else {
            for(int j=0; j<4; j++) {
                //int temp=Integer.valueOf(arr[j]);
                
                //checking the condition for empty string in inputs like "211..212.22"
                if(arr[j].isEmpty()) {return false;}
                
                //condition to check preceding zeroes;
                else if(Integer.valueOf(arr[j])> 0 && arr[j].charAt(0) == '0') { return false;}
                
                //condition for checking range(0-255) both inclusive
                else if ( Integer.valueOf(arr[j]) <0 || Integer.valueOf(arr[j])>255) { return false;}
                
                else { continue;}
                
            }
        }
        return true;
    }
}