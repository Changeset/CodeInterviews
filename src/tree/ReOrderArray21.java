package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:39 2018/3/7
 * @ ModifiedBy:
 */
public class ReOrderArray21 {
    public int[] reOrderOddEven(int[] nums) {
        int front = 0, back = nums.length-1;
        while (front < back) {
            while (isOdd(nums[front]) && front < nums.length) front++;
            while (!isOdd(nums[back]) && back > 0) back--;
            if (front >= back) break;
            exch(nums, front, back);
        }
        return nums;
    }

    boolean isOdd(int num) {
        if ((num & 0x1) == 1) return true;
        else return false;
    }

    public void exch(int[] num, int i, int j) {
        num[i] ^= num[j];
        num[j] ^= num[i];
        num[i] ^= num[j];
    }

    public static void main(String[] args) {
        ReOrderArray21 r = new ReOrderArray21();
        int[] nums = {1,2,3,5,2,1,4};
        r.reOrderOddEven(nums);
    }
}
