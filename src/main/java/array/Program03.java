package array;

//leetcode 2149
//for explanation
//one note -> doubt sessions book
public class Program03 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[positiveIndex] = nums[i];
                positiveIndex += 2;
            } else {
                ans[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }

        return ans;
    }
}
