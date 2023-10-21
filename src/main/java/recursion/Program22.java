package recursion;

/**
 * leetcode 1910. Remove All Occurrences of a Substring
 * <p>
 * recursive solution
 * <p>
 * for explanation one note -> recursion
 */
public class Program22 {
    public String removeOccurrences(String s, String part) {
        if (s.indexOf(part) == -1) {
            return s;
        }

        int index = s.indexOf(part);
        s = s.substring(0, index) + s.substring(index + part.length());
        return removeOccurrences(s, part);
    }
}
