using namespace std;
#include <vector>
class Solution
{
public:
    vector<int> sortedSquares(vector<int> &A)
    {
        int k = A.size() - 1;
        vector<int> result(A.size(), 0);
        for (int i = 0, j = A.size() - 1; i <= j;)
        { // 注意这里要i <= j，因为最后要处理两个元素
            if (A[i] * A[i] < A[j] * A[j])
            {
                result[k--] = A[j] * A[j];
                j--;
            }
            else
            {
                result[k--] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }
};