package com.yuyang.leetcode.tree;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 3/8/2022
 */

//leetcode 652. Find Duplicate Subtrees
public class FindDuplicateSubTree {
    HashSet<String> memo = new HashSet<>();//store all subtrees
    List<TreeNode> result = new ArrayList<>();//store result in treenode format
    List<String> resultString = new ArrayList<>();//store result in string format

    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return result;
    }

    private String traverse(TreeNode root) {
        //base case
        if (root == null){
            return "#";
        }

        //find left/right child in string format
        String left = traverse(root.left);
        String right = traverse(root.right);

        //left + right + root is the full subtree
        String subtree = left + " , " + right  + " , " + root.val;

        //put subtree to hash set/map, if already contains, find repeated
        if(memo.contains(subtree)){
            if (!resultString.contains(subtree)){ //in case result has duplicated
                resultString.add(subtree);
                result.add(root);// add to result
            }
        }
        else{
            memo.add(subtree);// no repeated, add to memo
        }

        return subtree;
    }
}
