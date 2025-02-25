package arrays;

import java.util.ArrayList;

public class LinSearch {
	public static void main(String[] args) {
		int[] arr = {1,2,34,4,5,63,7,7,8};
		int res = linearSearch(arr,63,0);
		ArrayList<Integer> result = allIndex(arr, 7, 0, new ArrayList<>());
        System.out.println(result); 
		System.out.println(res);
	}

	private static int linearSearch(int[] arr, int target, int i) {
		if(i == arr.length - 1) return -1;
		if(arr[i] == target) return i;
		else return linearSearch(arr,target,i+1);
	}
	
	static ArrayList<Integer> allIndex(int[] arr , int target , int i , ArrayList<Integer> list) {
		if(i == arr.length) return list;
		
		if(arr[i] == target) list.add(i);
		return allIndex(arr,target,i+1,list);
	}
}
