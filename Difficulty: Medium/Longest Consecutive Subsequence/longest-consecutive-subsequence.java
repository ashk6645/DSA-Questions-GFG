//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
           if (arr == null || arr.length == 0) return 0;
    
    Set<Integer> numSet = new HashSet<>();
    for (int num : arr) {
        numSet.add(num);
    }
    
    int maxLength = 1;
    
    for (int num : numSet) {
    
        if (!numSet.contains(num - 1)) {
            int currentNum = num;
            int currentLength = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
    }
    
    return maxLength;
    }
}