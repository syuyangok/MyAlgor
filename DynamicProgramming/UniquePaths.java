package edu.gatech.dp;
//leetcode 62; dp
//A robot is located at the top-left corner of a m x n grid
//The robot can only move either down or right at any point in time.
//How many possible unique paths to right bottom
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        //create a 2d array to keep result
        int[][] dp = new int[n][m];

        //init dp, right coner, last item is dp[m-1][n-1]
        for(int i=0; i<=n-1; i++) dp[i][0]=1;
        for(int j=1; j<=m-1; j++) dp[0][j]=1;

        //dp
        for(int i=1; i<=n-1; i++){
            for(int j=0; j<=m-1; j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[n-1][m-1];

    }
}
