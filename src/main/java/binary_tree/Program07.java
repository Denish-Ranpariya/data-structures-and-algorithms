package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Kth Ancestor in a Tree - GFG
 * <p>
 * find the path from root to node and return kth element
 */
public class Program07 {
    List<Node> pathToRoot;

    public int kthAncestor(Node root, int k, int node) {
        pathToRoot = new ArrayList<>();
        findPathToRoot(root, node);

        if (k < pathToRoot.size()) {
            return pathToRoot.get(k).data;
        }

        return -1;
    }

    // method to find node to root path
    public boolean findPathToRoot(Node root, int target) {

        //if current node is null
        if (root == null) {
            return false;
        }

        //if current node is teh target node then add it to list
        if (root.data == target) {
            pathToRoot.add(root);
            return true;
        }

        //check if target node exists in left sub-tree, if exists then add current node to the list
        boolean left = findPathToRoot(root.left, target);
        if (left) {
            pathToRoot.add(root);
            return true;
        }

        //check if target node exists in right sub-tree, if exists then add current node to the list
        boolean right = findPathToRoot(root.right, target);
        if (right) {
            pathToRoot.add(root);
            return true;
        }

        //target node doesn't exists
        return false;
    }
}
