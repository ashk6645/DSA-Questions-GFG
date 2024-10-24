//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        if (arr == null || arr.length <= 1) {
            ArrayList<Integer> result = new ArrayList<>();
            if (arr != null) {
                result.add(arr[0]);
            }
            return result;
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }
        
        // Step 1: Double numbers and replace next with 0
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i) != 0 && arrList.get(i).equals(arrList.get(i + 1))) {
                arrList.set(i, arrList.get(i) * 2);
                arrList.set(i + 1, 0);
            }
        }
        
        // Step 2: Create result ArrayList and add non-zero elements first
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arrList) {
            if (num != 0) {
                result.add(num);
            }
        }
        
        // Step 3: Add zeros at the end
        int zerosToAdd = arr.length - result.size();
        for (int i = 0; i < zerosToAdd; i++) {
            result.add(0);
        }
        return result;
    }
}
