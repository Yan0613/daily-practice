class Solution
{
public:
    bool lemonadeChange(vector<int> &bills)
    {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills)
        {
            // 情况一
            if (bill == 5)
                five++;
            // 情况二
            if (bill == 10)
            {
                if (five <= 0)
                    return false;
                ten++;
                five--;
            }
            // 情况三
            if (bill == 20)
            {
                // 优先消耗10美元，因为5美元的找零用处更大，能多留着就多留着
                if (five > 0 && ten > 0)
                {
                    five--;
                    ten--;
                    twenty++; // 其实这行代码可以删了，因为记录20已经没有意义了，不会用20来找零
                }
                else if (five >= 3)
                {
                    five -= 3;
                    twenty++; // 同理，这行代码也可以删了
                }
                else
                    return false;
            }
        }
        return true;
    }
};