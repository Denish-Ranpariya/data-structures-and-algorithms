package strings;

/**
 * leetcode 2391. Minimum Amount of Time to Collect Garbage
 * <p>
 * for explanation one note -> char arrays and string
 */
public class Program09 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int total = 0;

        int n = garbage.length;

        int lastG = -1;
        int lastP = -1;
        int lastM = -1;

        //calculate last occurance of M G and P
        for (int i = 0; i < n; i++) {
            if (garbage[i].contains("P")) {
                lastP = i;
            }

            if (garbage[i].contains("G")) {
                lastG = i;
            }

            if (garbage[i].contains("M")) {
                lastM = i;
            }
        }

        //for paper
        for (int i = 0; i <= lastP; i++) {
            String currentString = garbage[i];

            for (int j = 0; j < currentString.length(); j++) {
                if (currentString.charAt(j) == 'P') {
                    total++;
                }
            }

            total += i == 0 ? 0 : travel[i - 1];
        }


        //for metal
        for (int i = 0; i <= lastM; i++) {
            String currentString = garbage[i];

            for (int j = 0; j < currentString.length(); j++) {
                if (currentString.charAt(j) == 'M') {
                    total++;
                }
            }
            total += i == 0 ? 0 : travel[i - 1];
        }

        //for glass
        for (int i = 0; i <= lastG; i++) {
            String currentString = garbage[i];

            for (int j = 0; j < currentString.length(); j++) {
                if (currentString.charAt(j) == 'G') {
                    total++;
                }
            }
            total += i == 0 ? 0 : travel[i - 1];
        }

        return total;
    }
}
