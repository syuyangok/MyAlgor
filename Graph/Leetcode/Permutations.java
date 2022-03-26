package com.yuyang.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Yuyang Sun
 * @date: 3/26/2022, Sat
 **/
//leetcode 46. Permutations
//use backtrack to traverse
public class Permutations {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path) {
        //base case, all item in path
        if (path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //if item already in path, skip
            if (path.contains(nums[i])){
                continue;
            }

            //add new item
            path.add(nums[i]);
            //traverse child
            backtrack(nums, path);
            //leave, remove item
            path.removeLast();
        }

    }
}
