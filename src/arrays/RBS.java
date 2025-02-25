package arrays;

public class RBS {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 1, 2}; 
        System.out.println(search(arr, 2, 0, arr.length - 1)); 
    }

    private static int search(int[] arr, int target, int s, int e) {
        if (s > e) return -1; // Base case: target not found
        
        int m = s + (e - s) / 2; // Midpoint calculation

        if (arr[m] == target) return m; // Target found

        // Check if the left half is sorted
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1); // Search in left sorted half
            } else {
                return search(arr, target, m + 1, e); // Search in right half
            }
        }

        // Otherwise, right half must be sorted
        if (target >= arr[m] && target <= arr[e]) { 
            return search(arr, target, m + 1, e); // Search in right sorted half
        }

        return search(arr, target, s, m - 1); // Search in left half
    }
}
