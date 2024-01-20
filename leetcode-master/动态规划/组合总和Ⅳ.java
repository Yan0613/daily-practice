class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        if (nums.length == 0 && target != 0) {
            return 0;
        }
        if (nums.length == 1 && target != nums[0]) {
            return 0;
        }
        for (int i = 0; i <= target; i++) {// 遍历背包
            for (int j = 0; j < nums.length; j++) {// 遍历物品
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}