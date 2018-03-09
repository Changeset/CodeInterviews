package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:05 2018/3/9
 * @ ModifiedBy:
 */
public class FirstNumberOfK53 {
    public static int getK(int[] num, int k) {
        int n = num.length;
        return getLastHelper(num, 0, n-1, k) - getFirstHelper(num, 0, n-1, k) + 1;
    }

    public static int getFirstHelper(int[] num, int lo, int hi, int k) {
        if (lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (num[mid] == k) {
            if ((mid > 0 && num[mid-1] != k) || mid == 0) return mid;
            else return getFirstHelper(num, lo, mid-1, k);
        }
        else if (num[mid] > k) return getFirstHelper(num, lo, mid-1, k);
        else return getFirstHelper(num, mid+1, hi, k);
    }

    public static int getLastHelper(int[] num, int lo, int hi, int k) {
        if (lo == hi) return hi;
        int mid = lo + (hi - lo) / 2;
        if (num[mid] == k) {
            if ((mid < num.length-1 && num[mid+1] != k) || mid == num.length-1) return mid;
            else return getLastHelper(num, mid+1, hi, k);
        }
        if (num[mid] < k) return getLastHelper(num, mid+1, hi, k);
        else return getLastHelper(num, lo, mid-1, k);
    }
    public static void main(String[] args) {
        int[] num = {1,2,3,3,3,3,5,6};
        System.out.println(FirstNumberOfK53.getK(num, 3));
    }
}
