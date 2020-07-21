package x.y.z.rabbit.leetcode.dp;

import java.util.Arrays;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/6/10 10:27 下午 Copyright (c) 2016 政采云有限公司
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;//重要
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);//加1，是包括已经减去的那枚硬币的数量
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 5};
        System.out.println(new Solution322().coinChange(ints, 17));
    }
}
