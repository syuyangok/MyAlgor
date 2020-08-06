//Number of Sub-arrays With Odd Sum
//leetcode 1524
class NumOfSubarrays {
    public int solution(int[] arr) {
        int n =arr.length;
        int[][] dp = new int[n][2];
        
        final int MOD = 1000_000_007;
        
        
        //base condition
        if(arr[0]%2 ==0){
            dp[0][0] = 1; // number sub sum with even, and end with current i;
            dp[0][1] = 0; //number sub sum with odd, and end with current i;
        }
        else{
            dp[0][0] = 0; // 
            dp[0][1] = 1; //
        }
        int result = dp[0][1];
        for(int i =1; i<n; i++){
            
            
            if(arr[i]%2==0){
                //current i is even, no change odd, even
                dp[i][0] =  dp[i-1][0]+1; //plus single i
                dp[i][1] = dp[i-1][1]; 
            }
            else{
                //current i is odd, change odd, even
                dp[i][0] = dp[i-1][1] ; 
                dp[i][1] = dp[i-1][0]+1; 
            }      
            result += dp[i][1]; //sum all the dp[][1], to get result
            result = result%MOD;

        }
        return result;       
        
    }
}
