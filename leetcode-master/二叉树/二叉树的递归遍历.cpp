using namespace std;
#include <stddef.h>
#include <vector>
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution
{
public:
    void traversal(TreeNode *node, vector<int> &vec)
    {
        if (node == NULL)
            return;
        traversal(node->left, vec);  // 左
        vec.push_back(node->val);    // 中
        traversal(node->right, vec); // 右
        // 中序遍历：中左右
        //  vec.push_back(node->val);
        //  traversal(node->left, vec);
        //  traversal(node->right, vec);
        // 后序遍历：左右中
        //  traversal(node->left, vec);
        //  traversal(node->right, vec);
        //  vec.push_back(node->val);
    }

    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> vec;
        traversal(root, vec);
        return vec;
    }
};
