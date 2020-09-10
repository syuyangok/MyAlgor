//leet code 518
// ask how many ways to combine the amount
//it's not same with "climb stairs" problem.
// 1,2 and 2,1 are same here, however, it is not same in "climb stairs" problem.
//

class Solution {
    public int change(int amount, int[] coins) {
        
       // int n = coins.length;
        
        
        // ways to make i amount 
        int[] dp = new int[amount+1];
        
        // base case
        dp[0] = 1;
        
        for(int coin: coins){
            
            for(int i =1; i<=amount; i++){
                if(coin<=i){
                //if use current coin, old dp[i] ways, add ways use current coin. 
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }


        return dp[amount];
    }
}
