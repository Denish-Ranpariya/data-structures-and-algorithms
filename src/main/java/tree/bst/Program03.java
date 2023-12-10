package tree.bst;

import tree.TreeNode;

/**
 * Leetcode 700. Search in a Binary Search Tree
 * <p>
 * as binary search tree follows property of sorted order in inorder we can use binary search algorithm
 */
public class Program03 {

    // recursive method
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }

    // iterative method
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;

        while (current != null) {
            if (current.val == val) {
                return current;
            } else if (current.val < val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return null;
    }
}
