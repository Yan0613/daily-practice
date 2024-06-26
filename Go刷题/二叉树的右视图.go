func rightSideView(root *TreeNode) (ans []int) {
    var dfs func(*TreeNode, int)
    dfs = func(node *TreeNode, depth int) {
        if node == nil {
            return
        }
        if depth == len(ans) { // 这个深度首次遇到
            ans = append(ans, node.Val)
        }
        dfs(node.Right, depth+1) // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(node.Left, depth+1)
    }
    dfs(root, 0)
    return
}
