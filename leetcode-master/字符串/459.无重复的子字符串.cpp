using namespace std;
#include <string>
class Solution
{
public:
    bool repeatedSubstringPattern(string s)
    {
        string t = s + s;
        t.erase(t.begin());
        t.erase(t.end() - 1); // 掐头去尾
        if (t.find(s) != std::string::npos)
            return true; // r
        return false;
    }
};