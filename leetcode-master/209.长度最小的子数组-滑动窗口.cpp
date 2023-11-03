using namespace std;
#include <vector>
#include <limits.h>
class Solution
{
public:
    int subMinArray(int s, vector<int> &A)
    {
        int i = 0;
        int sum = 0;
        int ans = INT_MAX;
        for (int j = 0; j < A.size(); j++)
        {
            sum += A[j];
            while (sum >= s)
            {
                ans = min(ans, j - i + 1);
                // subLength = (j - i + 1); // 取子序列的长度
                // result = result < subLength ? result : subLength;
                sum -= A[i++];
            }
        }

        return ans == INT_MAX ? 0 : ans;
    }
};