import java.util.HashSet;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class circleListNode {
    public ListNode detectCycle(ListNode head) {
        HashSet<Integer> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr.data)) {
                return curr; // Return the node where the cycle starts
            } else {
                visited.add(curr.data);
                curr = curr.next;
            }
        }

        return null; // No cycle found
    }
}
