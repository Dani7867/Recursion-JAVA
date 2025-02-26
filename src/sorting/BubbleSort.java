package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 2, 5};
       RbubbleSort(arr, arr.length - 1, 0);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static void RbubbleSort(int[] arr, int i, int indx) {
        if (i == 0) return; // Base condition: sorting completed

        if (indx < i) {
            if (arr[indx] > arr[indx + 1]) {
                int temp = arr[indx];
                arr[indx] = arr[indx + 1];
                arr[indx + 1] = temp;
            }
            RbubbleSort(arr, i, indx + 1); // Move to the next index
        } else {
            RbubbleSort(arr, i - 1, 0); // Move to the next pass
        }
    }
}
