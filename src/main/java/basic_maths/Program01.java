package basic_maths;

/**
 * leetcode 204. Count Primes
 * <p>
 * MMMIMP
 * <p>
 * for explanation one note -> basic maths and pointers
 */
public class Program01 {

    //M-1
    //this will give TLE
    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    //M-2
    //this will also give TLE
    private boolean isPrime1(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // M-3
    //sieve of eratosthenes
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        boolean[] status = new boolean[n];
        //false = prime
        //true = non prime
        status[0] = true;
        status[1] = true;

        for (int i = 2; i < n; i++) {
            if (!status[i]) {
                int multiple = 2;

                while (i * multiple < n) {
                    status[i * multiple] = true;
                    multiple++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!status[i]) {
                count++;
            }
        }

        return count;
    }

    // M-4
    //sieve of eratosthenes optimized
    public int countPrimes1(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        boolean[] status = new boolean[n];
        //false = prime
        //true = non prime
        status[0] = true;
        status[1] = true;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) { //optimization 2 is here
            if (!status[i]) {
                int multiple = i; //optimization 1 here

                while ((long) i * multiple < n) {
                    status[i * multiple] = true;
                    multiple++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!status[i]) {
                count++;
            }
        }

        return count;
    }
}
