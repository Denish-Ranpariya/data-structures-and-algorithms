package strings;

//leetcode 443. String Compression
// for more explanation one note char arrays and strings
public class Program18 {
    public int compress(char[] chars) {
        int n = chars.length;

        if (n == 0) {
            return 0;
        }

        // to keep track of current character
        char ch = chars[0];

        // to keep track of frequency
        int fr = 1;

        //to keep modifying array
        int index = 0;

        for (int i = 1; i < n; i++) {
            if (chars[i] == ch) {
                fr++;
            } else {
                chars[index++] = ch;

                if (fr != 1) {
                    int start = index;

                    //if fr contains more than one digits
                    while (fr != 0) {
                        chars[index++] = (char) ((fr % 10) + '0');
                        fr = fr / 10;
                    }
                    int end = index - 1;

                    // to get actual count
                    // reverse logic
                    // to convert 321 -> 123
                    while (start <= end) {
                        char temp = chars[start];
                        chars[start] = chars[end];
                        chars[end] = temp;
                        start++;
                        end--;
                    }
                }


                ch = chars[i];
                fr = 1;
            }
        }

        //same logic but for last character
        chars[index++] = ch;

        if (fr != 1) {
            int start = index;

            while (fr != 0) {
                chars[index++] = (char) ((fr % 10) + '0');
                fr = fr / 10;
            }
            int end = index - 1;

            while (start <= end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        return index;
    }
}
