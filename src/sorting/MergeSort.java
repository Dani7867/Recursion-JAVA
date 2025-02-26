package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        arr = mergeSort(arr);
        inplaceMergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr; // Base case: single element is already sorted

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] sortedArray = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sortedArray[k++] = left[i++];
            } else {
                sortedArray[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array (if any)
        while (i < left.length) {
            sortedArray[k++] = left[i++];
        }

        // Copy remaining elements from right array (if any)
        while (j < right.length) {
            sortedArray[k++] = right[j++];
        }

        return sortedArray;
    }

    private static void inplaceMergeSort(int[] arr, int s, int e) {
        if (s < e) {

            int mid = s + (e - s) / 2;
            inplaceMergeSort(arr, s, mid);
            inplaceMergeSort(arr, mid + 1, e);
            mergeInPlace(arr, s, mid, e);
        }
    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int i = s, j = mid + 1;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                int temp = arr[j];
                int k = j;

                // Shift elements to the right
                while (k > i) {
                    arr[k] = arr[k - 1];
                    k--;
                }
                arr[i] = temp;

                // Update pointers
                i++;
                mid++;
                j++;
            }
        }
    }
}


