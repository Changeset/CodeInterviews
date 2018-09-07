package tree;

import java.util.ArrayList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:04 2018/3/8
 * @ ModifiedBy:
 */
public class KLeastNumbers40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int index = 0;
        int start = 0;
        int end = input.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        index = partition(input, start, end);
        if (k > input.length || k == 0) return  res;
        while (index != k-1) {
            if (index > k-1) {
                end = index-1;
                index = partition(input, start, end);
            }
            else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    private static int partition(int[] a, int lo, int hi) {
        if (a == null || lo > hi) return -1;
        int i = lo;
        int j = hi+1;
        int v = a[lo];
        if (lo == hi) return lo;
        while (true) {
            while (a[++i] < v)
                if (i == hi) break;
            while (a[--j] > v)
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
