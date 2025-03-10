package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr1 = new int[]{1, 0, 1,0,1};
      //  List<List<Integer>> ans = subSet(arr);
        List<List<Integer>> ans1 = subSetDuplicate(arr1);
      //  for (List<Integer> list : ans) {
       //     System.out.println(list);
      //  }
        for (List<Integer> list : ans1) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
    private static List<List<Integer>> subSetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start;
        int end = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            start = 0;
            if(i>0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

}



