package searching_and_sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * leetcode 532. K-diff Pairs in an Array
 * <p>
 * for explanation one note -> searching and sorting
 */
public class Program08 {

    // M-1
    public int findPairs1(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        //sort the array
        Arrays.sort(nums);

        //take two pointers and start at 0 and 1 index
        int i = 0;
        int j = 1;

        //to remove duplicates
        HashSet<Pair> hs = new HashSet<>();

        while (i < n && j < n) {
            int diff = nums[j] - nums[i];

            // if diff is exactly k and i is not equal j then add it to hash set
            // increment both pointers
            if (diff == k && i != j) {
                hs.add(new Pair(nums[j], nums[i]));
                i++;
                j++;
            } else if (diff < k) {
                // if diff is less than k then increment j to make window wider
                j++;
            } else {
                // if diff is greater than k them increment i to make window shorter
                i++;
            }
        }

        //return count of unique pairs
        return hs.size();
    }

    //M-2
    public int findPairs(int[] nums, int k) {
        int n = nums.length;

        //sort the array
        Arrays.sort(nums);

        // to remove duplicate pairs
        HashSet<Pair> hs = new HashSet<>();

        // iterate through array and search for element so that diff becomes k using binary search
        // for binary search range would be from i + 1 to n - 1
        for (int i = 0; i < n; i++) {
            int target = nums[i] + k;

            int index = binarySearch(nums, i + 1, target);

            if (index != -1) {
                hs.add(new Pair(nums[i], nums[index]));
            }
        }

        return hs.size();
    }

    private int binarySearch(int[] nums, int start, int target) {
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object object) {
            Pair that = (Pair) object;
            return this.a == that.a && this.b == that.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}


