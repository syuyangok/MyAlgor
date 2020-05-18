package edu.gatech.dp;

public class KnapsackRep {

    public static void main(String[] args) {
        int[] W = {3, 6, 2};
        int[] V = {5, 20, 3};

        int result = solutionSimpl(10, W, V);

        System.out.println(result);
    }


    //simple soluion, one d array
    private static int solutionSimpl(int capcity, int[] w, int[] v) {

        //create a array to recorde temp result
        int[] dp = new int[capcity + 1];
        dp[0] = 0;//set basic value
//        int[] selected = new int[capcity + 1];

        for (int weight = 1; weight <= capcity; weight++) {
            dp[weight]=0;//set first value

            for(int i =0; i<=v.length-1; i++){
                if (weight >= w[i] && dp[weight] < dp[weight-w[i]]+v[i])
                    dp[weight] = dp[weight-w[i]]+v[i];
            }
        }
        return dp[capcity];

    }//simple solution end


}
