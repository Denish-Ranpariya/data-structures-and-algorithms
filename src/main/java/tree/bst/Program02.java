package tree.bst;

import tree.Node;

/**
 * Minimum element in BST
 * <p>
 * left most element is smallest
 *
 * also can be done with recursive method
 */
public class Program02 {
    int minValue(Node root) {
        //left most element is smallest

        if (root == null) {
            return -1;
        }

        Node prev = null;
        Node current = root;

        while (current != null) {
            prev = current;
            current = current.left;
        }

        return prev.data;
    }
}
