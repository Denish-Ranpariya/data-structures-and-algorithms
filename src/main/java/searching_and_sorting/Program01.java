package searching_and_sorting;

//leetcode 69
//square root of a number using without using built-in function or operator

//for explanation
//one note -> searching and searching
public class Program01 {
    public int mySqrt(int x) {
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
}
