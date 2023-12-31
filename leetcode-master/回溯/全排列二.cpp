class Solution
{
public:
    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        // sort(nums.begin(), nums.end()); // 排
        vector<bool> used(nums.size(), false);
        backtracking(nums, used);
        return res;
    }

    vector<vector<int>> res;
    vector<int> path;
    void backtracking(vector<int> &nums, vector<bool> &used)
    {
        if (path.size() == nums.size())
        {
            res.push_back(path);
            return;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            // 数字用过，跳过不处理,树层去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false || used[i] == true)
            {
                continue;
            }
            used[i] = true;
            path.push_back(nums[i]);
            // 没有用过，处理子节点
            backtracking(nums, used);
            used[i] = false;
            path.pop_back();
        }
    }
};