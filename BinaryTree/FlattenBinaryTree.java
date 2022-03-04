package com.yuyang.leetcode.tree;
//leetcode 114
//flatten binary tree
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        //base case
        if (root == null) return;

        //flatten left and right child
        flatten(root.left);
        flatten(root.right);

        //temp to store left right child
        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;

        //connect flatted child to root
        root.left = null;
        root.right = leftTemp; // connect original left to root right
        TreeNode p = root;
        while (p.right != null){
            p = p.right; // loop find new right end node
        }
        //connect old right to new right end
        p.right = rightTemp;



    }
}
