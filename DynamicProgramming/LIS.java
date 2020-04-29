package edu.gatech.dp;

public class LIS {
    public int lengthOfLIS(int[] nums){

        int n = nums.length;

        int[] L = new int[n];// create a array to record result
        for(int i=0; i<= n-1; i++){
            L[i] = 1;
            //find max sub lenth before i
            for(int j = 0; j <= i-1; j++){
                //only find eding sub samll than num[i]
                if(nums[j]<nums[i] && (L[j]+1>L[i])){
                    L[i] = L[j]+1; // update L[i] to big one
                }
            }

        }

        //find max value in the result array
        int maxIndex = 0;
        for(int m=1; m<= n-1; m++){
            if (L[m]>L[maxIndex]) maxIndex = m;
        }
        return L[maxIndex];

    }//lengthOfLIS end

    /*
    //drive, main method
    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("the max sub length is: " + lengthOfLIS(arr) +".\n");
    }
    */
}
