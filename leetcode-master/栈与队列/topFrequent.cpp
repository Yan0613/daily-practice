using namespace std;

public:
class Solution
{
    class myComparation
    {
    public:
        bool operator()(const pair<int, int> &a, const pair<int, int> &b)
        {
            return a.second > b.second;
        }
    };

    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        // 统计
        unordered_map<int, int> mp;
        for (int i = 0; i < nums.size(); i++)
        {
            mp[nums[i]]++;
        }

        // 录入小顶堆
        priority_queue<pair<int, int>, vector<pair<int, int>>, myComparation> pq;
        for (auto it = mp.begin(); it != mp.end(); it++)
        {
            pq.push(*it);
            if (pq.size > k)
            {
                pq.pop();
            }
        }

        // 逆序输出
        vector<int> res;
        while (!pq.empty())
        {
            res.push_back(pq.top().first);
            pq.pop();
        }

        return res;
    }
}