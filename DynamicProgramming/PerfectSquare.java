//leetcode 279

class Solution {
    public int numSquares(int n) {
        
        //min number square to make i
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++){
            dp[i] = i; // base case, make by ith 1
            for(int j=1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] +1);
            }
        }
        return dp[n];
    }
}
