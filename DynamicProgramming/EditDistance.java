package edu.gatech.dp;

//leetcode 72
//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

public class EditDistance {

    public static void main(String args[]){
        String w1 = "horse";
        String w2 = "ros";

        System.out.println(solution(w1, w2));
    }

    public static int solution(String word1, String word2){

        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        //init base case
        dp[0][0] = 0;

        for(int i = 1; i<n1+1; i++){
            dp[i][0] = dp[i-1][0]+1;
        }

        for(int j = 1; j<n2+1; j++){
            dp[0][j] = dp[0][j-1]+1;
        }

        //
        for(int i =1; i<n1+1; i++){
            for(int j = 1; j<n2+1; j++){
                //case 1: word1 and word 2 end same
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    //3 case:
                    //replace char i, dp[i-1][j-1]+1
                    //delete char i, insert after char i.
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1 ), dp[i-1][j-1]+1);
                }

            }
        }

        return dp[n1][n2];

    }
}
