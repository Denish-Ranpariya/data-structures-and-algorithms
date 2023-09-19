package array;

//leetcode 189 : rotate array
//for explanation : one note -> arrays book
public class Program01 {
    //3 methods

    public void method1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {

            //rotate one element
            int temp = nums.length;

            for (int j = n - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = temp;
        }
    }

    public void method2(int[] nums, int k) {
        int n = nums.length;
        int temp[] = new int[n];
        k = k % n;
        for (int i = 0; i < n; i++) {
            temp[i] = nums[(n - k + i) % n];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public void method3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        nums = reverse(nums, 0, n - k - 1);
        nums = reverse(nums, n - k, n - 1);
        nums = reverse(nums, 0, n - 1);
    }

    private int[] reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

}
