class Solution
{
private:
    vector<vector<int>> res;
    vector<int> path;
    void backtracing(int startIndex, vector<int> &nums, vector<bool> &used)
    {
        res.push_back(path);
        for (int i = startIndex; i < nums.size(); i++)
        {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
            {
                continue;
            }
            path.push_back(nums[i]);
            used[i] = true;
            backtracing(i + 1, nums, used);
            used[i] = false; // 回溯
            path.pop_back(); // 回溯
        }
    }

public:
    vector<vector<int>> subsetsWithDup(vector<int> &nums)
    {
        result.clear();
        path.clear();
        vector<bool> used(nums.size(), false);
        sort(nums.begin(), nums.end()); // 去重需要排序
        backtracking(nums, 0, used);
        return result;
    }
}