package com.yuyang.leetcode;
//solution for print tree level and count tree nodes
public class TreeNodeLevel {

    //print tree level of each node.
    public void printTreeLevel(TreeNode root, int level){
        if (root == null) {
            return;
        }
        System.out.println("Node at level: " + level);
        printTreeLevel(root.left, level+1);
        printTreeLevel(root.right, level+1);
    }

    //count nodes for each tree
    public int countNode(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftCount = countNode(root.left);
        int rightCount = countNode(root.right);
        return leftCount + rightCount + 1;//后序位置，可以返回值给parent

    }
}








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
}
