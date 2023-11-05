using namespace std;
#include <vector>
class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        vector<int> res;
        int n = numbers.size();
        for (int i = 0; i < n; i++)
        {
            int num = target - numbers[i];
            for (int j = i + 1; j < n; j++)
            {
                if (numbers[j] == num)
                {
                    res.push_back(i + 1);
                    res.push_back(j + 1);
                    return res;
                }
            }
        }
    }
};