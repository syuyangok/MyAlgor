package com.yuyang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 4/14/2022
 */
//77. Combinations
// backtrack
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int path_len;
    public List<List<Integer>> combine(int n, int k) {
        path_len = k;
        backtrack(n, 1);
        return res;
    }

    private void backtrack(int n, int start) {
        //base case
        if(path.size() == path_len){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        //if (start > n) return;
        //for choice in options
        for (; start <=n; start++) {
            //choice
            path.add(start);
            //backtrack
            backtrack(n, start+1);
            //retrieve choice
            path.remove(path.size()-1);
        }
    }
}
