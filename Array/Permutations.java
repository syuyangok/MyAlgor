package com.yuyang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yuyang Sun
 * @date: 4/16/2022, Sat
 **/
//leetcode 46. Permutations for distinct array
// backtrack
public class Permutations {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){

        backtrack(nums);

        return result;
    }

    private void backtrack(int[] nums) {
        //base case
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //choice in options
        for (int i = 0; i < nums.length; i++) {
            //cut branch
            if (path.contains(nums[i])) continue;//nums[i] already in path, skip
            //choice
            path.add(nums[i]);
            //backtrack
            backtrack(nums);
            //retrieve choice
            path.remove(path.size()-1);
        }
        
        
    }


}
