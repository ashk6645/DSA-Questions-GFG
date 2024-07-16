//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public String printString(String s, char ch, int count) 
    {
        // code here
         int occurrence = 0;
        int index = -1;
        
        // Traverse the string to find the nth occurrence of the character ch
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.charAt(i) == ch) 
            {
                occurrence++;
                if (occurrence == count) 
                {
                    index = i;
                    break;
                }
            }
        }

        // Check if the nth occurrence was found and return the substring
        if (index != -1 && index + 1 < s.length()) 
        {
            return s.substring(index + 1);
        } 
        else 
        {
            return "";
        }
 }
}