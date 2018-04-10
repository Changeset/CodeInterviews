package huawei;

import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:01 2018/4/10
 * @ ModifiedBy:
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] ch = new int[256];
        for (int i = 0; i < 256; i++) {
            ch[i] = 0;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            ch[str[i]]++;
        }
        char[] res = new char[str.length];
        for (int i = 0; i < str.length;) {
            for (int j = 0; j < 256; j++) {
                if (ch[j] > 0) {
                    res[i] = (char)j;
                    ch[j]--;
                    i++;
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(res[i]);
        }
    }
}
