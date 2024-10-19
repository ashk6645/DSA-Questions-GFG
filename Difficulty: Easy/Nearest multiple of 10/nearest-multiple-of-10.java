//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
         String ans="0";
        int a=str.charAt(str.length()-1)-'0';
        if(a<=5) return str.substring(0,str.length()-1)+"0";
        else{
            int carry=1;
            for(int i=str.length()-2;i>=0;i--){
                if(str.charAt(i)=='9') ans="0"+ans;
                else {
                    ans=""+((str.charAt(i)-'0')+1)+ans;
                    return str.substring(0,i)+ans;
                    
                }
            }
        }
        return "1"+ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends