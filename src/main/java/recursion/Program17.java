package recursion;

/**
 * recursively reverse a string
 * <p>
 * explanation : one note -> recursion
 */
public class Program17 {
    public static void main(String[] args) {
        String str = "thisisdenish";
        char ch = 'i';

        int index = findLastIndex(str, ch, str.length() - 1);

        if (index != -1) {
            System.out.println("result : " + index);
        } else {
            System.out.println("Not found");
        }
    }

    private static int findLastIndex(String str, char ch, int index) {
        if (index < 0) {
            return -1;
        }

        if (str.charAt(index) == ch) {
            return index;
        }

        return findLastIndex(str, ch, index - 1);
    }
}
