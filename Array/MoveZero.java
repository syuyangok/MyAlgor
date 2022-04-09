package com.yuyang.array;

/**
 * @author : Yuyang Sun
 * @date: 4/4/2022, Mon
 **/
//283. Move Zeroes
// double fast, slow pointers
public class MoveZero {
    public void moveZeroes(int[] nums){
        if (nums.length == 1) return;
        //len is the length of non-zero array.
        int len = removeTargetElement(nums, 0);

        for (int i = len; i<= nums.length-1;i++){
            nums[i] = 0;
        }
    }

    private int removeTargetElement(int[] nums, int target) {
        int slow = 0, fast = 0;
        while(fast <= nums.length-1){
            if (nums[fast] !=  target){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
