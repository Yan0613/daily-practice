class Solution
{
public:
    int minLength(string s)
    {
        vector<char> strArr(s.begin(), s.end());
        vector<int> res;
        res.push_back(strArr[0]);
        for (int i = 1; i < strArr.size(); i++)
        {
            res.push_back(strArr[i]);
            int m = res.size();
            if (m >= 2 && (res[m - 2] == 'A' && res[m - 1] == 'B' || res[m - 2] == 'C' && res[m - 1] == 'D'))
            {
                res.pop_back();
                res.pop_back();
            }
        }
        return res.size();
    }
};