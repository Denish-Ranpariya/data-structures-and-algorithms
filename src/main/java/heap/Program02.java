package heap;

/**
 * Heap sort
 * <p>
 * For explanation one note -> heaps
 */
public class Program02 {
    public static void heapsort(int[] arr, int size) {

        // build heap out of the array
        Program01.buildHeap(arr, size);

        // swap element to index size from index 1 until size becomes 1
        // while doing this after swapping decrease size by 1 and heapify element at index 1
        while (size != 1) {
            int temp = arr[size];
            arr[size] = arr[1];
            arr[1] = temp;

            size--;

            Heap.heapify(arr, size, 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, 43, 323, 4345, 22, 1123, 33, 124, 22442};
        Program02.heapsort(arr, arr.length - 1);

        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
