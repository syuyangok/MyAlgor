package com.yuyang.leetcode.matrix;

//visit neighbors(UP, DOWN, LEFT, RIGHT) in matrix.
public class MatrixNeighbor {
    public void solution(int[][] m){
        int h = m.length, w = m[0].length;

        for (int row = 0; row <= h-1; row++) {
            for (int col = 0; col < w-1; col++) {
                //print center
                System.out.print(m[row][col] + "\t");
                //print upper
                if (row-1>= 0){
                    System.out.print(m[row-1][col]);
                }
                //print down
                if (row+1<= h-1){
                    System.out.print(m[row+1][col]);
                }
                //print left
                if (col-1>= 0){
                    System.out.print(m[row][col-1]);
                }
                //print right
                if (col+1 <= w){
                    System.out.print(m[row][col+1]);
                }
                System.out.println();
                System.out.println();
            }//for end
        }//for end
    }//solution end

    //better solution
    public void solution2(int[][] m){
        int h = m.length, w = m[0].length;
        //to store directions changes: up, down, left, right
        int[][] direction = {{-1,0}, {1,0},{0,-1},{0,1}};
        for (int row = 0; row <= h-1; row++) {
            for (int col = 0; col < w-1; col++) {
                //print center
                System.out.print(m[row][col] + "\t");
                for (int[] dir:direction   ) {
                    //get neigobors row, col
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    //check bounder
                    if(nrow >=0 && nrow <= h-1 && ncol >= 0 && ncol <= w-1){
                        System.out.print(m[nrow][ncol]);
                    }
                }

                System.out.println();
                System.out.println();
            }//for end
        }//for end
    }//solution end




}
