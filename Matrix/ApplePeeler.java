package com.yuyang.leetcode.matrix;

//conter-clockwise to switch 2-d arrays to 1-d array.
//key point, keep recording top left start position.
//And adjust, top-left position, after one loop end.
public class ApplePeeler {

    public static int[] Peel(int[][] m){
        //safe check
        if (m == null) return new int[0];

        //start position
        int srow= 0, scol = 0;
        //recording height, and width of matrix.
        int h = m.length, w = m[0].length,  len = h*w;
        //pointer for result array.
        int p = 0;
        int[] result = new int[len];


        while (true){
            //if pointer reach the whole lenth of the array, break;
            if (p>=len-1) break;
            //loop up, row not change
            for (int col = scol;  col<= scol+w-1; col++) {
                result[p] = m[srow][col];
                System.out.print(result[p] + " -> ");
                p++;
            }
            //after loop up, start row position +1, matrix height -1
            srow++;
            h--;

            //if pointer reach the whole lenth of the array, break;
            if (p>=len-1) break;
            //loop right, col not change
            for (int row = srow;  row<= srow+h-1; row++) {
                result[p] = m[row][scol+w-1];
                System.out.print(result[p] + " -> ");
                p++;
            }
            //after loop right, start col position no change, matrix width -1
            w--;

            //if pointer reach the whole lenth of the array, break;
            if (p>=len-1) break;
            //loop down,  row not change
            for (int col = scol+w-1;  col>= scol; col--) {
                result[p] = m[srow+h-1][col];
                System.out.print(result[p] + " -> ");
                p++;
            }
            //after loop up, start row position no change, matrix height -1
            h--;

            //if pointer reach the whole lenth of the array, break;
            if (p>=len-1) break;
            //loop left, col no change.
            for (int row = srow+h-1;  row>= srow; row--) {
                result[p] = m[row][scol];
                System.out.print(result[p] + " -> ");
                p++;
            }
            //after loop right, start col position +1, matrix width -1
            scol++;
            w--;
        }


        return result;
    }
}
