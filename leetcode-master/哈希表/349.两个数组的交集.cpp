using namespace std;
#include <vector>
#include <unordered_set>

class Solution
{
public:
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2)
    {
        unordered_set<int> result_set; // 存放结果，之所以用set是为了给结果集去重
        unordered_set<int> nums_set(nums1.begin(), nums1.end());
        for (int num : nums2)
        {
            // 发现nums2的元素 在nums_set里又出现过

            // 在nums_set中查找当前遍历到的元素num。如果find函数返回的迭代器不等于end()
            // ，说明num在nums_set中存在，即num在nums1中也存在。
            if (nums_set.find(num) != nums_set.end()) // 注意：这里不能写成if(nums_set.find(num) != nums_set.end()-1)
            {
                result_set.insert(num);
            }
        }
        return vector<int>(result_set.begin(), result_set.end());
    }
};