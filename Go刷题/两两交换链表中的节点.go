func swapPairs(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	if head.Next == nil {
	    return head
	}
	dummy := &ListNode{Next: head}
	pre : =dummy
	while pre.Next != nil && pre.Next.Next != nil {
	    temp := pre.Next
		temp2 := pre.Next.Next
		pre.Next = temp.Next
		temp.Next = temp2.Next
		temp2.Next = temp
		pre = temp//很重要
	}
	return dummy.Next
}