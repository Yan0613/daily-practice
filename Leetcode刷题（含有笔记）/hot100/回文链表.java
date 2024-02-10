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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = new ListNode();
        cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        int[] arr = new int[len];
        cur = head;
        int i = 0;
        while (cur != null) {
            arr[i] = cur.val;
            cur = cur.next;
            i++;
        }
        int pre = 0;
        int last = len - 1;
        while (pre <= last) {
            if (arr[pre] != arr[last]) {
                return false;
            }
            pre++;
            last--;
        }
        return true;

    }
}
