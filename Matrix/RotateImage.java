package com.yuyang.matrix;


/**
 * @author : Yuyang Sun
 * @date: 4/6/2022, Wed
 **/

//48. Rotate Image
public class RotateImage {
    public void rotate(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        //沿对角线翻转数组值
        for (int r = 0; r<=h-1; r++){
            for (int c = r; c <= w-1; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        //翻转左右每一行
        for (int r = 0; r <=h-1; r++) {
            revers(matrix[r]);
        }



    }

    private void revers(int[] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
