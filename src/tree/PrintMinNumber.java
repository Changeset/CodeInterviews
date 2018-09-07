package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:24 2018/9/6
 * @ ModifiedBy:
 */

public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for (int i : list) s += i;
        return s;
    }

    public static void main(String[] args) {
        PrintMinNumber p = new PrintMinNumber();
        int[] numbers = {32,321,12};
        System.out.println(p.PrintMinNumber(numbers));
    }
}
