//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
// User function Template for Java

/*
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

Java users need to return result in Pair class
For Example -> return new Pair(minimum,maximum)
*/

class Solution 
{
    public Pair<Long, Long> getMinMax(int[] arr)
    {
        // Code Here
        Long max = Long.MIN_VALUE;
        Long min = Long.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min = (long)arr[i];
            }
            if(max<arr[i])
            {
                max = (long)arr[i];
            }
        }
        Pair array = new Pair(min,max);
        return array;
    }
}


//{ Driver Code Starts.

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }

    public V getValue() { return value; }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution ob = new Solution();
            Pair<Long, Long> pp = ob.getMinMax(arr);
            System.out.println(pp.getKey() + " " + pp.getValue());
        }
    }
}

// } Driver Code Ends