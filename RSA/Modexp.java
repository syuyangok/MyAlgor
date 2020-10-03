
//Modular exponentiation (Recursive)
public class Modexp {


    public static void main(String[] args) {


        System.out.println(1/2);
        int a = 7;
        int b = 25;
        int c = 23;
        int result = modexp(a,b,c);

        System.out.println(result);
    }

    public static int modexp(int x, int y, int N){

        if(y == 0) return 1;

        int z = modexp(x, y/2, N);
        //if y is even
        if(y%2 ==0 ) return z*z%N;
        else return x*z*z%N;
    }

}
//run time:
//Each round,  O(n^2) for zz%N,
// logy  round, O(n)
//total run time  O(n^3)
