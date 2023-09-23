package array;

//leetcode 2643
//Row With Maximum Ones
public class Program05 {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;

        int rowWithMaxOnes = -1;
        int maxOnes = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int count = 0;

            for (int j = 0; j < column; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                rowWithMaxOnes = i;
            }
        }

        return new int[]{rowWithMaxOnes, maxOnes};
    }
}
