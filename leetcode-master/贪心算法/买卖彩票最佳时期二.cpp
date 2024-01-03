class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        // int maxProfit = INT32_MIN;
        int result = 0;
        for (int i = 1; i < prices.size(); i++)
        {
            result += max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
};

// class Solution {
// public:
//     int maxProfit(vector<int>& prices) {
//         // int maxProfit = INT32_MIN;
//         int result = 0;
//         for(int i = 0 ; i < prices.size() -1; i++){
//             result += max(prices[i+1] - prices[i], 0);
//         }
//         return result;
//     }
// };