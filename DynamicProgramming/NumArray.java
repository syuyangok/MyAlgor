package com.yuyang.leetcode.dynamic;

/**
 * @auther Yuyang Sun
 * @date 4/6/2022
 */
//leetcode 303. Range Sum Query - Immutable
class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];//base case

        for (int i = 1; i <= nums.length-1 ; i++) {
            dp[i] = dp[i-1] + nums[i];//get pre sum
        }

    }

    public int sumRange(int left, int right) {
        int result = 0;
        if (left <= 0) result = dp[right];
        else result = dp[right] - dp[left-1];
        return result;
    }
}