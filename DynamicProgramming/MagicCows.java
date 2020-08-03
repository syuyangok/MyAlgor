package edu.gatech.dp;

/*
with a maximum capacity of C cows. On each farm,
cows reproduce at the same rate:
they always double in number when the clock strikes midnight.
compute the number of farms that need inspecting on any given day.
 */

public class MagicCows {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,2,1};
        int result = solution(8, 4, arr);
        System.out.println(result);
    }

    //C max number of cows in one farm
    //M number of days
    //S array to repressent init farms
    // return total farms at M days
    private static int solution(int C, int M, int[] S) {
        int s = S.length;
        int result = 0;

        for(int farm = 0; farm < s; farm++){
            //create a dp to record every day  for one start farm
            int[] dp = new int[M+1];//start from day0 to day M;
            dp[0] = 1;
            int inCow = S[farm];

            for(int i =1; i<=M; i++){

                // if cow great than the max number, double the number of farm;
                if( (inCow* Math.pow(2, i)) > C){
                    dp[i] = dp[i-1]*2; //double the number of farm
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
            result += dp[M];//acculate very start farm
            //System.out.println(result);

        }
        return  result;


    }

}
