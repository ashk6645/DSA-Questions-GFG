//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> uniquePerms = new HashSet<>();
        char[] chars = s.toCharArray();
        generatePermutations(chars, 0, uniquePerms);
        ArrayList<String> result = new ArrayList<>(uniquePerms);
        Collections.sort(result);
        return result;
    }
    
    private void generatePermutations(char[] chars, int index, HashSet<String> uniquePerms) {
        
        if (index == chars.length) {
            uniquePerms.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutations(chars, index + 1, uniquePerms);
            swap(chars, index, i);
        }
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
      
    }
}