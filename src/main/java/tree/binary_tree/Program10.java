package tree.binary_tree;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GFG - Left View of Binary Tree
 */
public class Program10 {
    ArrayList<Integer> result; // used for M-2

    // M-1 using level order traversal
    // take first element at every level
    public ArrayList<Integer> leftView1(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            //add first element of level to result
            result.add(q.peek().data);

            for (int i = 0; i < size; i++) {
                Node current = q.remove();
                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }

        return result;
    }

    // M-2 using recursion
    // preorder traversal - NLR
    // when level is equal to size of result then add current node to result
    public ArrayList<Integer> leftView2(Node root) {
        result = new ArrayList<>();

        //initial level is zero
        solve(root, 0);

        return result;
    }

    void solve(Node root, int level) {
        if (root == null) {
            return;
        }

        // level is equal to size of result then add current node to result
        if (level == result.size()) {
            result.add(root.data);
        }

        //call for left and right subtree also level + 1
        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }
}
