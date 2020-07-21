package x.y.z.rabbit.leetcode.dp;

import java.util.Vector;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/6/9 11:37 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution10Point1 {

    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3, j = i - 1, k = i - 2; i <= n; i++, j = i - 1, k = i - 2) {
            int value = dp[j] + dp[k];
            dp[i] = value % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution10Point1().fib(99));
    }
}
