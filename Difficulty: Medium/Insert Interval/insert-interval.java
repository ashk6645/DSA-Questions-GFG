//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        while(i < n){
            int end = arr[i][1];
            j = i+1;
            while(j < n && arr[j][0] <= end){
                end = Math.max(end, arr[j][1]);
                j++;
            }
            ans.add(new int[]{arr[i][0], end});
            i = j;
        }
        return ans;
    }
    
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
         int n = intervals.length;
         int[][] arr = new int[n+1][2];
         int j = 0;
         for(int i = 0; i < n; i++,j++){
             if((i == j) && intervals[i][0] >= newInterval[0]){
                 arr[j] = newInterval;
                 j++;
                 arr[j] = intervals[i];
             }
             else {
                 arr[j] = intervals[i];
             }
         }
         
         if(j < n+1){
             arr[j] = newInterval;
             j++;
         }
         
         return mergeOverlap(arr);
    }
}
