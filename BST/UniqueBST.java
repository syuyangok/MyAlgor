package com.yuyang.leetcode.BStree;

/**
 * @auther Yuyang Sun
 * @date 3/10/2022
 */
public class UniqueBST {
    int[][] memo;//memo to reduce repeated calculate.
    public int numTrees(int n) {
        int result = count(1, n);
        memo = new int[n+1][n+1];//memo initial to 0.
        return result;
    }

    private int count(int lo, int hi) {
        //if root is null, it also is a situation
        if (lo > hi ){
            return 1;
        }

        //check memo, if already have result, return
        if (memo[lo][hi] != 0){
            return memo[lo][hi];
        }
        int res = 0;
        //loop every i is root
        for (int i = lo; i <= hi; i++) {
            int left = count(lo, i - 1);//number of left child combination
            int right = count(i+1, hi);//number of right child combination
            res += left*right; // i root tree number, is left * right
        }
        return  res;
    }


    //methods use dp
    public int numTreesDP(int n) {
        int[] dp = new int[n+1];
        //base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            //j is the root, i is n
            for (int j = 1; j<=i; j++ ){
                dp[i] = dp[i] + dp[j-1] * dp[i-j]; //left child * right child
            }
        }

        return dp[n];
    }
}
