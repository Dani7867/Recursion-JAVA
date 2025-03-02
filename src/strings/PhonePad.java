package strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(pad("", "12"));
        System.out.println(padRet("", "23"));
        System.out.println(countKConstraintSubstrings("10101", 1));
        System.out.println(countKConstraintSubstringsR("10101", 1));
    }

    public static List<String> pad(String p , String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        List<String> list = new ArrayList<>();
        for(int i = (digit - 1) * 3 ; i < digit * 3 ; i++){
            char ch = (char) ('a' + i);
            list.addAll(pad(p + ch , up.substring(1)));
        }

        return list;
    }
    static int padRet(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        int count = 0 ;

        ArrayList<String> list = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
           count = count + padRet(p + ch, up.substring(1));
        }
        return count;
    }

    public static  int  countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0 ;

        for(int i = 0; i<n ; i++){
            int zC = 0 , oC = 0;
            for(int j = i ; j < n ; j++){
                if(s.charAt(j) == '0'){
                    zC++;
                }else{
                    oC++;
                }

                if(zC <= k || oC <=k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static  List<String>  countKConstraintSubstringsR(String s, int k) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        int ans = 0 ;

        for(int i = 0; i<n ; i++){
            int zC = 0 , oC = 0;
            for(int j = i ; j < n ; j++){
                if(s.charAt(j) == '0'){
                    zC++;
                }else{
                    oC++;
                }

                if(zC <= k || oC <=k){
                    result.add(s.substring(i,j+1));
                }
            }
        }
        return result;
    }
}
