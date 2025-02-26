package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 2, 5};
        RselectionSort(arr, arr.length - 1, 0, 0);
        selectionSort(arr);
        selectionSortMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = arr.length - 1; i > 0 ; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    private static void selectionSortMin(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {  // i points to first position in unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Find the index of the minimum element
                }
            }
            // Swap min element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private static void RselectionSort(int[] arr, int length, int index, int max) {
        if (length <= 0) return; // Base case: If only one element remains, sorting is done

        if (index <= length) { // Finding the maximum element in the unsorted part
            if (arr[index] > arr[max]) {
                RselectionSort(arr, length, index + 1, index);
            } else {
                RselectionSort(arr, length, index + 1, max);
            }
        } else { // Swap max element with the last element in the unsorted part
            int temp = arr[max];
            arr[max] = arr[length];
            arr[length] = temp;

            RselectionSort(arr, length - 1, 0, 0); // Move to the next iteration
        }
    }
}
