package divide_and_conquer;

/**
 * merge sort
 * <p>
 * MMIMP
 * <p>
 * for explanation one note -> backtracking and dnc
 */
public class Program01 {
    void merge(int[] arr, int start, int mid, int end) {
        // Your code here
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        //copy
        int k = start;
        for (int i = 0; i < n1; i++) {
            left[i] = arr[k];
            k++;
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[k];
            k++;
        }

        int i = 0, j = 0;
        k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    void mergeSort(int[] arr, int start, int end) {
        //code here
        if (start > end) {
            return;
        }

        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}
