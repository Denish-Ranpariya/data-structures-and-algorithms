package strings;

/**
 * leetcode 345. Reverse Vowels of a String
 * <p>
 * two pointers just updated
 */
public class Program13 {
    public String reverseVowels(String s) {
        int n = s.length();

        char[] s1 = s.toCharArray();

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (isVowel(s1[start]) && isVowel(s1[end])) {
                char temp = s1[start];
                s1[start] = s1[end];
                s1[end] = temp;
                start++;
                end--;
            } else if (!isVowel(s1[start])) {
                start++;
            } else {
                end--;
            }
        }

        return String.valueOf(s1);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
