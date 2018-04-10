package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:33 2018/4/10
 * @ ModifiedBy:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A, B;
        A = sc.next();
        B = sc.next();
        int a = A.length(), b = B.length();
        int k = a + b - 2, add = 0;
        int[] m = new int[a + b];
        Arrays.fill(m, 0);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                m[k -i - j] += (A.charAt(i) - '0') * (B.charAt(j) - '0');
            }
        }
        for (int i = 0; i < a + b; i++) {
            m[i] += add;
            add = m[i] / 10;
            m[i] %= 10;
        }
        int i = a + b - 1;
        while (m[i] == 0) i--;
        if (i < 0) System.out.println("0");
        while (i >= 0) System.out.print((char)(m[i--] + '0'));
    }
}
