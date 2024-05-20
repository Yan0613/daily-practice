func detectCycle(head *ListNode) *ListNode {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {//因为Fast一次要走两步，所以需要判断fast.Next是否为空
        slow = slow.Next
        fast = fast.Next.Next
        //快慢指针相遇，此时可以确定有环，接下来找环形入口的位置
        if slow == fast {
            for slow != head {
                slow = slow.Next
                head = head.Next
            }
            return head
        }
    }
    return nil
}