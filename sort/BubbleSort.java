public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;

        //indicated if already sorted
        boolean sorted = true;

        for (int i = 0; i<=n-2; i++){
            sorted = true;
            for(int j = 0; j <=n-2; j++){
                if (arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                    sorted =false;//if switch happen, it means not sorted.
                }
            }
            if (sorted) break;

        }


    }


}
