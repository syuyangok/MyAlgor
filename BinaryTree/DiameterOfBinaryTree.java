package com.yuyang.leetcode;

//leetcode 543
//calculate max diameter of a tree
public class DiameterOfBinaryTree {
    int maxDiameter = 0;

    //calculate each subtree max diameter
    //for each tree, maxDiameter = leftMaxDeep + rightMaxDeep
    //compare with root max diameter
    public int solution(TreeNode root){
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftDeep = maxDepth(root.left);
        int rightDeep = maxDepth(root.right);

        //calculate diameter for each subtree
        maxDiameter = Math.max(maxDiameter, leftDeep + rightDeep);
        return Math.max(leftDeep, rightDeep) + 1;//calculate max deepth

    }
}
