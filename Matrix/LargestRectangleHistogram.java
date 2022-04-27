package com.yuyang.leetcode.matrix;

import java.util.Stack;

/**
 * @auther Yuyang Sun
 * @date 4/26/2022
 */
//84. Largest Rectangle in Histogram

public class LargestRectangleHistogram {

    //stack, O(n)
    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        if (len == 0) return 0;

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //be careful corner, last item,
        for (int i = 0; i <= len; i++) {
            //if height[i] is less,ready to calculate area with height[top]
            //i == len must placed front, to avoid index issue
            while( !stack.isEmpty() && (i== len || heights[i]<heights[stack.peek()])){
                int h = heights[stack.pop()];
                int left = 0;
                if (stack.isEmpty()){
                    left = -1;
                }
                else{
                    left = stack.peek();
                }
                //width: Both ith and left positions are excluded.
                res = Math.max(res, (h*(i-1-left)));
            }

            stack.push(i);

        }

        return res;
    }

    //two pointers, slow
    // runtime O(n^2)
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        //safe check
        if (len <=0 ) return 0;

        int res = 0;
        //以i高度为中心，向左右扩展，找到大于等于当前柱形高度的最边元素的下标
        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            int height = heights[i];

            //check left
            while( left-1 >=0 && heights[left-1] >= height){
                left--;
            }

            //check right
            while( right+1 <= len-1 && heights[right+1] >= height){
                right++;
            }
            //check max
            int wid = right - left +1;
            res = Math.max(res, wid*height);
        }
        return res;
    }
}
