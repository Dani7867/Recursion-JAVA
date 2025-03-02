package strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceC("",4));
        System.out.println(diceAl("",4));
    }

    private static void dice(String p, int t ) {
        if(t == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <=6 && i<=t; i++) {
            dice(p+i,t-i);
        }
    }

    private static int diceC(String p, int t ) {
        if(t == 0){
            return 1;
        }
        int c = 0;
        for (int i = 1; i <=6 && i<=t; i++) {
            c = c + diceC(p+i,t-i);
        }
        return  c;
    }

    private static List<String> diceAl(String p, int t ) {
        if(t == 0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <=6 && i<=t; i++) {
            list.addAll(diceAl(p+i,t-i));
        }
        return  list;
    }
}
