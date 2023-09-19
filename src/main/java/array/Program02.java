package array;

//leetcode 268

public class Program02 {

    public void method1(int[] nums) {
        //method 1
        //sort and check if (i !== nums[i]) return i;
        //after loop return n
    }

    public int method2(int[] nums) {
        //method 2
        //sum of first n natural numbers

        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += nums[i];
        }
        return sum - arraySum;
    }

    public int method3(int[] nums) {
        //method 3
        //using xor
        int xor = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }

        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }
}
