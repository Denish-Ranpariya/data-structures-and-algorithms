package strings;

/**
 * leetcode 14. Longest Common Prefix
 */
public class Program12 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        int currentIndex = 0;

        while (true) {
            if (currentIndex > strs[0].length() - 1) {
                return ans.toString();
            }
            char ch = strs[0].charAt(currentIndex);

            for (String str : strs) {
                if (currentIndex > str.length() - 1) {
                    return ans.toString();
                }

                if (ch != str.charAt(currentIndex)) {
                    return ans.toString();
                }
            }

            ans.append(ch);
            currentIndex++;
        }
    }
}
