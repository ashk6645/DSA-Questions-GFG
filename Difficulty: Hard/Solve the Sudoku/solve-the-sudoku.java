//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        return solve(grid,0,0);
    }
     // Function to solve Sudoku using backtracking
    private static boolean solve(int[][] grid, int row, int col)
    {
        // If we reach the end of the row, move to the next row
        if (row == 9)
        {
            return true;
        }

        // If we reach the end of the column, move to the next column in the next row
        if (col == 9) 
        {
            return solve(grid, row + 1, 0);
        }

        // If the current cell is already filled, move to the next cell
        if (grid[row][col] != 0)
        {
            return solve(grid, row, col + 1);
        }

        // Try placing numbers 1-9 in the current cell
        for (int num = 1; num <= 9; num++)
        {
            if (isValidPlacement(grid, row, col, num))
            {
                grid[row][col] = num;

                // Move to the next cell
                if (solve(grid, row, col + 1)) 
                {
                    return true;
                }

                // Backtrack to the previous state if the solution is not found
                grid[row][col] = 0;
            }
        }

        // No valid solution found
        return false;
    }

    // Function to check if placing a number in a cell is valid
    private static boolean isValidPlacement(int[][] grid, int row, int col, int num)
    {
        // Check if the number is already in the same row or column
        for (int i = 0; i < 9; i++)
        {
            if (grid[row][i] == num || grid[i][col] == num) 
            {
                return false;
            }
        }

        // Check if the number is already in the 3x3 sub-box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[startRow + i][startCol + j] == num) 
                {
                    return false;
                }
            }
        }

        // Placement is valid
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
         for (int i = 0; i < 9; i++) 
         {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
          
        }
    }
}