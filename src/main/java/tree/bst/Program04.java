package tree.bst;

import tree.TreeNode;

/**
 * Leetcode 450. Delete Node in a BST
 * <p>
 * for explanation -> one note -> BST
 * MMIMP
 */
public class Program04 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // when node is found
        if (root.val == key) {

            // if it's a leaf node then return null
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                // left child in non-null then return left subtree
                return root.left;
            } else if (root.left == null && root.right != null) {
                // right child in non-null then return right subtree
                return root.right;
            } else {
                //MIMP case
                //find largest node's value in left subtree
                int inorderPredecesor = findInorderPredecesor(root);

                //replace
                root.val = inorderPredecesor;

                // delete node with the largest value in left subtree and attach it to left
                root.left = deleteNode(root.left, inorderPredecesor);
                return root;
            }

        } else if (root.val > key) {
            // delete in left subtree and attach it to left
            root.left = deleteNode(root.left, key);
        } else {
            // delete in right subtree and attach it to right
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // method to find the largest value in left subtree
    public int findInorderPredecesor(TreeNode root) {
        TreeNode current = root.left;

        while (current.right != null) {
            current = current.right;
        }

        return current.val;
    }
}
