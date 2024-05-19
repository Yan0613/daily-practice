func getIntersectionNode(headA, headB *ListNode) *ListNode {
    l1,l2 := headA, headB
    for l1 != l2 {
        if l1 != nil {
            l1 = l1.Next
        } else {
            l1 = headB
        }

        if l2 != nil {
            l2 = l2.Next
        } else {
            l2 = headA
        }
    }

    return l1
}
//这个方法的关键在于两个指针在两次遍历中都走过了相同的节点数。如果两个链表有交点，指针在第二次遍历时会在交点处相遇。如果没有交点，两个指针会在第二次遍历的末尾同时变为nil。妙！