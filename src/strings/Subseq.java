package strings;

import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        subseq("","adc");
        subseqAscii("","adc");
        System.out.println(subseqR("","adc"));
    }

    private static void subseq(String p, String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseq(p + ch ,up.substring(1));
        subseq(p,up.substring(1));
    }

    private static ArrayList<String> subseqR(String p, String up) {
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> l = subseqR(p + ch ,up.substring(1));
        ArrayList<String> r = subseqR(p,up.substring(1));
        l.addAll(r);

        return l;
    }

    private static void subseqAscii(String p, String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseqAscii(p + ch ,up.substring(1));
        subseqAscii(p,up.substring(1));
        subseqAscii(p + (ch+0) ,up.substring(1));
    }

}
