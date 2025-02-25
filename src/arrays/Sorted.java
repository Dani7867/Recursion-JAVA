package arrays;

public class Sorted {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr1 = {1,2,34,4,5,63,7,8};
		System.out.println(isSorted(arr,0));
		System.out.println(isSorted(arr1,0));
	}

	private static boolean isSorted(int[] arr, int index) {
		if(index == arr.length - 1) return true;
		
		return arr[index] < arr[index+1] && isSorted(arr,index+1);
	}
}
