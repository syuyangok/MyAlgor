package com.yuyang.leetcode.array;

/**
 * @auther Yuyang Sun
 * @date 4/4/2022
 */
//26. Remove Duplicates from Sorted Array
public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1 ) return 0;
        int slow = 0, fast = 0;

        while(fast < nums.length){
            //find no dup items
            if( nums[fast] != nums[slow]){
                slow++; //slow move to a new postion
                nums[slow] = nums[fast];
            }
            fast++;
        }


        return slow+1;
    }
}
