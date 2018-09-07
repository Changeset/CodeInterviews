package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:07 2018/9/6
 * @ ModifiedBy:
 */
public class GetNumberOfK {
    public int GetNumberOfk(int[] nums, int k) {
        return binSearch(nums, k + 0.5) - binSearch(nums, k - 0.5);
    }

    private int binSearch(int[] nums, double k) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (nums[mid] < k) s = mid + 1;
            else if (nums[mid] > k) e = mid - 1;
        }
        return s;
    }
    public static void main(String[] args) {
        GetNumberOfK g = new GetNumberOfK();
        int[] nums = {1, 3, 5, 6, 6, 7};
        System.out.println(g.GetNumberOfk(nums, 6));
    }
}
