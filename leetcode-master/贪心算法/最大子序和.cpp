class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int res = INT32_MIN;
        int curAdd = 0;
        for (int i = 0; i < nums.size(); i++)
        {

            curAdd += nums[i];
            res = max(res, curAdd);
            if (curAdd < 0)
                curAdd = 0;
            // res
        }

        return res;
    }
}