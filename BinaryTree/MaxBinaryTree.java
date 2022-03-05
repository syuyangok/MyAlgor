package com.yuyang.tree;

/**
 * @author : Yuyang Sun
 * @date: 3/5/2022, Sat
 **/

public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int lo, int hi) {
        //base case
        if (lo > hi) return null;

        //find max value in nums
        int maxIndex = -1, maxValue = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++){
            if (nums[i] > maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        //set maxValue as root
        TreeNode root = new TreeNode(maxValue);
        //set children
        root.left = build(nums, lo, maxIndex-1);
        root.right = build(nums, maxIndex+1, hi);

        return root;
    }
}
