package sohu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:11 2018/4/14
 * @ ModifiedBy:
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        getLeastNumber(num, k);
    }
    public static void getLeastNumber(int[] input, int k) {
        int index = 0;
        int start = 0;
        int end = input.length-1;
        index = partition(input, start, end);
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
        int[] output = new int[k];

        for (int i = 0; i < k; i++) {
            output[i] = input[i];
        }
        Arrays.sort(output);
        for (int i = 0; i < k; i++) {
            if (i == k-1)
                System.out.print(output[i]);
            else System.out.print(output[i] + ",");
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int v = a[lo];
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
