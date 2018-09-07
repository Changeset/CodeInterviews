package bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:11 2018/5/12
 * @ ModifiedBy:
 */
public class Test7 {
    static class circle {
        int n;
        int m;
        List<Integer> A;
        circle() {
        }
        circle(int n, int m, List<Integer> B) {
            this.n = n;
            this.m = m;
            this.A = B;
        }
    }

    private static void getResult(circle c) {
        int totalNum = c.n;
        List<Integer> start = new ArrayList<>();
        for (int i = 0; i < totalNum; i++) {
            start.add(i);
        }
        int k = 0;
        List<Integer> outNum = c.A;
        int count = 0;
        while (start.size() > 1) {
            k = (k + outNum.get(count++ % outNum.size())) % (start.size()) - 1;
            if (k < 0) {
                start.remove(start.size() - 1);
                k = 0;
            } else start.remove(k);
        }
        System.out.println(start.get(0));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<circle> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            List<Integer> B = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                B.add(sc.nextInt());
            }
            circle c = new circle(n, m, B);
            list.add(c);
        }
        for (circle c : list) {
            getResult(c);
        }
    }
}
