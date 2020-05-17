package edu.gatech.dp;

import java.util.ArrayList;
import java.util.List;

public class Knapksack01 {
    public static void main(String[] args) {
        int capcity = 7;
        int[] V = new int[]{2,2,4,5,3};
        int[] W = new int[]{3, 1, 3, 4, 2};

        System.out.println(solution1(capcity, V, W).toString());
    }

//    private static int solution1(int capcity, int[] v, int[] w) {
    private static ArrayList<Integer> solution1(int capcity, int[] v, int[] w) {
        int n = v.length;
        //create a 2-d array
        int[][] L= new int[n+1][capcity+1];

        //init first row and column, optional, java default value is 0
        for (int i = 0; i <= n ; i++)    L[i][0] = 0;
        for (int j = 0; j <= capcity ; j++)    L[0][j] = 0;

        //file the line
        for (int i = 1; i <=n ; i++) {
            //get the item weight value
            int itemV= v[i-1], itemW= w[i-1];

            for(int j=0;j<=capcity; j++){
                //if item weight greater than the available spot
                if (itemW >  j) L[i][j] = L[i-1][j];
                else{
                    L[i][j] = Math.max(L[i-1][j-itemW]+itemV, L[i-1][j]);
                }
            }//be careful of the j, itemW meaning

        }
//        return L[n][capcity];

        //find the selected item, return a list with index
        ArrayList <Integer> itemSelected = new ArrayList<>();
        // if , then item i should be include
        int i = n, j = capcity;
        while (i > 0 && j > 0) {
            if (L[i][j] != L[i - 1][j]) {
                int itemIndex = i - 1;
                itemSelected.add(itemIndex);//add item i's index
                j = j - w[itemIndex];
                i--;

            } else {
                i--;
            }

        }

        return itemSelected;




    }
}
