package edu.gatech.dp;


// he maximum sum subarray problem
// finding a contiguous subarray with the largest sum
public class MaxSubSum {
    public static void main(String[] args) {
       // int[] a= new int[]{2,4,-7,5,2,-1,2,-4,3};
       int[] a= new int[]{-2,-4,-7};//corner case, all negative

        int result = solution2(a);
        System.out.println(result);
    }

    //    loop and find all the combination,
    private static int solution1(int[] a) {
        int maxSum = a[0];
        for (int i = 0; i <= a.length - 1; i++) {
            int currentSum = 0;
            for (int j = i; j <= a.length - 1; j++) {
                currentSum += a[j];
                if (currentSum > maxSum) maxSum = currentSum;
            }
        }
        return maxSum;

    }

    //    dp way to find,
    private static int solution2(int[] a) {
        int maxSum = a[0];// carefull corner case, all negative and first case biggest
        int currentSum = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            if (currentSum >= 0) {
                currentSum += a[i];
            } else {
                currentSum = a[i]; // if is negative, recalculate sum
            }
            if (currentSum > maxSum) maxSum = currentSum; //recording maxim

        }
        return maxSum;
    }


}
