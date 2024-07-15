//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int editDistance(String s, String t) 
    {
        // Code here
         int m = s.length();
        int n = t.length();
        
        // Create a DP array to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j; // Min operations = j (all insertions)
                }
                // If second string is empty, only option is to remove all characters of first string
                else if (j == 0) {
                    dp[i][j] = i; // Min operations = i (all deletions)
                }
                // If last characters are the same, ignore last char and recur for remaining string
                else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If last character is different, consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                            Math.min(dp[i - 1][j], // Remove
                                                     dp[i][j - 1])); // Insert
                }
            }
        }
        
        return dp[m][n];
    }
}