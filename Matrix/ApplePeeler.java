package com.yuyang.leetcode.matrix;

//conter-clockwise to switch 2-d arrays to 1-d array.
//key point, keep recording top left start position.
//And adjust, top-left position, after one loop end.
public class ApplePeeler {
    
        public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        System.out.println(spiral(m));
    }
    
    // best methods.
        public static List<Integer> spiral(int[][] matrix){
        List<Integer> ret = new ArrayList<>();

        int height = matrix.length;
        int wide = matrix[0].length;

        //2d array nested size is up to small of(height, wide)/2
        int nestSize = (Math.min(height, wide)+1) /2;       
        
        
        //clock wise loop 2d array, i represents current looped nestSize
        for (int i = 0; i <= nestSize-1; i++) {
            
            //up
            for (int col = i; col <=wide-1-i ; col++) {

                ret.add(matrix[i][col]);
                System.out.println(matrix[i][col]);
            }

            //right side
            for (int row = i+1; row <=height-1-i ; row++) {

                ret.add(matrix[row][wide-1-i]);
                System.out.println(matrix[row][wide-1-i]);
            }

            //bottom side
            for (int col = wide-1-i-1; col >=i ; col--) {
                ret.add(matrix[height-1-i][col]);
                System.out.println(matrix[height-1-i][col]);
            }

            //left side
            for (int row = height-1-i-1; row >=i+1 ; row--) {
                ret.add(matrix[row][i]);
                System.out.println(matrix[row][i]);
            }            
        }

        return ret;
    }



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
