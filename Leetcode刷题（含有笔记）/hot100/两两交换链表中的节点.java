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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        if (head == null || head.next == null) {
            return head;
        }

        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            pre.next = second;

            // Move pre to the next pair
            pre = pre.next.next;
        }

        return dummy.next;
    }
}