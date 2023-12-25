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

public class issymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        if (left.val != right.val)
            return false;
        // 比较外侧
        boolean outside = isSymmetric(left.left, right.right);
        // 比较内侧
        boolean inside = isSymmetric(left.right, right.left);
        return outside && inside;
    }
}