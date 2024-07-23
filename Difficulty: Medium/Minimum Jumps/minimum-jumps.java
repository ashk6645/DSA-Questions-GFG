//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr, size));
        }
    }
}

// } Driver Code Ends


class Solution 
{
    static int minJumps(int[] arr, int n) 
    {
        // your code here
          if(arr.length==1)
          {
            return 0;
        }
        if(arr[0]==0)
        {
            return -1;
        }
        int ladder=arr[0];
        int stairs=arr[0];
        int jump=1;
        for(int i=1;i<n;i++)
        {
            if(i==n-1)
            {
                return jump;
            }
            if(i+arr[i]>ladder)
            {
                ladder=i+arr[i];
            }
            stairs--;
            if(stairs==0)
            {
                jump++;
                if(ladder<=i)
                {
                    return -1;
                }
                stairs=ladder-i;
            }
        }
        return jump;
    }
}