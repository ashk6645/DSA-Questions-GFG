//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.duplicates(arr);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution 
{
    public static ArrayList<Integer> duplicates(int[] arr)
    {
        // code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();  //stores frequency of each element
        
        ArrayList<Integer> result = new ArrayList<>();  //Initialize the result list
        
        for(int num : arr) //Count the frequency of each element
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) //add duplicate elements
        {
            if(entry.getValue() > 1)
            {
                result.add(entry.getKey());
            }
        }
        
        if(result.isEmpty())  //if no duplicates
        {
            result.add(-1);
        }
        return result;
    }
}
