func getIntersectionNode(head A, headB *ListNode) *ListNode {
	curA, curB := head, headB
	//计算链表长度
	lenA, lenB := 0, 0
	for curA != nil {
	    curA = curA.Next
	    lenA++
	}
	for curB != nil {
	    curB = curB.Next
		lenB++
	}
	gap := lenA - lenB
	if gap < 0 {
		gap = lenB - lenA
		curA, curB = headB, headA
	}
	for gap > 0 {
		curA = curA.Next
		gap--
	}
	for curA != nil {
		if curA == curB {
			return curA
		}
		curA = curA.Next
		curB = curB.Next
	}
	return nil
		
	
}