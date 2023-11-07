using namespace std;
#include <iostream>
#include <vector>

class Solution
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int size = nums.size();
        for (int i = 0; i < size; i++)
        {
            if (nums[i] == val)
            {
                // remove
                for (int j = i + 1; j < size; j++)
                {
                    nums[j - 1] = nums[j];
                }

                i--;    // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
    }
};

// 为了确保不漏掉任何一个可能等于 val 的元素，代码执行 i-- 以重新检查当前位置 i 的元素，
// 因为在元素被前移后，下一个元素的值会被移到当前位置 i 处。