class Solution
{
private:
    vector<vector<string>> res;
    vector<string> path;
    void backtracing(string s, int startIndex)
    {
        if (startIndex >= s.size())
        {
            res.push_back(path);
            return;
        }
        for (int i = startIndex; i < s.size(); i++)
        {
            /* code */
            if (isPalindrome(s, startIndex, i))
            {
                string str = s.substr(startIndex, i - startIndex + 1);
                path.push_back(str);
            }
            else
            {
                continue;
            }
            backtracing(s, i + 1);
            path.pop_back(str);
        }
    }

    bool isPalindrome(const string &s, int start, int end)
    {
        for (int i = start, j = end; i < j; i++, j--)
        {
            if (s[i] != s[j])
            {
                return false;
            }
        }
        return true;
    }
}
// 如果你省略了 else 里面的内容，即使条件不满足，仍然会执行下面的递归调用和 path.pop_back()。这可能导致在回溯的过程中，path 中的元素没有正确还原，影响最终结果。