/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next; // 保存下一个节点的引用
            cur.next = res; // 将当前节点的下一个节点指向新的链表头部
            res = cur; // 更新新的链表头部为当前节点
            cur = nextNode; // 移动到下一个节点
        }

        return res;
    }
}
