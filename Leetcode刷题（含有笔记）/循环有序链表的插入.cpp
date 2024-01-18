/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution
{
public
    Node insert(Node head, int insertVal)
    {
        if (head == null)
        {
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }

        Node pre = head;
        Node curr = head.next;

        while (!(pre.val <= insertVal && insertVal <= curr.val) &&
               !(pre.val > curr.val && (insertVal >= pre.val || insertVal <= curr.val)))
        {
            pre = pre.next;
            curr = curr.next;

            // 如果遍历一圈仍未找到插入位置，说明所有元素相等，可以在任意位置插入
            if (pre == head)
            {
                break;
            }
        }

        Node newNode = new Node(insertVal);
        pre.next = newNode;
        newNode.next = curr;

        return head;
    }
}
