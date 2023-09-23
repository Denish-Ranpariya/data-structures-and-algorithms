package array;

import java.util.Arrays;

// Key Pair - GFG
// Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.
// sort and two pointers
public class Program07 {

    boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
        // code here
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (arr[start] + arr[end] == x) {
                return true;
            } else if (arr[start] + arr[end] < x) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }
}
