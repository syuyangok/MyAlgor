package com.yuyang.leetcode.tree;

//leetcode 226 invert a binary tree.
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        switchTree(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public void switchTree(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
