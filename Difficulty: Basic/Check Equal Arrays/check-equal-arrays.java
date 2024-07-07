//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] arr1 = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                arr1[i] = Integer.parseInt(numsStr1[i]);
            }

            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] arr2 = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                arr2[i] = Integer.parseInt(numsStr2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.check(arr1, arr2) ? "true" : "false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to check if two arrays are equal or not.
    public static boolean check(int[] arr1, int[] arr2) {
        // Your code here
   HashMap<Long, Integer> map = new HashMap<>();

    // Increment the count for each element in arr1
    for (long a : arr1)
    {
        map.put(a, map.getOrDefault(a, 0) + 1);
    }

    // Decrement the count for each element in arr2
    for (long b : arr2)
    {
        if (!map.containsKey(b)) 
        {
            return false;
        }
        map.put(b, map.get(b) - 1);
    }

    // Check if all counts are zero
    for (int count : map.values())
    {
        if (count != 0)
        {
            return false;
        }
    }

    return true;
    }
}