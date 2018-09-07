package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:23 2018/3/8
 * @ ModifiedBy:
 */
public class MoreThanHalfNumber39 {
    public int moreThanHalfNumber(int[] nums) {
        int n = nums.length;
        int mid = n >> 1;
        int start = 0;
        int end = n-1;
        int index = partition(nums, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index-1;
                index = partition(nums, start, end);
            }
            else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        int result = nums[mid];
        if (!CheckMoreThanHalf(nums, result)) return 0;
        return result;
    }

    public int moreThanHalfNum(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) times++;
            else times--;
        }
        if (!CheckMoreThanHalf(nums, result)) result = 0;
        return result;
    }

    public boolean CheckMoreThanHalf(int[] nums, int number) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) times++;
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= nums.length) {
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
    public int partition(int[] a, int lo, int hi) {
        if (a == null || lo > hi) throw new IllegalArgumentException();
        if (lo == hi) return lo;
        int i = lo;
        int j = hi + 1;
        int value = a[lo];
        while (true) {
            while (a[++i] < value)
                if (i == hi) break;
            while (a[--j] > value)
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public int partition(int[] a, int length, int start, int end) {
        if (a == null || start < 0 || end >= length) throw new IllegalArgumentException();
        int index = 0;
        int small = start-1;
        for (index = start; index < end; ++index) {
            if (a[index] < a[end]) {
                ++small;
                if (small != index)
                    exch(a, small, index);
            }
        }
        ++small;
        exch(a, small, end);
        return small;

    }

    private static void exch(int[] a, int lo, int hi) {
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }

    public static void  main(String[] args) {
        int[] a = {1};
        MoreThanHalfNumber39 m = new MoreThanHalfNumber39();
        System.out.println(m.moreThanHalfNumber(a));
    }
}
