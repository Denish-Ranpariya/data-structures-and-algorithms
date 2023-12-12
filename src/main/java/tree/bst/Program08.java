package tree.bst;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * Leetcode 653. Two Sum IV - Input is a BST
 * <p>
 * Inorder of BST is sorted so do inorder traversal and save the sequence
 * Now apply two pointer on this sorted list
 */
public class Program08 {
    ArrayList<Integer> inorder;

    public boolean findTarget(TreeNode root, int k) {
        inorder = new ArrayList<>();
        getInorder(root);

        int n = inorder.size();

        if (n < 2) {
            return false;
        }

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = inorder.get(start) + inorder.get(end);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public void getInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        getInorder(root.left);

        inorder.add(root.val);

        getInorder(root.right);
    }
}
