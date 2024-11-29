//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        s1 = s1.replaceFirst("^0+(?!$)", "");
        s2 = s2.replaceFirst("^0+(?!$)", ""); 
        // Perform binary addition 
        int maxLength = Math.max(s1.length(), s2.length()); 
        StringBuilder result = new StringBuilder(); 
        int carry = 0; 
        for (int i = 0; i < maxLength; i++) 
        {
            int bit1 = i < s1.length() ? s1.charAt(s1.length() - 1 - i) - '0' : 0; 
            int bit2 = i < s2.length() ? s2.charAt(s2.length() - 1 - i) - '0' : 0; 
            int sum = bit1 + bit2 + carry; 
            result.insert(0, sum % 2); carry = sum / 2; 
            
        } if (carry != 0) { result.insert(0, carry); 
            
        } 
        // Remove leading zeros from the result 
        String resultString = result.toString(); 
        return resultString.replaceFirst("^0+(?!$)", "");
    }
}