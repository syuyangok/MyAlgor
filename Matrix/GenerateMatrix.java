package com.yuyang.matrix;

import java.util.List;

/**
 * @author : Yuyang Sun
 * @date: 4/5/2022, Tue
 **/
//leetcode 59. Spiral Matrix II
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int upperBound = 0, lowBound = n-1;
        int leftBound = 0, rightBound = n-1;

        int[][] matrix = new int[n][n];
        int count = 0;
        while(true){
            if(count >= n*n) break;
            //loop up, from left col to right col
            for (int col = leftBound; col <= rightBound ; col++) {
                count++;
                matrix[upperBound][col] = count;//set matrix value
            }
            upperBound++;

            if(count >= n*n) break;
            //loop right, from up row to bottom row
            for (int row = upperBound; row <= lowBound ; row++) {
                count++;
                matrix[row][rightBound] = count;//set matrix value
            }
            rightBound--;

            if(count >= n*n) break;
            //loop bottom, from right col to left col
            for (int col = rightBound; col >= leftBound ; col--) {
                count++;
                matrix[lowBound][col] = count;//set matrix value
            }
            lowBound--;

            if(count >= n*n) break;
            //loop left, from bottom row to up row
            for (int row = lowBound; row >= upperBound ; row--) {
                count++;
                matrix[row][leftBound] = count;//set matrix value
            }
            leftBound++;

        }
        return matrix;
    }

}
