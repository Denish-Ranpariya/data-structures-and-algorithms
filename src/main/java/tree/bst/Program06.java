package tree.bst;

import tree.TreeNode;

/**
 * Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class Program06 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base case
        if (root == null) {
            return null;
        }

        // if one of the node is found
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // p and q are in different sides
        if (p.val < root.val && q.val > root.val || q.val < root.val && p.val > root.val) {
            return root;
        } else if (p.val < root.val || q.val < root.val) {
            //p and q are in left side
            return lowestCommonAncestor(root.left, p, q);
        } else {
            //p and q are in right side
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
