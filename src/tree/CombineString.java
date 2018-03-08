package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:54 2018/3/8
 * @ ModifiedBy:
 */
public class CombineString {
    public static void comb1(String s) { comb1("", s); }
    public static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }

    public static void comb2(String s) { comb2("", s); }
    public static void comb2(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++) {
            comb2(prefix + s.charAt(i), s.substring(i + 1));
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        CombineString.comb1(s);
        CombineString.comb2(s);
    }
}
