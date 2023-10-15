package recursion;

/**
 * Maximize The Cut Segments
 * <p>
 * GFG
 * <p>
 * will give TLE in recursion
 * <p>
 * better approach is DP
 */
public class Program15 {

    // explore all possible ways
    public int maximizeCuts(int n, int x, int y, int z) {
        // if n is zero no possible ways to cut it so ans is zero
        if (n == 0) {
            return 0;
        }

        // if length is negative then it's invalid case
        // to handle it returning min so it won't be considered in max operation
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        // take cut of x and rest recursion will handle
        int option1 = 1 + maximizeCuts(n - x, x, y, z);

        // take cut of y and rest recursion will handle
        int option2 = 1 + maximizeCuts(n - y, x, y, z);

        // take cut of z and rest recursion will handle
        int option3 = 1 + maximizeCuts(n - z, x, y, z);

        //find the max of all options
        return Math.max(option1, Math.max(option2, option3));
    }
}
