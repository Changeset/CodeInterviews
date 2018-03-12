package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:54 2018/3/12
 * @ ModifiedBy:
 */
public class MaximalProfit63 {
    public static int maxProfit(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int[] temp = new int[n - 1];
        for (int i = 0; i < n-1; i++) {
            temp[i] = nums[i+1] - nums[i];
        }
        int curProfit=0, maxProfit=0;
        for (int i = 0; i < n - 1; i++) {
            curProfit = curProfit > 0 ? curProfit + temp[i] : temp[i];
            maxProfit = Math.max(curProfit, maxProfit);
        }
        return maxProfit;
    }

    public int maximalProfit(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int minimum = nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            minimum = Math.min(minimum, nums[i-1]);
            max = Math.max(nums[i] - minimum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9,11,8,5,7,12,16,14};
        MaximalProfit63 m = new MaximalProfit63();
        System.out.println(m.maximalProfit(nums));
        System.out.println(MaximalProfit63.maxProfit(nums));
    }
}
