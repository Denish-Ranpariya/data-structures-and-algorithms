package strings;

/**
 * leetcode 1910
 * <p>
 * for explanation one note -> character array and string
 */
public class Program03 {
    public String removeOccurrences(String s, String part) {

        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }
}
