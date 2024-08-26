//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public int wildCard(String pattern, String str) 
    {
        // Your code goes here
        int m = pattern.length();
        int n = str.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
         for (int i = 1; i <= m; i++) 
         {
            if (pattern.charAt(i - 1) == '*') 
            {
                dp[i][0] = dp[i - 1][0];
            }
            else
            {
                dp[i][0] = false;
            }
         }
         for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(i - 1) == '*') {
                    // '*' can match with empty sequence or any sequence
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pattern.charAt(i - 1) == '?' || pattern.charAt(i - 1) == str.charAt(j - 1)) {
                    // '?' can match any single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n] ? 1 : 0;
        
    }
}
