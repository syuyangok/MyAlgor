package com.yuyang.array;

/**
 * @author : Yuyang Sun
 * @date: 4/4/2022, Mon
 **/
//27. Remove Element
// remove all targeet element
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;

        while(fast<nums.length){
            //find target
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
