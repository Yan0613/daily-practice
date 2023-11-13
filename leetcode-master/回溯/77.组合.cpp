// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

// 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
using namespace std;
#include <vector>
class Solution
{
public:
    vector<vector<int>> combine(int n, int k)
    {
        vector<vector<int>> res;
        vector<int> temp;
        dfs(res, temp, n, k, 1);
        return res;
    }
    void dfs(vector<vector<int>> &res, vector<int> &temp, int n, int k, int start)
    {
        if (temp.size() == k)
        {
            res.push_back(temp);
            return;
        }
        for (int i = start; i <= n; i++)
        {
            temp.push_back(i); // 处理节点
            dfs(res, temp, n, k, i + 1);
            temp.pop_back(); // 回溯，撤销处理的节点
        }
    }
};