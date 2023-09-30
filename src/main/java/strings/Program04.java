package strings;

/**
 * leetcode 680
 * IMP
 * <p>
 * for explanation one note -> character array and string
 */
public class Program04 {
    public boolean validPalindrome(String s) {

        int n = s.length();

        int start = 0;
        int end = n - 1;

        int brokenStart = -1;
        int brokenEnd = -1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                brokenStart = start;
                brokenEnd = end;
                break;
            } else {
                start++;
                end--;
            }
        }

        if (brokenStart == -1 && brokenEnd == -1) {
            return true;
        }

        String s1 = s.substring(0, brokenStart) + s.substring(brokenStart + 1);
        String s2 = s.substring(0, brokenEnd) + s.substring(brokenEnd + 1);

        return isPalindrome(s1) || isPalindrome(s2);
    }

    private boolean isPalindrome(String s) {
        int n = s.length();

        int start = 0;
        int end = n - 1;

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
