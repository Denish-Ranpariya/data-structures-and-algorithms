package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 273. Integer to English Words
 * <p>
 * hard problem
 * <p>
 * MMIMP
 * <p>
 * for explanation one note -> recursion
 */
public class Program24 {
    List<Pair> map = new ArrayList<>();

    public String numberToWords(int num) {
        map.add(new Pair(1000000000, "Billion"));
        map.add(new Pair(1000000, "Million"));
        map.add(new Pair(1000, "Thousand"));
        map.add(new Pair(100, "Hundred"));
        map.add(new Pair(90, "Ninety"));
        map.add(new Pair(80, "Eighty"));
        map.add(new Pair(70, "Seventy"));
        map.add(new Pair(60, "Sixty"));
        map.add(new Pair(50, "Fifty"));
        map.add(new Pair(40, "Forty"));
        map.add(new Pair(30, "Thirty"));
        map.add(new Pair(20, "Twenty"));
        map.add(new Pair(19, "Nineteen"));
        map.add(new Pair(18, "Eighteen"));
        map.add(new Pair(17, "Seventeen"));
        map.add(new Pair(16, "Sixteen"));
        map.add(new Pair(15, "Fifteen"));
        map.add(new Pair(14, "Fourteen"));
        map.add(new Pair(13, "Thirteen"));
        map.add(new Pair(12, "Twelve"));
        map.add(new Pair(11, "Eleven"));
        map.add(new Pair(10, "Ten"));
        map.add(new Pair(9, "Nine"));
        map.add(new Pair(8, "Eight"));
        map.add(new Pair(7, "Seven"));
        map.add(new Pair(6, "Six"));
        map.add(new Pair(5, "Five"));
        map.add(new Pair(4, "Four"));
        map.add(new Pair(3, "Three"));
        map.add(new Pair(2, "Two"));
        map.add(new Pair(1, "One"));

        return solve(num);
    }

    public String solve(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (int i = 0; i < map.size(); i++) {
            if (num >= map.get(i).number) {

                Pair pair = map.get(i);

                String a = "";

                if (pair.number >= 100) {
                    a = solve(num / pair.number) + " ";
                }

                String b = pair.words;

                String c = "";

                if (num % pair.number != 0) {
                    c = " " + solve(num % pair.number);
                }

                return a + b + c;
            }
        }
        return "";
    }

    class Pair {
        int number;
        String words;

        public Pair(int number, String words) {
            this.number = number;
            this.words = words;
        }
    }
}
