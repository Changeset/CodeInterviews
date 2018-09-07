package bytedance;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:14 2018/4/15
 * @ ModifiedBy:
 */
public class Test3 {
    static class matrix{
        int row;
        int col;
        int startR;
        int startC;
        matrix(int row, int col, int startR, int startC) {
            this.row = row;
            this.col = col;
            this.startR = startR;
            this.startC = startC;
        }
    }
    private static int getResult(matrix m, String S) {
        char[] path = S.toCharArray();
        int res = 0;
        for (char c : path) {
            switch(c) {
                case 'u': {
                    m.startR--;
                    res++;
                    if (!isValid(m)) {
                        System.out.println(res);
                        return res;
                    }
                } break;
                case 'r': {
                    m.startC++;
                    res++;
                    if (!isValid(m)) {
                        System.out.println(res);
                        return res;
                    }
                } break;
                case 'd': {
                    m.startR++;
                    res++;
                    if (!isValid(m)) {
                        System.out.println(res);
                        return res;
                    }
                    break;
                }
                case 'l': {
                    m.startC--;
                    res++;
                    if (!isValid(m)) {
                        System.out.println(res);
                        return res;
                    }
                    break;
                }
            }
        }
        return res;
    }
    private static boolean isValid(matrix m) {
        if (m.startR <= m.row && m.startR > 0 && m.startC <= m.col && m.startC > 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int Q = sc.nextInt();
        List<matrix> list = new LinkedList<>();
        for (int i = 0; i < Q; i++) {
            matrix m = new matrix(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            list.add(m);
        }
        for(int i = 0; i < Q; i++) {
            if (i == Q) System.out.print(getResult(list.get(Q), S));
            else System.out.println(getResult(list.get(Q), S));
        }
    }
}
