using namespace std;
#include <vector>
class solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int n = nums.size();
        int l = 0, r = n - 1;
        int mid = (l + r) / 2;
        while (l <= r)
        {
            mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                r = mid - 1;
        }

        return mid;
    }
};
//(left + (right - left) / 2) 来防止溢出，这是一个比 (left + right) / 2 更安全的方式。