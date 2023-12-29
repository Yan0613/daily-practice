class Solution
{
public:
    vector<vector<int>> res;
    vector<int> path;
    void backtracking(int target, int sum, vector<int> &candidates, int startIndex)
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
        for (int i = startIndex; i < candidates.size(); i++)
        {
            sum += candidates[i];
            path.push_back(candidates[i]);
            backtracking(target, sum, candidates, i); // 不用i+1，表示可以重复读取当前的数
            sum -= candidates[i];                     // 回溯
            path.pop_back();                          // 回溯
            // 注意：由于每个数字在每个组合中只能使用一次，因此递归时应该从下一位置开始。
        }
    }