//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Your code here
         for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); 
        int maxLength = 0;
        int prefixSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSumMap.containsKey(prefixSum)) {
                int length = i - prefixSumMap.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}
