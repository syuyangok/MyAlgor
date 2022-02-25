package com.yuyang.leetcode;
//leetcode 50
//calculate x raised to power n.
public class Pow {
    public static double  solution(double x, int n){

        if (n>=0) {
            return helper(x, n);

        }
        else {
            return 1/(helper(x, -n));

        }

    }

    public static double helper(double x, int n){
        if (x==0) return 0;
        if (n == 0) return 1;

        double p = helper(x, n/2);
        if (n%2 == 0){
            return p*p;
        }
        else return p * p * x;
    }
}
