using namespace std;
#include <stddef.h>
// 单链表
struct ListNode
{
    int val;                                // 节点上存储的元素
    ListNode *next;                         // 指向下一个节点的指针
    ListNode(int x) : val(x), next(NULL) {} // 节点的构造函数
};

class Solution
{
public:
    ListNode *swapPairs(ListNode *head)
    {
        ListNode *dummyHead = new ListNode(0); // 设置一个虚拟头结点
        dummyHead->next = head;                // 将虚拟头结点指向head，这样方便后面做删除操作
        ListNode *cur = dummyHead;
        while (cur->next != nullptr && cur->next->next != nullptr)
        {
            ListNode *tmp = cur->next;              // 记录临时节点
            ListNode *tmp1 = cur->next->next->next; // 记录临时节点

            cur->next = cur->next->next;  // 步骤一
            cur->next->next = tmp;        // 步骤二
            cur->next->next->next = tmp1; // 步骤三

            cur = cur->next->next; // cur移动两位，准备下一轮交换
        }
        return dummyHead->next;
    }
};