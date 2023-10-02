package basic_maths;

/**
 * exponential operation in logb time
 * <p>
 * for explanation one note -> basic maths and pointers
 */
public class Program03 {
    public long PowMod(long a, long b, long m) {
        // Code here
        long ans = 1L;

        while (b > 0) {
            if ((b & 1) == 1) {
                //odd
                ans = (ans * a) % m;
            }

            a = (a * a) % m;
            b = b >> 1; // divide by 2
        }

        return ans;
    }
}
