package array;

// leetcode 75 MMIMP
// sort colors
// dutch national flag algorithm
//for explanation
//one note -> arrays
public class Program04 {

    public void sortColors(int[] nums) {
        int n = nums.length;

        int start = 0; //keep track of zeroes
        int end = n - 1; //keep track of twos

        int i = 0; //traverse through an array

        while (i <= end) {

            //if element is 2 then swap it with end and end--
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;      //here don't do i++ because elements coming from end index can be a 2 so need to process i index again
            } else if (nums[i] == 0) {
                //if element is 1 then swap it with start and start-- and i++
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                i++;
                start++;
            } else {
                //if element is 0 then do nothing and i++
                i++;
            }
        }
    }
}
