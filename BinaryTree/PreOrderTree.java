package com.yuyang.leetcode.tree;

import java.util.ArrayList;
import java.util.List;


//leetcode 144 bianry tree preorder travel
public class PreOrderTree {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        travers(root);
        return list;
    }

    public void travers(TreeNode root){
        if (root == null){
            return;
        }
        list.add(root.val);
        travers(root.left);
        travers(root.right);
    }


}
