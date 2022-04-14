package com.yuyang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 4/14/2022
 */
//leetcode 78. Subsets
// backtrack
public class Subsets {
    //store result
    List<List<Integer>> result = new ArrayList<>();
    //store path
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int i) {
        //base case , add every possible path to result
        result.add(new ArrayList<Integer>(path));

        //choose in potions
        for(; i<nums.length;i++ ){
            //add choice
            path.add(nums[i]);
            //backtrack
            backtrack(nums, i+1);
            //retrieve choice, remove last item.
            path.remove(path.size()-1);
        }

   }
}
