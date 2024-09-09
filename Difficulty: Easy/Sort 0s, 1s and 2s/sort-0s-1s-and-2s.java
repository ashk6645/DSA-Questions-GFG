//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution 
{
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) 
    {
        // code here
        int low = 0;
        int mid = 0;
        int high = arr.size()-1;
        int temp = 0;
        while(mid<=high)
        {
            switch(arr.get(mid))
            {
                case 0:
                    temp = arr.get(low);
                    arr.set(low, arr.get(mid));
                    arr.set(mid, temp);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr.get(mid);
                    arr.set(mid, arr.get(high));
                    arr.set(high, temp);
                    high--;
                    break;
            }
        }
    }
}