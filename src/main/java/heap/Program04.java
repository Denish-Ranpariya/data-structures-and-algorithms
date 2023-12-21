package heap;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 958. Check Completeness of a Binary Tree
 * <p>
 * for explanation -> one note -> heaps
 */
public class Program04 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean isNullDetected = false;

        while (!q.isEmpty()) {
            TreeNode currentNode = q.remove();

            if (currentNode == null) {
                isNullDetected = true;
            } else {
                if (isNullDetected) {
                    return false;
                }

                q.add(currentNode.left);
                q.add(currentNode.right);
            }
        }

        return true;
    }
}
