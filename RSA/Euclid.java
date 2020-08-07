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
