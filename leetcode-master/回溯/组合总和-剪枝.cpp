class Solution
{
public:
    vector<vector<int>> res;
    vector<int> path;
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        sort(candidates.begin(), candidates.end()); // 需要排序
        backtracing(0, target, candidates, 0);
        return res;
    }

    void backtracing(int sum, int target, vector<int> &candidates, int startindex)
    {
        if (sum > target)
        {
            return;
        }
        if (sum == target)
        {
            res.push_back(path);
            return;
        }
        for (int i = startindex; i < candidates.size() && sum + candidates[i] <= target; i++)
        {
            sum += candidates[i];
            path.push_back(candidates[i]);
            backtracing(sum, target, candidates, i);
            sum -= candidates[i]; // 回溯
            path.pop_back();      // 回溯
        }
    }
};