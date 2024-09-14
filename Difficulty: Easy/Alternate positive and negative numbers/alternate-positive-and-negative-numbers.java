//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    void rearrange(ArrayList<Integer> arr) 
    {
        // code here

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int num : arr)
        {
           if(num >= 0)
           {
               positive.add(num);
           }
           else
           {
               negative.add(num);
           }
        }
        int i = 0, j = 0, k = 0;
        while (i < positive.size() && j < negative.size())
        {
            arr.set(k++, positive.get(i++));
            arr.set(k++, negative.get(j++));
        }
       
        
        while (i < positive.size())
        {
            arr.set(k++, positive.get(i++));
        }
        while (j < negative.size())
        {
            arr.set(k++, negative.get(j++));
        }
    }
}