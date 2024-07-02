package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	flatten(root.Left)
	flatten(root.Right)

	//
	right_sub := root.Right
	root.Left, root.Right = nil, root.Left

	p := root //找到左子树的最右节点
	for p != nil && p.Right != nil {
		p = p.Right
	}
	p.Right = right_sub

}
