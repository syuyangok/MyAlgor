package edu.gatech.dp;

//leetcode 64, dp
//Given a m x n grid filled with non-negative numbers,
// find a path from top left to bottom right
// which minimizes the sum of all numbers along its path.

public class MinimumPathSum {

    public static int solution(int[][] grid){

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        //init base case
        dp[0][0] = grid[0][0];
        for(int r = 1; r< row; r++) dp[r][0] = dp[r-1][0] + grid[r][0];
        for(int c = 1; c< col; c++) dp[0][c] = dp[0][c-1] + grid[0][c];

        for(int r = 1; r< row; r++) {

            for(int c = 1; c< col; c++){
                dp[r][c] = Math.min(dp[r][c-1], dp[r-1][c]) + grid[r][c];
            }
        }
        return dp[row-1][col-1];
    }
    
    
    public static void main(String[] args) {
        int[][] arrays = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(solution(arrays));
    }
}
