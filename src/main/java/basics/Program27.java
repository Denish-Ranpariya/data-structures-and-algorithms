package basics;

//leetcode 7
//MIMP
//refer video (reverse integer)
public class Program27 {
    public int reverse(int x) {
        boolean isNegative = false;

        if(x <= Integer.MIN_VALUE) {
            return 0;
        }
        if(x < 0) {
            isNegative = true;
            x = -x;
        }

        int result = 0;
        while(x != 0) {
            if(result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int rem = x % 10;
            result = result * 10 + rem;
            x = x /10;
        }

        if(result > Integer.MAX_VALUE) {
            return 0;
        }

        return isNegative ? -result : result;
    }
}
