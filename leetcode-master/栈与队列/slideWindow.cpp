using namespace std;
#include <deque>
class Solution
{
public:
    class MyDeque
    {
    public:
        deque<int> dq;
        void push(int val)
        {
            if (val > dq.front() && !dq.empty())
            {
                dq.pop_back();
            }
            else
            {
                dq.push_back(val);
            }
        }

        void pop(int val)
        {
            if (val == dq.front() && !dq.empty())
            {
                dq.pop_front();
            }
        }

        int front()
        {
            return dq.front();
        }
    };

public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k)
    {
        MyDeque mydeque = new MyDeque();
        vector<int> result;
        for (int i = 0; i < k; i++)
        {
            mydeque.push(nums[i]);
        }
        result.push_back(mydeque.front());
        for (int i = k; i < nums.size(); i++)
        {
            mydeque.pop(nums[i - k]);
            mydeque.push(nums[i]);
            result.push_back(mydeque.front());
        }
        return result;
    }
};