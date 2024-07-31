//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public String longestCommonPrefix(String arr[])
    {
        // code here
        if(arr.length==1){
            return arr[0];
        }
        int minLength = Integer.MAX_VALUE;
        int minLengthIndex = -1;
        for(int i=0;i<arr.length;i++){
         if(minLength>arr[i].length()){
             minLengthIndex = i;
             minLength = arr[i].length();
         }
    }
     String commonPrefix = "";
        
     
        
        for(int i=0;i<arr.length;i++){
            
            String temp = "";
            if(i!=minLengthIndex){
                for(int j=minLength;j>0;j--){
                
                if(arr[minLengthIndex].substring(0,j).equals(arr[i].substring(0,j))){
                     
                    temp = arr[i].substring(0,j);
                   
                    break;
                }
                }
                   
                
                if(temp.length()==0){
                    commonPrefix="-1";
                    break;
                }
                else {
                    commonPrefix = temp;
                }
            }
        }
        
        
        return commonPrefix;
}
}
