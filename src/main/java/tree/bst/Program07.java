package tree.bst;

import tree.TreeNode;

/**
 * Leetcode 230. Kth Smallest Element in a BST
 * <p>
 * Inorder of BST is sorted
 * Do inorder traversal and increase count at every node
 * When count becomes equal to K then it's the answer
 */
public class Program07 {
    int count;
    TreeNode ans;

    public int kthSmallest(TreeNode root, int k) {
        count = 1;
        ans = null;
        solve(root, k);

        return ans != null ? ans.val : null;
    }

    public void solve(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        solve(root.left, k);

        if (count == k) {
            ans = root;
        }

        count++;

        solve(root.right, k);
    }
}
