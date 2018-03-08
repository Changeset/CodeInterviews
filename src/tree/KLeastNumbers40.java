package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:04 2018/3/8
 * @ ModifiedBy:
 */
public class KLeastNumbers40 {

    public static void getLeastNumber(int[] input, int k, int[] output) {
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
        for (int i = 0; i < k; i++) {
            output[i] = input[i];
        }
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        int[] output = new int[4];
        KLeastNumbers40.getLeastNumber(input, 4, output);
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
