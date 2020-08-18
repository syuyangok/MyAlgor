package edu.gatech.dp;

//leetcode 121
//Say you have an array for which the ith element is the price of a given stock on day i.
//design an algorithm to find the maximum profit.
//k=1

public class BestBuySell {

    public static void main(String args[]){

        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices){

        int n = prices.length;
        //0 is don't have any stock in hand
        //1 has stock in hand;
        if(n<=0) return 0; //valid input

        int[][] dp = new int[n][2];//max profit for every day

        //base case
        dp[0][0] = 0; //first day no profit
        dp[0][1] = -prices[0]; // no possible for first day to have stock

        for(int i=1; i<n; i++){

            // no stock in hand
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            //has stock in hand
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);

        }
        return dp[n-1][0];




    }
}
