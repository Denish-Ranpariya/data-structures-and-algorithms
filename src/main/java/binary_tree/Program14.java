package binary_tree;

import java.util.ArrayList;
import java.util.Collections;

public class Program14 {
    ArrayList<Integer> leftNodes;
    ArrayList<Integer> rightNodes;
    ArrayList<Integer> leafNodes;

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        leftNodes = new ArrayList<>();
        rightNodes = new ArrayList<>();
        leafNodes = new ArrayList<>();

        //add root node first
        result.add(root.data);

        //if root node is the only node
        if (root.left == null && root.right == null) {
            return result;
        }

        getLeftNodes(root.left);
        getRightNodes(root.right);
        getLeafNodes(root);

        // remove last node from left because it will be leaf
        if (!leftNodes.isEmpty()) {
            leftNodes.remove(leftNodes.size() - 1);
        }

        // remove last node from right because it will be leaf
        if (!rightNodes.isEmpty()) {
            rightNodes.remove(rightNodes.size() - 1);
        }

        //reverse right nodes
        Collections.reverse(rightNodes);

        //add all to result
        result.addAll(leftNodes);
        result.addAll(leafNodes);
        result.addAll(rightNodes);

        return result;
    }

    public void getLeftNodes(Node root) {
        if (root == null) {
            return;
        }

        leftNodes.add(root.data);

        // either go left or right
        // not both - IMP
        if (root.left != null) {
            getLeftNodes(root.left);
        } else if (root.right != null) {
            getLeftNodes(root.right);
        }
    }


    public void getRightNodes(Node root) {
        if (root == null) {
            return;
        }

        rightNodes.add(root.data);

        // either go right or left
        // not both - IMP
        if (root.right != null) {
            getRightNodes(root.right);
        } else if (root.left != null) {
            getRightNodes(root.left);
        }
    }

    //preorder
    public void getLeafNodes(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafNodes.add(root.data);
        }

        getLeafNodes(root.left);
        getLeafNodes(root.right);
    }
}
