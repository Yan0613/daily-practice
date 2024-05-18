struct ListNode type{
	var int
	var NextNode *ListNode
}

func reverseList(head *ListNode)  *ListNode{
	if head == nil {
		return nil
	}
	if head.Next == nil {
	    return head
	}

	var pre *ListNode = head
	var cur *ListNode = head.Next
	var temp *ListNode
	for cur != nil {
		temp = cur.Next
	    cur.Next = pre
		pre = cur
		cur = temp
	}

	return pre
}