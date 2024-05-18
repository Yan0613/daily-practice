/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func removeElements(head *ListNode, val int) *ListNode {

	//依旧是先定义逻辑

	//如果原链表的头节点为val的话，head=head.next，且为持续过程，防止头节点后面的节点也为Val
	//这里前置循环 并且要判定head 是否为nil，防止出错
	for head != nil && head.Val == val {//由于leetcode代码运行方式，for循环条件判断前后顺序不能修改，下面的for循环也同样如此
		head = head.Next
	}
	cur := head

	for cur != nil && cur.Next != nil {
		if cur.Next.Val == val {
			cur.Next = cur.Next.Next
		} else {
			cur = cur.Next
		}
	}

	return head

}