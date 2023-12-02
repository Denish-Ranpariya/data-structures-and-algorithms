package binary_tree;

import java.util.Scanner;

public class Program01 {
    public static void main(String[] args) {
        Node root = createBinaryTree();
        preorderTraversal(root);
    }

    public static Node createBinaryTree() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value : ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);
        newNode.left = createBinaryTree();
        newNode.right = createBinaryTree();

        return newNode;
    }

    // node left right -> NLR
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // left right node -> LRN
    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // left node right -> LNR
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}
