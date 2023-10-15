package recursion;

/**
 * find all subsequences of a string
 */
public class Program14 {
    public static void main(String[] args) {
        String str = "abc";
        printSubSequences(str, "");
    }

    private static void printSubSequences(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        String output1 = output;
        String output2 = output + input.charAt(0);

        input = input.substring(1);

        printSubSequences(input, output1);
        printSubSequences(input, output2);
    }
}
