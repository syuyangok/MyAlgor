package edu.gatech.dp;
//leetcode 322 coin change


public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(solution(arr, 4));
    }

    public static int solution(int[] coins, int amount){
        //int n = coins.length;

        int[] dp = new int[amount+1];

        //initial
        for(int i = 0; i<amount+1; i++) dp[i] = amount+1;

        //base case
        dp[0] = 0;

        /*
        //methods 1 loop coin for each amount
        for(int i=1; i<amount+1; i++){

            for(int coin: coins){
               // System.out.println("amount: "+ i+ " Coin:"+ coin + " DP[i]: " +dp[i]);
                //check not fit
                if(coin > i) continue;
                else dp[i] = Math.min(dp[i], dp[i-coin]+1);
                //System.out.println(dp[i]);
            }

        }
        */

        //methods 2. loop amount for each coin
        for(int coin : coins){

            for (int i = 0; i < amount+1; i++) {
                if(coin > i) continue;
                else dp[i] = Math.min(dp[i], dp[i-coin]+1);

            }


        }
        if(dp[amount] == amount+1) return -1;//no solution, dp keep initial value,
        else  return dp[amount];


    }
}
