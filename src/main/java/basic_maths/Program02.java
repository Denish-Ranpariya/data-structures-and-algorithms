package basic_maths;

/**
 * GCD of two numbers
 * <p>
 * Euclide's therom
 * <p>
 * gcd(a,b) = gcd(a-b, b) (for a > b)
 * or
 * gcd(b-a, a) (for b > a)
 */
public class Program02 {

    //M - 1 iterative method
    public int gcd1(int a, int b) {

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a == 0 ? b : a;
    }

    //M - 2 recursive method
    public int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        if (a > b) {
            return gcd(a - b, b);
        }

        return gcd(b - a, a);
    }
}
