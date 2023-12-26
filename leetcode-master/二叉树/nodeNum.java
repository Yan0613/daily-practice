class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class nodeNum {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int treeNum = leftNum + rightNum + 1;
        return treeNum;
    }
}
