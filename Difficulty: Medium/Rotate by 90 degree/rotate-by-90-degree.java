//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int matrix[][]) {
        // Code Here
        for(int i=0, k=matrix.length; i<k/2; i++) {
            for(int j=i; j<k-i-1; j++) { 
                int elem = matrix[i][j];
                matrix[i][j] = matrix[k-1-j][i];
                matrix[k-1-j][i] = matrix[k-1-i][k-1-j];
                matrix[k-1-i][k-1-j] = matrix[j][k-1-i];
                matrix[j][k-1-i] = elem; 
            }
        }
    }
}