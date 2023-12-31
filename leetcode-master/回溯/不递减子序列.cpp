// unordered_set_name.find(key)
// 找得到就返回迭代器，找不到就返回末尾

class Solution
{
private:
    vector<vector<int>> res;
    vector<int> path;
    unordered_set<int> used;
    void backtrakcing(int startIndex, vector<int> &nums)
    {
        if (path.size() >= 2)
        {
            res.push_back(path);
            // return;
        }
        for (int i = startIndex, i < nums.size(); i++)
        {
            if (!path.empty() && nums[i] < path.back() || used.find(nums[i]) != used.end())
            {
                continue;
            }
            used.insert(nums[i]);
            path.insert(nums[i]);
            backtrakcing(i + 1, nums);
            path.pop_back();
        }
    }
}

// https://leetcode.cn/problems/non-decreasing-subsequences/solutions/2585737/491-fei-di-jian-zi-xu-lie-by-mixiyan-5rbw/
// 解题思路记录↑