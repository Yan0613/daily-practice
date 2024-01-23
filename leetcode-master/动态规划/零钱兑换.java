class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {// 为什么只有只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要？？
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }

            }
        }
        if (dp[amount] == max) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}