package bytedance;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:04 2018/4/15
 * @ ModifiedBy:
 */
public class Test1 {
    private static void getRes(List<Integer> nums) {
        TreeSet<Integer> T = new TreeSet<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) - nums.get(i) != 0)
                    T.add(nums.get(j) - nums.get(i));
            }
        }
        while (!T.isEmpty()) {
            boolean flag = true;
            int testT = T.first();
            for (int i = 0; i < nums.size(); i++) {
                int alarge = nums.get(i) + testT;
                int alittle = nums.get(i) - testT;
                if (nums.get(i) + testT <= nums.get(nums.size() - 1)) {
                    if (!nums.contains(alarge)) {
                        T.remove(testT);
                        flag = false;
                        break;
                    }
                }
                if (alittle >= nums.get(0)) {
                    if (!nums.contains(alittle)) {
                        T.remove(testT);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(testT);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<List<Integer>> seq = new LinkedList<>();
        List<Integer> list;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            seq.add(list);
        }
        for (int i = 0; i < N; i++) {
            getRes(seq.get(i));
        }
    }
}
