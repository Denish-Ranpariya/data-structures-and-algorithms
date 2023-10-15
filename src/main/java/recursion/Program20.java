package recursion;

/**
 * Palindrome check recursively
 */
public class Program20 {

    public static void main(String[] args) {
        String str = "racecar";

        boolean isPalindrome = checkPalindrome(str, 0, str.length() - 1);

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    private static boolean checkPalindrome(String str, int start, int end) {
        if (start > end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return checkPalindrome(str, start + 1, end - 1);
    }
}
