package tree.binary_tree;

import tree.TreeNode;

/**
 * Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * same as construct binary tree from inorder and preorder but
 * only difference is in postorder start from last
 * and recursive call for right node will be before left subtree
 * <p>
 * Reason :
 * in preorder we are start from right, so in NLR first comes left and then right
 * but in postorder we are starting from left as root will be at very last,
 * so in LRN first comes right and then left
 */
public class Program09 {
    int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        return solve(postorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        //create new node from postorder and decrease index of preorder by 1
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        postorderIndex--;

        //search for node in inorder
        int index = searchInorder(inorder, start, end, root.val);

        //for right index + 1 to end
        root.right = solve(postorder, inorder, index + 1, end);

        //for left start to index - 1
        root.left = solve(postorder, inorder, start, index - 1);

        //return the node
        return root;
    }

    //function to find index in inorder
    public int searchInorder(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
