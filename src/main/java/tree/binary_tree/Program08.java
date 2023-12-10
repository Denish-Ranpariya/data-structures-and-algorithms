package tree.binary_tree;

import tree.TreeNode;

/**
 * Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * preorder has root as it's first element
 */
public class Program08 {

    //index for preorder
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        //create new node from preorder and increase index of preorder by 1
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;

        //search for node in inorder
        int index = searchInorder(inorder, start, end, root.val);

        //for left start to index - 1
        root.left = solve(preorder, inorder, start, index - 1);

        //for right index + 1 to end
        root.right = solve(preorder, inorder, index + 1, end);

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
