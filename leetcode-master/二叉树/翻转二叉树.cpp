class Solution
{
public:
    TreeNode *invertTree(TreeNode *root)
    {
        if (root == NULL)
            return root;
        swap(root->left, root->right); // 中
        invertTree(root->left);        // 左
        invertTree(root->right);       // 右
        return root;
    }
};