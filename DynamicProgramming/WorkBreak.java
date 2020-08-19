package edu.gatech.dp;

//leetcode 139
//dpv 6.4

import java.util.List;

public class WorkBreak {
    public static void main(String[] args) {

    }

    public static boolean solution(String s, List<String> wordDict){

        int n = s.length();

        boolean[] dp = new boolean[n+1];

        //base condition
        dp[0] = true;

            for (int i = 1; i < n+1 ; i++) {
                for (int j = 0; j < i; j++) {

                    //previous word exist, then check substring from j+1 to i
                    // here, actual j = j+1, actual i = i+1;
                    if (dp[j]) {
                        String sub = s.substring(j, i);
                        if (wordDict.contains(sub)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }

        return dp[n];

    }
}
