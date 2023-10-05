package strings;

/**
 * leetcode 5. Longest Palindromic Substring
 * <p>
 * M-1 bruteforce n^3
 * M-2 similar to leetcode 647 (giving TLE)
 * M-3 dynamic programming
 */
public class Program16 {
    public String longestPalindrome(String s) {
        int n = s.length();

        String maxString = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subString = s.substring(i, j + 1);

                if (isPalindrome(subString)) {
                    if (subString.length() > maxString.length()) {
                        maxString = subString;
                    }
                }
            }
        }

        return maxString;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
