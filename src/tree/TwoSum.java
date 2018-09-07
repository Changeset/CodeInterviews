package tree;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:46 2018/9/6
 * @ ModifiedBy:
 */
public class TwoSum {
    public boolean isTargetSum(int target, int[] nums) {
        int start = 0, end = nums.length - 1;
        Arrays.sort(nums);
        int current = 0;
        while (start < end) {
            current = nums[start] + nums[end];
            if (target == current) return true;
            else if (target > current) start++;
            else end--;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {5,3,6,2,4,7,10,1};
        System.out.println(t.isTargetSum(2, nums));
    }
}
