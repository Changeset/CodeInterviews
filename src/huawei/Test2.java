package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:58 2018/3/27
 * @ ModifiedBy:
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j <= n && j <= nums[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
        }
        System.out.println(dp[n-1] == Integer.MAX_VALUE ? 0 : dp[n-1]);
    }
}
