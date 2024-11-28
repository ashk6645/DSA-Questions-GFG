//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Your code here
        int i=0, n=s.length(), max=(1<<31)-1, min=(1<<31), ans=0;
        boolean pos=true;
        
        while(i<n && s.charAt(i)==' ')  i++;
        
        if(s.charAt(i)=='-'){
            pos=false;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        
        while(i<n && s.charAt(i)=='0')  i++;
        
        if(i==n)    return 0;
        
        while(i<n && Character.isDigit(s.charAt(i))){
            
            int cur = s.charAt(i)-'0';
            
            //check if new_no is out_of_bound
            long val = (ans*10l)+cur;
            if(!pos)    val=-val;
            if(val>max) return max;
            if(val<min) return min;
            
            ans = ans*10 + cur;
            
            i++;
        }
        
        return pos ? ans : -ans;
    }
}