package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:52 2018/3/7
 * @ ModifiedBy:
 */
public class SequenceOfBST {
    public boolean VerifySequenceOfBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        return helper(nums, 0, n-1);
    }

    public boolean helper(int[] nums, int lo, int hi) {
        if (lo > hi) return true;
        int root = nums[hi];
        boolean hasRight = false;
        int indexRight = Integer.MIN_VALUE;
        for (int i = lo; i < hi; i++) {
            if (nums[i] >= root) {
                indexRight = i;
                hasRight = true;
                break;
            }
        }
        if (hasRight)
            for (int i = indexRight; i < hi; i++)
                if (nums[i] <= root) return false;
        if (!hasRight) return helper(nums, lo, hi-1);
        else return helper(nums, lo, indexRight-1) &&
                helper(nums, indexRight, hi);
    }

    public static void main(String[] args) {
        SequenceOfBST s = new SequenceOfBST();
        int[] nums = {7,4,5,6};
        System.out.println(s.VerifySequenceOfBST(nums));
    }
}
