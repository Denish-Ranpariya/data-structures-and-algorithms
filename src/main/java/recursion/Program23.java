package recursion;

/**
 * Leetcode 121. Best Time to Buy and Sell Stock
 * <p>
 * recursive solution
 * <p>
 * for explanation one note -> recursion
 */
public class Program23 {
    public int min = Integer.MAX_VALUE;
    public int maxProfit = Integer.MIN_VALUE;

    public int maxProfit(int[] prices) {
        solve(prices, 0);
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }

    public void solve(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] < min) {
            min = arr[index];
        } else {
            int profit = arr[index] - min;
            maxProfit = Math.max(profit, maxProfit);
        }

        solve(arr, index + 1);
    }
}
