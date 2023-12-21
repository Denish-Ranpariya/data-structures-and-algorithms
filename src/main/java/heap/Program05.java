package heap;

import tree.Node;

import java.util.ArrayList;

/**
 * GFG - BST to max heap
 * <p>
 * For explanation : one note -> heaps
 */
public class Program05 {
    static ArrayList<Integer> inorder;
    static int index;

    public static void convertToMaxHeapUtil(Node root) {
        inorder = new ArrayList<>();
        inorder(root);
        index = 0;

        postorder(root);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        inorder.add(root.data);

        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);

        root.data = inorder.get(index++);
    }
}
