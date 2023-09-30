package strings;

/**
 * Leetcode 647
 *
 * MMMIMP
 * <p>
 * Palindromic Substrings
 * <p>
 * for explanation one note -> char arrays and string
 */
public class Program01 {

    public int countSubstrings(String s) {

        int n = s.length();

        int count = 0;

        //for odd length palindrome string

        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;

            while (start >= 0 && end <= n - 1) {
                if (isPalindrome(s, start, end)) {
                    count++;
                }
                start--;
                end++;
            }
        }

        //for even length palindrome string

        for (int i = 0; i < n - 1; i++) {
            int start = i;
            int end = i + 1;

            while (start >= 0 && end <= n - 1) {
                if (isPalindrome(s, start, end)) {
                    count++;
                }
                start--;
                end++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}
