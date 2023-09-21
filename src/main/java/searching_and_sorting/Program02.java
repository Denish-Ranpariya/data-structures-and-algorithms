package searching_and_sorting;

// leetcode 74
// Search a 2D Matrix
public class Program02 {
    public boolean searchMatrix(int[][] arr, int target) {
        int rows = arr.length;
        int column = arr[0].length;

        int targetRow = -1;

        //search in column to find the row
        int start = 0;
        int end = rows - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid][0] <= target && arr[mid][column - 1] >= target) {
                targetRow = mid;
                break;
            } else if(target < arr[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(targetRow == -1) {
            return false;
        }

        //search in target row
        start = 0;
        end = column - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[targetRow][mid] == target) {
                return true;
            }else if(arr[targetRow][mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return false;
    }
}
