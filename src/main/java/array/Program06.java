package array;

//leetcode 48
//rotate image
//MMMIMP
//can help you to crack an interview

//rotate = transpose + reverse
public class Program06 {

    public void rotate(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;

        //transpose
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i > j) { //if I don't apply this condition then it will become same as initial matrix because it will do swapping two times
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        //reverse by rows

        for (int i = 0; i < rows; i++) {
            arr[i] = reverse(arr[i]);
        }
    }

    private int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
