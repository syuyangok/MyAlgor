package com.yuyang.leetcode.BStree;

/**
 * @auther Yuyang Sun
 * @date 3/9/2022
 */
//leetcode 230
public class KthSmallestTree {

    int result  = 0, rank = 0;
    //inorder traverse tree, if rank == k, find the root value.
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null){
            return;
        }
        //inorder traverse the tree
        traverse(root.left, k);
        rank ++;//key point!!!!!!!!!!!!!!!!!!!
        if (rank == k){
            result = root.val;
            return;//already find result, return.
        }
        traverse(root.right, k);
    }


}
