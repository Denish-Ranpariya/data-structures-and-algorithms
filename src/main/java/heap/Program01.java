package heap;

/**
 * Convert array into heap
 * <p>
 * For explanation one note -> heaps
 */
public class Program01 {

    // because element from index (size/2 + 1) to n are leaf nodes
    // and leaf nodes can be considered as already heapified nodes
    // so we will only heapify nodes from size/2 to 1
    public static void buildHeap(int[] arr, int size) {
        for (int i = size / 2; i >= 1; i--) {
            Heap.heapify(arr, size, i);
        }
    }
}
