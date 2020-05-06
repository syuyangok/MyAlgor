package edu.gatech.dp;

import java.util.Set;

//Longest common subsequence with Drive
public class LCS {
    //    private static Set<String> set = newTreeSet<String>();
    //Drive
    public static void main(String[] args) {
        String str1="BCDBCDA";
        String str2="ABECBAB";
        int max = LCS_Length(str1, str2);
        System.out.println(max);
    }

    private static int LCS_Length(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] L = new int[n+1][m+1];
        //fill the first line with 0
        for(int i=0; i<=n; i++){
            L[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            L[0][j] = 0;
        }
// start from second line
        for(int i=1; i<=n; i++){
            for(int j=1;j<=m; j++){
                // be careful i number different in array i and string i-1
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    L[i][j] = L[i-1][j-1] +1;
                }
                else{
                    L[i][j] = Math.max(L[i][j-1],  L[i-1][j]);
                }
            }
        }
        return L[n][m];



    }// length end


}
