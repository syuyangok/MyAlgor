//leetcode 343


class Solution {
    public int integerBreak(int n) {
        
        int[] dp = new int[n+1];
        //dp[0] = 1;
        dp[1] =0;//1 can not break to two positive int
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                //break i to two parts, j and i-j;
                dp[i] = Math.max(dp[i], Math.max(j*dp[i-j], j*(i-j)));
            }
                
            
        }
        
        return dp[n];
        
    }
}
