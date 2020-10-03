package edu.gatech.rsa;

//quick found gcd(x,y)
//Euclid: gcd(x,y) =gcd(x mod y, y)
//x>=y>=0;


public class Euclid {


    public static void main(String[] args){

        int a= 20, b=7;

        System.out.println(gcd(a,b));
    }

    public static int gcd(int x, int y){

        if(y==0) return x;

        return gcd(y, x%y);


    }
}

// run time:
//each round: O(n^2)   for x mod y
//  <= 2n round, O(n)   every other round, x decrease 2
//total run time  O(n^3)
