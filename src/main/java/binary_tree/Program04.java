package binary_tree;

/**
 * Leetcode 543. Diameter of Binary Tree
 */
public class Program04 {

    //M1
    //this method is calling height function for each node so complexity is very high
    public int diameterOfBinaryTree1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //find diameter of left subtree
        int leftDiameter = diameterOfBinaryTree1(root.left);

        //find diameter of right subtree
        int rightDiameter = diameterOfBinaryTree1(root.right);


        //calculate diameter in which current root is part of
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int currentDiameter = leftHeight + rightHeight;

        //max of above three
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    int max = 0; //instance variable
    //M2
    public int diameterOfBinaryTree(TreeNode root) {

        height1(root);
        return max;
    }

    //modified height method in which diameter is also getting calculated at every node
    public int height1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = height1(root.left);
        int right = height1(root.right);

        max = Math.max(max, left + right); // new line to calculate max diameter at current node

        return 1 + Math.max(left, right);
    }
}
