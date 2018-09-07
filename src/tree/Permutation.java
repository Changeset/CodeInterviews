package tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:41 2018/9/5
 * @ ModifiedBy:
 */
public class Permutation {
    public ArrayList<String> Permutation(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        Permutation(res, ch, 0, n);
        Collections.sort(res);
        return res;
    }

    public void Permutation(ArrayList<String> res, char[] ch, int start, int end) {
        if (start == end) {
            String s = new StringBuilder().append(ch).toString();
            if (!res.contains(s)) res.add(s);
            return;
        }

        for (int i = start; i < end; i++) {
            exch(ch, start, i);
            Permutation(res, ch, start + 1, end);
            exch(ch, start, i);
        }
    }

    private void exch(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> res = p.Permutation("abc");
        for (String s : res) System.out.println(s);
    }
}
