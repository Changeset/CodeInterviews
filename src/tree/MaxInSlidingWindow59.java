package tree;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:55 2018/3/11
 * @ ModifiedBy:
 */
public class MaxInSlidingWindow59 {

    public List<Integer> maxInSlidingWindow(int[] nums, int size) {
        List<Integer> maxInWindows = new LinkedList<>();
        if (nums.length >= size && size >= 1) {
            Deque<Integer> index = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                while (!index.isEmpty() && nums[i] >= nums[index.getLast()])
                    index.pop();
                index.addLast(i);
            }

            for (int i = size; i < nums.length; i++) {
                maxInWindows.add(nums[index.getFirst()]);
                while (!index.isEmpty() && nums[i] >= nums[index.getLast()])
                    index.pop();
                if (!index.isEmpty() && index.getFirst() <= (int)(i - size))
                    index.pop();
                index.addLast(i);
            }
            maxInWindows.add(nums[index.peek()]);
        }
        return maxInWindows;
    }
}
