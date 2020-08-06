package edu.gatech.dp;
//Longest Subarray of 1's After Deleting One Element
//leetcode 1493
public class LS {


    public static void main(String[] args) {

        int[] a = {1,1,0,1};
        System.out.println(solution(a));
    }

    public static int solution(int[] nums){

        int n = nums.length;
        //create a dp to record. with two status
        int[][] dp = new int[n][2];

        //dp[][0]   continue ..1111...without any 0;
        //dp[][1]   continue ..1111...with only one 0;

        dp[0][0] = nums[0];
        dp[0][1] = 1;

        int result = 0;

        for(int i =1; i<n; i++){

            //if item is 1, append to end
            if (nums[i] == 1){
                dp[i][0] = dp[i-1][0] +1;
                dp[i][1] = dp[i-1][1] +1;
            }
            else{
                dp[i][0] = 0;//append 0, not quality def, so reset to 0;
                dp[i][1] = dp[i-1][0] +1;//append 0, check previous 1 and append
            }

            //find max
            if(dp[i][0] > result) result = dp[i][0];
            if(dp[i][1] > result) result = dp[i][1];

        }
        return result-1; //be careful, need delete 1, before return.
    }
}
