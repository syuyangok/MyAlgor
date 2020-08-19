package edu.gatech.dp;

//leetcode 198
//Given a list of non-negative integers representing the amount of money of each house,
// determine the maximum amount of money you can rob tonight without alerting the police.

public class HouseRobber {

    public static void main(String[] args) {

        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums){

        int n = nums.length;
        //valid input
        if(n <=0) return 0;
        if(n==1) return nums[0];

        int[] dp = new int[n];

        //base case
        dp[0] = nums[0];
        if(nums[1]> nums[0]) dp[1] = nums[1];
        else dp[1] = nums[0];

        for (int i = 2; i < n; i++) {
            //two case, rob or not rob
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);

        }

        return dp[n-1];

    }
}
