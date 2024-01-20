class Solution
{
public:
    int findTargetSumWays(vector<int> &nums, int target)
    {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            sum += nums[i];
        }
        if (abs(target) > sum)
            return 0;
        if ((target + sum) % 2 == 1)
            return 0;
        int size = (target + sum) / 2;
        if (size < 0)
        {
            size = -size;
        }
        vector<int> dp(size + 1, 0);
        dp[0] = 1;
        for (int i = 0; i < nums.size(); i++)
        {
            for (int j = size; j >= nums[i]; j--)
            {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[size];
    }
};