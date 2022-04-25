package com.yuyang.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Yuyang Sun
 * @date 4/5/2022
 */
//leetcode 54. Spiral Matrix
// Same an better to apple peeler, solution easy to understand,
// find 4 bound, and also be carefull end conditions.
public class SprialMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return null;

        List<Integer> result = new ArrayList<>();
        int m = matrix.length;//matrix row number
        int n = matrix[0].length;//matrix column nubmer

        int upperBound = 0, lowBound = m-1;//bounder are not looped
        int leftBound = 0, rightBound = n-1;

        //if result size equal to matrix size, reach end
        while(result.size() < m*n){
            //loop upper row, from left to right
            for(int col = leftBound; col<=rightBound; col++){
                result.add(matrix[upperBound][col]);
            }
            upperBound++;//move upperBound down one row

            if(result.size() >= m*n) break;
            //loop right col, from up to bottom
            for (int row = upperBound; row <= lowBound ; row++) {
                result.add(matrix[row][rightBound]);
            }
            rightBound--;

            if(result.size() >= m*n) break;
            //loop bottom
            for(int col = rightBound; col >= leftBound; col-- ){
                result.add(matrix[lowBound][col]);
            }
            lowBound--;

            if(result.size() >= m*n) break;
            //loop left
            for (int row = lowBound; row >= upperBound ; row--) {
                result.add(matrix[row][leftBound]);
            }
            leftBound++;

        }

        return result;
    }
}
