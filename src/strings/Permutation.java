package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
       // permutations("", "123");
      //  ArrayList<String> l =permutationsList("", "123");
       // System.out.println(l);
        int[] nums = {1, 2, 3};
        List<List<Integer>> integerPermutations = permute(nums);
        System.out.println("Integer Permutations: " + integerPermutations);
        System.out.println(permutationsCount("", "12345"));
    }

    static  void permutations(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            permutations(s+ch+f,up.substring(1));

        }
    }

    static  int permutationsCount(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0 ;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            count = count + permutationsCount(s+ch+f,up.substring(1));
        }
        return count;
    }

    static ArrayList<String> permutationsList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            ans.addAll(permutationsList(s+ch+f,up.substring(1)));

        }
        return ans;
    }
    public static List<List<Integer>> permutationsList(List<Integer> p, List<Integer> up) {
        if (up.isEmpty()) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }
        int num = up.get(0);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= p.size(); i++) {
            List<Integer> f = new ArrayList<>(p);
            f.add(i, num); // Insert the current number at position i
            ans.addAll(permutationsList(f, up.subList(1, up.size()))); // Recursive call with the remaining elements
        }
        return ans;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> inputList = new ArrayList<>();
        for (int num : nums) {
            inputList.add(num);
        }
        return permutationsList(new ArrayList<>(), inputList);
    }

}
