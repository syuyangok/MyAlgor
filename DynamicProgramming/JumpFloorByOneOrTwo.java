package edu.gatech.dp;

//a frog jump to foolrs, only step 1 or 2, how many ways to jump to n floors.
public class JumpFloorByOneOrTwo {
    public static void main(String[] args) {
        int n = 10;
        int result = solution3(n);
        System.out.println("Total: "+ result);
    }

//rsolve by recurvison
    private static int solution1(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        return solution1(n-1) + solution1(n-2);

    }

    // use array to keep result
    private static int solution2(int n) {
        //create a array to keep result
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) array[i] = 1;
            else if (i == 2) array[i] = 2;
            else array[i] = array[i - 1] + array[i - 2];

        }
        return array[n];

    }

    // use sum to keep result, save space, no need array
    private static int solution3(int n) {
        int f1 =1;
        int f2 =2;
        int sum =0;

        for (int i = 1; i <= n; i++) {
            if (i <= 2) sum =i;
            else {
                sum = f1+f2;
                f1=f2;
                f2=sum;
            }

        }
        return sum;

    }


}
