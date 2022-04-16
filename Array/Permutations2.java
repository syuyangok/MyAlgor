package com.yuyang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Yuyang Sun
 * @date: 4/16/2022, Sat
 **/
//leetcode 47. Permutations for allow repeated array
// backtrack, diff vs 46,
// key: 1 visited to record path. 2 same level to record visit same value item
public class Permutations2 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>>  permuteUnique(int[] nums){
        visited = new boolean[nums.length];

        backtrack(nums);

        return result;
    }

    private void backtrack(int[] nums) {
        //base case
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //用于检查同一层是否包涵相同元素
        ArrayList<Integer> level = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;//if item already in path, skip

            //同一层包涵相同元素, skip
            if(level.contains(nums[i])) continue;

            level.add(nums[i]);

            //choice
            path.add(nums[i]);
            visited[i] = true;

            //backtrack
            backtrack(nums);
            path.remove(path.size()-1);
            visited[i] =false;
        }

        
    }


}
