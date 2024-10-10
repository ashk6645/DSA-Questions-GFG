//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int maxDistance(int[] arr) 
    {
        // Code here
        int maxdist=0,n=arr.length;
        int l=0,r=n-1;
        while(l<n && (l+maxdist)<n)
        {
            r=n-1;
            while(r>(l+maxdist) && arr[l]!=arr[r])
            r--;
            if(r>=0)
            maxdist=Math.max(maxdist,r-l);
            l++;
        }
        return maxdist;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends