package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 199. Binary Tree Right Side View
 */
public class Program11 {

    // M-2 using recursion
    // NRL
    // when level is equal to size of result then add current node to result
    List<Integer> result;

    // M-1 using level order traversal
    // take last element at every level
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            TreeNode current = null;

            for (int i = 0; i < size; i++) {
                current = q.remove();

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }

            }

            //insert last element of current level in result
            result.add(current.val);
        }
        return result;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        result = new ArrayList<>();
        //initial level is zero
        solve(root, 0);
        return result;
    }

    void solve(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        // level is equal to size of result then add current node to result
        if (level == result.size()) {
            result.add(root.val);
        }

        //call for right and left subtree also level + 1
        solve(root.right, level + 1);
        solve(root.left, level + 1);
    }
}
