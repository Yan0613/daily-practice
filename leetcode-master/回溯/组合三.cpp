class Solution
{
    vector<vector<int>> res;
    vector<int> path;
private
    void backtracking(int k, int targetSum, int sum, int startIndex)
    {
        if (path.size() == k)
        {
            if (sum == targetSum)
            {
                res.push_back(path);
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++)
        {
            sum += i;
            path.push_back(i);
            backtracking(k, targetSum, sum, i + 1); // 处理节点
            sum -= i;                               // 回溯
            path.pop_back();                        // 回溯
        }
    }
}