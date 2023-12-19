package heap;

public class Heap {
    int[] arr;
    int size;
    int capacity;

    public Heap(int capacity) {
        this.arr = new int[capacity + 1]; // because 1 based indexing
        this.size = 0;
        this.capacity = capacity;
    }

    // method to heapify element at specific index
    // O(logn)
    public static void heapify(int[] arr, int size, int index) {

        // find index of children elements
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;

        // find largest element index
        int currentData = arr[index];
        int leftData = leftIndex <= size ? arr[leftIndex] : Integer.MIN_VALUE;
        int rightData = rightIndex <= size ? arr[rightIndex] : Integer.MIN_VALUE;

        int largestIndex = -1;

        if (currentData > leftData && currentData > rightData) {
            // if element at current index is largest then it's the base case
            return;
        } else if (leftData > currentData && leftData > rightData) {
            largestIndex = leftIndex;
        } else {
            largestIndex = rightIndex;
        }

        // swap elements at current Index and largestIndex
        int temp = arr[index];
        arr[index] = arr[largestIndex];
        arr[largestIndex] = temp;

        // heapify element at largestIndex
        heapify(arr, size, largestIndex);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(5);
        heap.insert(30);
        heap.insert(50);
        heap.insert(40);
        heap.insert(100);
        heap.insert(60);

        System.out.println("::: After inserting 5 elements :::");
        heap.printHeap();
        System.out.println();

        int deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();

        deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();

        deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();

        deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();

        deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();

        deletedElement = heap.delete();
        System.out.println("Deleted Element : " + deletedElement);
        heap.printHeap();
        System.out.println();
    }

    // to insert an element into heap
    // O(logn)
    void insert(int data) {

        // overflow condition
        if (size == capacity) {
            System.out.println("Heap Overflow!!!");
            return;
        }

        // insert data at vacant position
        size++;
        arr[size] = data;

        //heapify
        int currentIndex = size;

        while (currentIndex > 1) {

            // find parent element index
            int parentIndex = currentIndex / 2;

            // if element at parent index is smaller then need to swap else break
            if (arr[parentIndex] < arr[currentIndex]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[currentIndex];
                arr[currentIndex] = temp;

                currentIndex = parentIndex;// update current Index
            } else {
                break;
            }
        }
    }

    // print according to one based indexing
    void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // method to delete element
    // in heap element will always be removed from root or index 1
    // O(logn)
    int delete() {

        //underflow condition
        if (size == 0) {
            System.out.println("Head Underflow!!!");
            return -1;
        }

        // save answer
        int answer = arr[1];

        //set last element to root and shrink the size
        arr[1] = arr[size];
        size--;

        // heapify root element
        int currentIndex = 1;

        while (currentIndex < size) {

            // find indices of child elements
            int leftIndex = 2 * currentIndex;
            int rightIndex = 2 * currentIndex + 1;

            // find index of largest element among three
            int currentData = arr[currentIndex];
            int leftData = leftIndex <= size ? arr[leftIndex] : Integer.MIN_VALUE;
            int rightData = rightIndex <= size ? arr[rightIndex] : Integer.MIN_VALUE;

            int largestIndex = -1;

            if (currentData > leftData && currentData > rightData) {
                // if element at current index is largest then it's already heapified so break
                break;
            } else if (leftData > currentData && leftData > rightData) {
                largestIndex = leftIndex;
            } else {
                largestIndex = rightIndex;
            }

            // swap values at indices currentIndex and largestIndex
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[largestIndex];
            arr[largestIndex] = temp;

            currentIndex = largestIndex; // update currentIndex
        }
        return answer;
    }

    // O(1)
    int max() {
        return arr[1];
    }

    // O(1)
    int min() {
        return arr[size];
    }
}
