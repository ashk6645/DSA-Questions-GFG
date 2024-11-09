//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
         Arrays.sort(arr);
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                s1.append(arr[i]);
            } else {
                s2.append(arr[i]);
            }
        }
        // Add these two strings (s1 and s2)
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        sb.reverse(); //after adding  reverse the stringbuilder
        // remove initial zeros from stringbuilder 
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // return the string by converting StringBuilder to String 
        return sb.toString();
    }
}
