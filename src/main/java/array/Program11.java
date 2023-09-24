package array;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Common elements
 * <p>
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * <p>
 * for explanation one note -> arrays
 */
public class Program11 {
    ArrayList<Integer> commonElements(int[] A, int[] B, int[] C, int n1, int n2, int n3) {
        // code here
        Set<Integer> result = new LinkedHashSet<Integer>();

        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            if (A[p1] == B[p2] && B[p2] == C[p3]) {
                result.add(A[p1]);
                p1++;
                p2++;
                p3++;
            } else if (A[p1] < B[p2]) {
                p1++;
            } else if (B[p2] < C[p3]) {
                p2++;
            } else {
                p3++;
            }
        }

        return new ArrayList<Integer>(result);
    }
}
