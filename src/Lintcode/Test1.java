package Lintcode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:11 2018/4/14
 * @ ModifiedBy:
 */
public class Test1 {
    public int bigBusiness1(int[] a, int[] b, int k) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = b[i] - a[i];
        }
        quicksort(a, c, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            if (k >= a[i]) {
                if (c[i] > 0)
                    k += c[i];
            }
            else break;
        }
        return k;
    }
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int partition(int[] a, int[] c, int lo, int hi) {
        if (lo == hi) return lo;
        int index = a[lo];
        int i = lo-1, j = hi+1;
        while (true) {
            while (a[++i] <= index) {
                if (i > hi) return hi;
            }
            while (a[--j] >= index) {
                if (j < lo) return lo;
            }
            if (i > j) break;
            exch(a, i, j);
            exch(c, i, j);
        }
        exch(a, lo, j);
        exch(c, lo, j);
        return j;
    }
    private void quicksort(int[] a, int[] c, int lo, int hi) {
        if (lo > hi) return;
        else {
            int k = partition(a, c, lo, hi);
            if (k > lo) quicksort(a, c, lo, k - 1);
            if (k < hi) quicksort(a, c, k + 1, hi);
        }
    }
    public static void main(String[] args) {
        int[] a = new int[10000];
        int[] b = new int[10000];
        Test1 t = new Test1();
        Scanner sc = new Scanner(System.in);
        
        System.out.println(t.bigBusiness(a,b,1275));
    }

    public int bigBusiness(int[] a, int[] b, int k) {
        int max = k;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (b[i] - a[i] > 0)
                map.put(a[i], b[i] - a[i]);
        }
        while(!map.isEmpty()) {
            int lastK = map.firstKey();
            if (k >= lastK) {
                k += map.get(lastK);
                map.remove(lastK);
                max = Math.max(max, k);
            }
            else break;
        }
        return max;
    }
}
