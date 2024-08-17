//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public static long[] productExceptSelf(int nums[])
    {
        // code here
       long[] arr1=new long[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            long num=1;
            for(int j=0;j<nums.length;j++)
            {
                if(j==i)continue;
                
                num=num*nums[j];
                
                
            }
            arr1[i]=num;
        }
        return arr1;
    }
}
