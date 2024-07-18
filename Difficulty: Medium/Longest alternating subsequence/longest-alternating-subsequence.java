//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution
{
    public int alternatingMaxLength(int[] arr) 
    {
        // code here
        if(arr.length == 0)
        {
            return 0;
        }
        if(arr.length == 1)
        {
            return 1;
        }
        int inc = 1;
        int dec = 1;
        for(int i=1;i<arr.length;i++)
        {
            if (arr[i] > arr[i - 1])
            {
                inc = dec + 1; // Current number continues the increasing sequence
            }
            else if (arr[i] < arr[i - 1]) 
            {
                dec = inc + 1; // Current number continues the decreasing sequence
            }
        
        }
         return Math.max(inc, dec);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends