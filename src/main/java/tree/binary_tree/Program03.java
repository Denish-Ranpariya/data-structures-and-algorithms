package tree.binary_tree;

import tree.TreeNode;

/**
 * Leetcode 104. Maximum Depth/Height of Binary Tree
 */
public class Program03 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
