package com.yuyang.leetcode.array;

/**
 * @auther Yuyang Sun
 * @date 4/12/2022
 */
//leetcode 494. Target Sum
// backtrack or dp
public class TargetSum {

    //backtrack
    int result = 0;
    int t;
    public int findTargetSumWays(int[] nums, int target) {
        //safe check
        if(nums.length == 0) return 0;
        t = target;
        backtrack(nums, 0, 0);
        return result;
    }

    private void backtrack(int[] nums, int i, int sum) {
        //base case, if i is last item +1
        if(i == nums.length){
            if(sum == t) {
                result ++; // find sum == target;
            }
            return;
        }

        //options + nums[i], or - nums[i]
        sum = sum + nums[i];
        backtrack(nums, i+1, sum);
        //retrive choose
        sum = sum - nums[i];

        //options + nums[i], or - nums[i]
        sum = sum - nums[i];
        backtrack(nums, i+1, sum);
        //retrive choose
        sum = sum + nums[i];

    }

}
