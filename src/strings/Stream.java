package strings;

public class Stream {
    public static void main(String[] args) {
        skip("","baabacda");
        System.out.println(skip("baabacda"));
        System.out.println(skipSugar("basugaracda"));
        System.out.println(skipSugNotSugar("basugaracda"));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }else {
            skip(p + ch , up.substring(1));
        }
    }

    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip(up.substring(1));
        }else {
            return ch + skip(up.substring(1));
        }
    }

    static String skipSugar(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("sugar")){
            return skipSugar(up.substring(5));
        }else {
            return up.charAt(0) + skipSugar(up.substring(1));
        }
    }

    static String skipSugNotSugar(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("sug") && !up.startsWith("sugar")){
            return skipSugNotSugar(up.substring(3));
        }else {
            return up.charAt(0) + skipSugNotSugar(up.substring(1));
        }
    }

}
