using namespace std;
#include <vector>
#include <limits.h>

class Solution
{
public:
    int minSubArrayLen(int s, vector<int> &nums)
    {
        int ans = INT_MAX;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            sum = 0; // 每次循环清空一次sum值
            for (int j = i; j < nums.size(); j++)
            {
                sum += nums[j];
                if (sum >= s)
                {
                    ans = min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans == INT_MAX ? 0 : ans; // 没有满足的子数组的时候返回0
    }
};
