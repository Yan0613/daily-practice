using namespace std;
#include <stddef.h>
struct ListNode
{
    int val;                                // 节点上存储的元素
    ListNode *next;                         // 指向下一个节点的指针
    ListNode(int x) : val(x), next(NULL) {} // 节点的构造函数
};

class Solution
{
public:
    ListNode *reverse(ListNode *head)
    {
        ListNode *prev = NULL;
        ListNode *curr = head;
        ListNode *next;
        while (curr != NULL)
        {
            next = curr->next;
            curr->next = prev; // 翻转操作
            prev = curr;
            curr = next;
        }

        return prev;
    }
};