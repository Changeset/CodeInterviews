package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:25 2018/3/8
 * @ ModifiedBy:
 */
public class StringPermutation {
    public void stringPermutation(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        stringPermutation(ch, 0, n);
    }

    public void stringPermutation(char[] ch, int start, int end) {
        if (start == end) {
            print(ch);
            return;
        }

        for (int i = start; i < end; i++) {
            exch(ch, start, i);
            stringPermutation(ch, start+1 , end);
            exch(ch, start, i);
        }
    }

    public void print(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
        System.out.println();
    }

    public static void exch(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutation s = new StringPermutation();
        String str = "abcd";
        s.stringPermutation(str);
    }
}
