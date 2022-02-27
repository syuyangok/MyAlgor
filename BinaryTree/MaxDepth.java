package com.yuyang;

/**
 * @author : Yuyang Sun
 * @date: 2/27/2022, Sun
 **/
//leetcode 104, find max deepth of a binary tree.
public class MaxDepth {

//      Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result = 0;
    int deepth = 0;
    //traverse every node, and when reach leaves, record max deepth.
    public int max(TreeNode root) {

        traverse(root);
        return result;
    }

    public void traverse(TreeNode root){
        if (root == null){
            result = Math.max(result, deepth);
            return;
        }
        deepth++; //enter a new child node, deepth +1;
        traverse(root.left);
        traverse(root.right);
        deepth--; //back to up node, deepth -1;
    }

    //better method
    //recursive, calculate tree deepth by calculate child deepth, then +1
    public int solution2(TreeNode root){
        if (root == null) return 0;
        int leftMax = solution2(root.left);
        int rightMax = solution2(root.right);
        return Math.max(leftMax, rightMax) +1;
    }
}
