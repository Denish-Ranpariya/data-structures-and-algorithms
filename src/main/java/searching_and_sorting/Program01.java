package searching_and_sorting;

//leetcode 69
//square root of a number using without using built-in function or operator

//for explanation
//one note -> searching and searching
public class Program01 {
    public static int mySqrt(int x) {
        int start = 0;
        int end = x;

        int ans  = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if((long)mid * mid == (long) x) {
                return mid;
            }else if((long) mid * mid > (long) x) {
                end = mid - 1;
            }else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    // to find precision
    // not included in leetcode but can be asked as an extension of the problem
    private static float findAnswerWithPrecision(int number, int sqrt, int precision) {

        float result = -1;
        for(int i = 0; i < precision; i++) {
            float j = sqrt;
            while(j * j <= number) {
                result = j;
                j = j + 1/(float)Math.pow(10, i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 50;
        int sqrt = mySqrt(num);
        float sqrtWithPrecision = findAnswerWithPrecision(num, sqrt, 3);
        System.out.println(sqrtWithPrecision);
    }

}
