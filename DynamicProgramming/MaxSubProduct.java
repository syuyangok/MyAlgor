//leetcode, 152
//dp, add one more dimention as status[][0/1]

class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][2];// 0/1 min value, max value
        
        //base case
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        
        for(int i =1; i<n; i++){
            if(nums[i] > 0){
                
                dp[i][0] = Math.min(dp[i-1][0]*nums[i], nums[i]);
                //max value depend on i-1[1] +/-
                dp[i][1] = Math.max(dp[i-1][1]*nums[i], nums[i]);
                             
            }
            else{
                dp[i][0] = Math.min(dp[i-1][1]*nums[i], nums[i]);
                //nums[i] is negative, so min[i-1] x negative, get max value
                dp[i][1] = Math.max(dp[i-1][0]*nums[i], nums[i]); 
            }
            if(dp[i][1] > max) max = dp[i][1];
        }
        
        
        return max;
        
    }
}
