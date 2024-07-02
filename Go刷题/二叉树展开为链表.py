# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        right = root.right
        self.flatten(root.left)
        self.flatten(root.right)
        root.left, root.right = None, root.left
        node = root
        while node.right:
            node = node.right
        node.right = right
