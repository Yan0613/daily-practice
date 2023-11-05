using namespace std;
#include <vector>
#include <unordered_map>
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        std::unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++)
        {
            int complement = target - nums[i];
            if (map.find(complement) != map.end())
            {
                return {map[complement], i};
            }
            map.insert(pair<int, int>(nums[i], i));
        }

        return {0, 0};
    }
};