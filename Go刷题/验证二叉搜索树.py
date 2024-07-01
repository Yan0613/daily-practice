class Solution:
    def isValidBST(self, root: Optional[TreeNode], left=-inf, right=inf) -> bool:
        if root is None:
            return True
        x = root.val
        return left < x < right and \
               self.isValidBST(root.left, left, x) and \
               self.isValidBST(root.right, x, right)
