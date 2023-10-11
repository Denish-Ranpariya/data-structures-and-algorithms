package recursion;

/**
 * print all indices of a character in a string
 */
public class Program13 {
    public static void main(String[] args) {
        String str = "bubble";

        printIndices(str, 'b', 0);
    }

    public static void printIndices(String str, char ch, int index) {
        if (index == str.length()) {
            return;
        }

        if (str.charAt(index) == ch) {
            System.out.println(index);
        }

        printIndices(str, ch, index + 1);
    }
}
