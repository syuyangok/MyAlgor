package com.yuyang.leetcode.array;

/**
 * @auther Yuyang Sun
 * @date 3/31/2022
 */
public class Sqrt {

    public static int mySqrt(int x) {
        //safe check
        if(x <=1) return x;

        int left = 1, right = x;
        int result = 0;
        int mid = 0;

        while(left <= right){

            mid = left + (right-left)/2;
            //usd divide to avoid large x pass the int limit
            if (mid == x/mid){
                return mid;
            }
            else if (mid > x/mid){
               right = mid-1;
            }
            else {
                left = mid+1;
                result = mid;//upper bound to choose close to result
            }

        }

        return result;
    }
}
