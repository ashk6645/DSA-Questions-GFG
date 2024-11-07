//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        int n = arr.length;
        if(n < 3)
        {
            return Arrays.asList(-1,-1);
        }
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        long totalSum = prefixSum[n];
        if (totalSum % 3 != 0) {
            return Arrays.asList(-1, -1);
        }
        
        long targetSum = totalSum / 3;
        for (int i = 0; i < n - 2; i++) {
            long firstPartSum = prefixSum[i + 1] - prefixSum[0];
            if (firstPartSum != targetSum) continue;
            for (int j = i + 1; j < n - 1; j++) {
                long secondPartSum = prefixSum[j + 1] - prefixSum[i + 1];
                long thirdPartSum = prefixSum[n] - prefixSum[j + 1];
                
                if (secondPartSum == targetSum && thirdPartSum == targetSum) {
                    return Arrays.asList(i, j);
                }
        if (secondPartSum > targetSum) break;
            }
        }
        
        return Arrays.asList(-1, -1);
    }
}