package com.yuyang.leetcode;

//Given a list of n positive integers A = [a1; :::; an],
// we are looking for the largest neighboring-product sum.
public class MaxProductSum {

    public static int solution(int[] a){

        int n = a.length;
        int[] dp  = new int[n+1];

        dp[0] = 0;
        dp[1] = a[0];

        for (int i = 2; i <= n ; i++) {
            //i in dp, is i-1 in a;
            dp[i] = dp[i-2] + a[i-1]*a[i-2];
            if (dp[i] < dp[i-1] + a[i-1]){
                dp[i] = dp[i-1] + a[i-1];
            }
            //System.out.println("i is " + i + "  and dp: " + dp[i]);
        }
        return dp[n];
    }
}
