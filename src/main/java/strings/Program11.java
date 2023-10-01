package strings;

/**
 * leetcode 917
 * <p>
 * Reverse Only Letters
 */
public class Program11 {
    // two pointers but slightly updated
    public String reverseOnlyLetters(String s) {
        char[] s1 = s.toCharArray();

        int n = s1.length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (Character.isLetter(s1[start]) && Character.isLetter(s1[end])) {
                char temp = s1[start];
                s1[start] = s1[end];
                s1[end] = temp;
                start++;
                end--;
            } else if (!Character.isLetter(s1[start])) {
                start++;
            } else {
                end--;
            }
        }

        return String.valueOf(s1);
    }
}
