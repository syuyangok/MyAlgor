package com.yuyang.array;

import java.util.HashSet;

/**
 * @author : Yuyang Sun
 * @date: 4/9/2022, Sat
 **/
//128. Longest Consecutive Sequence

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        //create a hashset, add item in it.
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        int result = 0, count = 1;
        for(int i : hash){
            if (!hash.contains(i-1)){
                int cur = i;
                count  = 1;
                while(hash.contains(cur + 1)){
                    count++;
                    cur++;
                }
                result = Math.max(result, count);
                //System.out.println(result);
            }
        }
        return  result;

    }
}
