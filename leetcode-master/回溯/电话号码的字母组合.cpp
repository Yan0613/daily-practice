class Solution
{
    const string Map[10] = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

private:
    vector<string>
        result;
    string path;
    void backtracking(const string &digits, int index)
    {
        if (index == digits.size())
        {
            result.push_back(path);
            return;
        }
        int digit = digits[index] - '0';
        string letters = Map[digit];
        for (int i = 0; i < letters.size(); i++)
        {
            path.push_back(letters[i]);
            backtracking(digits, index + 1);
            path.pop_back();
        }
    }
}