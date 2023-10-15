package recursion;

/**
 * Reverse a string recursively
 */
public class Program18 {
    public static final StringBuilder stringBuilder = new StringBuilder("!bud bud abbal abbuw");

    public static void main(String[] args) {
        int start = 0;
        int end = stringBuilder.length() - 1;
        reverse(stringBuilder, start , end );
        System.out.println(stringBuilder.toString());
    }

    private static void reverse(StringBuilder stringBuilder, int start, int end) {
        if (start > end) {
            return;
        }

        //swap
        char temp = stringBuilder.charAt(start);
        stringBuilder.setCharAt(start, stringBuilder.charAt(end));
        stringBuilder.setCharAt(end, temp);

        reverse(stringBuilder, start + 1, end - 1);
    }
}
