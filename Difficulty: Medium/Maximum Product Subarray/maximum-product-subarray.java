//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        if(arr == null | arr.length == 0){
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        int maxProduct = arr[0];
        
        for(int i=1; i<arr.length; i++){
            int num = arr[i];
            
            if(num < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(num, max*num);
            min = Math.min(num, min*num);
            
            maxProduct = Math.max(maxProduct, max);
        }
        
        return maxProduct;
    }
}