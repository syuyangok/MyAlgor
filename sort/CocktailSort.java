// imporved bubble sort
// odd round, sort from front to end, put large item to it position.
// even round, sort from end to front, put small item to it position.
public class CocktailSort {

    public void sort(int[] arr){
        int n = arr.length;

        //sort the odd round
        for (int i = 0; i <= n-2; i++) {
            for (int j = 0; j <=n-2; j++){

                if (arr[j]>arr[j+1]){
                    switchItem(arr, j, j+1);
                }

            }
        }

        //sort the even round
        for (int i = n-1; i >=1; i--) {
            for (int j = n-1; j >=1; j--){

                if (arr[j]<arr[j-1]){
                    switchItem(arr, j, j-1);
                }

            }
        }

    }

    private void switchItem(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }
}
