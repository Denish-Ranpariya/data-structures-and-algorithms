package tree.bst;

import tree.Node;

/**
 * Insert a node in a BST
 */
public class Program01 {
    // M-1 using recursion
    Node insert1(Node root, int key) {

        //create new node
        Node newNode = new Node(key);

        // if root is null then make it root and return
        if (root == null) {
            root = newNode;
            return root;
        }

        // if key is already there in the root no need to add it again
        if (root.data == key) {
            return root;
        }

        // if key is smaller add it to left sub tree otherwise right subtree
        if (root.data > key) {
            root.left = insert1(root.left, key);
        } else {
            root.right = insert1(root.right, key);
        }
        return root;
    }

    //M-2 using iterative method
    Node insert(Node root, int key) {
        Node newNode = new Node(key);

        // if root is null then make it root and return
        if (root == null) {
            root = newNode;
            return root;
        }

        // to keep track of previous node
        Node prev = null;
        Node current = root;


        while (current != null) {
            if (current.data == key) {
                // if key is already there in the root no need to add it again
                return root;
            } else if (current.data < key) {
                prev = current;
                current = current.right;
            } else {
                prev = current;
                current = current.left;
            }
        }

        //now prev is at leaf node but don't know where to add, left or right
        if (key < prev.data) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }

        return root;
    }
}
