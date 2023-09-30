package strings;

/**
 * leetcode 2125. Number of Laser Beams in a Bank
 *
 * iterate through banks array and count number of 1
 *
 * if the count is not zero, then update prv count and current count and add (prev count * current count) to answer
 */
public class Program08 {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;

        int prevCount = 0;
        int currentCount = 0;

        int ans = 0;

        for(int i = 0; i < n; i++) {
            String currentString = bank[i];
            int count = 0;
            for(int j = 0; j < currentString.length(); j++) {
                if(currentString.charAt(j) == '1') {
                    count++;
                }
            }

            if(count != 0) {
                prevCount = currentCount;
                currentCount = count;
                ans += prevCount * currentCount;
            }
        }

        return ans;
    }
}
