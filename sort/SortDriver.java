import java.util.Arrays;

public class SortDriver {

    public static void main(String[] args){

        int[] arr = new int[]{5,8,6,3,9,7, 1};
        System.out.println(Arrays.toString(arr));

        //bubble sort
        BubbleSort b = new BubbleSort();
        b.sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
