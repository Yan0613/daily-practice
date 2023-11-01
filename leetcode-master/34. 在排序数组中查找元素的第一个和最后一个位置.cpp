using namespace std;
#include <vector>
#include <iostream>
class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2)
            return {-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1)
            return {leftBorder + 1, rightBorder - 1};
        // 情况二
        return {-1, -1};
    }

private:
    int getRightBorder(vector<int> &nums, int target)
    {
        int left = 0;
        int right = nums.size() - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right)
        {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target)
            {
                right = middle - 1;
            }
            else
            { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
    int getLeftBorder(vector<int> &nums, int target)
    {
        int left = 0;
        int right = nums.size() - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right)
        {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target)
            { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            }
            else
            {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
};

// 寻找target在数组里的左右边界，有如下三种情况：

// 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
// 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
// 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
int main(int argc, char const *argv[])
{
    std::vector<int> nums = {1, 2, 3, 4, 4, 5};              // 定义并初始化一个整数向量
    Solution solution;                                       // 创建 Solution 类的对象
    std::vector<int> result = solution.searchRange(nums, 4); // 调用 searchRange 函数
    // 输出结果
    for (int num : result)
    {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    return 0;
}
