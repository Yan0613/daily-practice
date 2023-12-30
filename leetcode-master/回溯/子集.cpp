class Solution
{
private:
    vector<vector<int>> res;
    vector<int> path;
    void backtracing(vector<int> &nums, int startIndex)
    {
        res.push_back(path); // 收集子集，要放在终止添加path的代码之前
        if (startIndex > nums.size())
        {
            return;
        }
        for (int i = startIndex; i < nums.size(); i++)
        {
            path.push_back(nums[i]);
            backtracing(nums, i + 1);
            path.pop_back();
        }
    }
}