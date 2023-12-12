package tree.bst;

import tree.TreeNode;

/**
 * Leetcode 98. Validate Binary Search Tree
 */
public class Program05 {
    // m-1 inorder is sorted in BST
    // compare every node with prev node value
    long prevNodeValue = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST1(root.left);

        if (prevNodeValue >= root.val) {
            return false;
        }
        prevNodeValue = root.val;


        boolean right = isValidBST1(root.right);

        return left && right;
    }

    // range method
    // left subtree node's data lies b/n -infinity to node's data
    // right subtree node's data lies b/n node's data to infinity
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean solve(TreeNode root, long start, long end) {
        if (root == null) {
            return true;
        }

        if (root.val <= start || root.val >= end) {
            return false;
        }

        boolean left = solve(root.left, start, root.val);
        boolean right = solve(root.right, root.val, end);

        return left && right;
    }
}
