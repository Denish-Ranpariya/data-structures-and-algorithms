package divide_and_conquer;

/**
 * Quick sort algorithm
 */
public class Program02 {
    static void quickSort(int[] arr, int start, int end) {
        // base cases
        if (start > end) {
            return;
        }

        if (start == end) {
            return;
        }

        //do the partition
        int index = partition(arr, start, end);

        //recursion call for the left part
        quickSort(arr, start, index - 1);

        //recursion call for right part
        quickSort(arr, index + 1, end);
    }

    static int partition(int[] arr, int start, int end) {
        int i = start - 1;

        //choose end as pivot index
        int pivotIndex = end;

        int j = start;

        //iterate from start to end - 1
        // if element is less than element at pivot index then increment i and swap it with j
        while (j < end) {
            if (arr[j] < arr[pivotIndex]) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }

        //swap element with pivotIndex with i to its correct position
        i++;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[i];
        arr[i] = temp;

        //return the correct position of pivot element
        return i;
    }
}
