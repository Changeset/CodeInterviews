package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:32 2018/4/15
 * @ ModifiedBy:
 */
public class Test2 {
    public static int combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res.size();
    }

    public static void backtrack(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(path));
        else {
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                backtrack(candidates, i + 1, target - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    private static void getRes(int[] a, int[] b, int m) {
        int[][] dp = new int[a.length + 1][m + 1];
        dp[0][0] = 1;
        int res = combinationSum(b, m);
        for (int i = 1; i <= a.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j] + (j >= a[i-1] ? dp[i][j - a[i-1]] : 0);
            }
        }
        res += dp[a.length][m]%1000000007;
        for (int j = 0; j < b.length; j++) {
            if (b[j] < m)
                res += dp[a.length][m - b[j]]%1000000007;
        }
        System.out.println(res%1000000007);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }
        getRes(a, b, m);
    }
}
