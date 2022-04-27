package com.yuyang.leetcode.matrix;

import java.util.Stack;

/**
 * @auther Yuyang Sun
 * @date 4/26/2022
 */

//85. Maximal Rectangle
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] h = new int[matrix[0].length];
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(matrix[row][col] == '1'){
                    h[col] += 1;
                }
                else {
                    h[col] = 0;
                }
            }
            //after loop one row, check max area
            res = Math.max(res, largestRectangleArea(h));//use 84 function
        }

        return res;
    }

    //stack, O(n)
    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        if (len == 0) return 0;

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i <= len; i++) {
            while(!stack.isEmpty() && (i == len || heights[i]< heights[stack.peek()])){
                int cur = stack.pop();
                int h = heights[cur];
                int left = stack.isEmpty() ? -1 : stack.peek();

                result = Math.max(result, (i-left-1)*h );
            }
            stack.push(i);
        }

        return result;
    }


}
