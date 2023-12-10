package tree.binary_tree;

import tree.TreeNode;

/**
 * leetcode 236. Lowest Common Ancestor of a Binary Tree
 * see this youtube video : https://www.youtube.com/watch?v=_-QHfMDde90
 */
public class Program05 {
    //simple pre order traversal
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //if current node is null then return null
        if (root == null) {
            return null;
        }

        //if current node is p then return current node
        if (root.val == p.val) {
            return p;
        }

        //if current node is q then return current node
        if (root.val == q.val) {
            return q;
        }

        //recursive left and right call
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; //both non null, return current node
        } else if (left != null && right == null) {
            return left; //return non null
        } else if (left == null && right != null) {
            return right; //return non null
        } else {
            return null; //both null return null
        }
    }
}
