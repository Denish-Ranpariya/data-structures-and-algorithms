package tree.binary_tree;


import tree.TreeNode;

/**
 * Leetcode 112. Path Sum
 */
public class Program06 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return solve(root, sum, targetSum);
    }

    public boolean solve(TreeNode root, int sum, int targetSum) {

        //if current node is null then no path exists which has path to leaf as target sum so return false
        if (root == null) {
            return false;
        }

        //add current node val to sum
        sum += root.val;

        //check if current node is leaf or not
        if (root.left == null && root.right == null) {

            //check if sum is equal to target sum or not
            if (sum == targetSum) {
                return true;
            }
        }

        //recursive call to left and right
        boolean left = solve(root.left, sum, targetSum);
        boolean right = solve(root.right, sum, targetSum);

        // if left sub-tree or right sub-tree contains a path to leaf with sum as target sum then return true, so or operation
        return left || right;
    }
}
