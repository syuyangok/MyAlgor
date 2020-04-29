package edu.gatech.dp;

public class Drive {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60 };
        LIS result = new LIS();

        System.out.println("the max sub length is: " + result.lengthOfLIS(arr) +".\n");
    }
}
