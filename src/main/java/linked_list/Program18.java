package linked_list;

/**
 * Leetcode 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 */
public class Program18 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // index of first and last critical points
        int firstCriticalPoint = -1;
        int lastCriticalPoint = -1;

        // to iterate over linked list
        ListNode current = head;
        ListNode prev = null;

        //to keep track of index
        int index = 0;
        int min = Integer.MAX_VALUE;

        while(current != null) {

            // prev and next should not be null
            if(prev != null && current.next != null) {
                //condition for critical point
                if((current.val < prev.val && current.val < current.next.val) ||
                        (current.val > prev.val && current.val > current.next.val)) {

                    //if we got critical point for the first time
                    if(lastCriticalPoint == -1 || firstCriticalPoint == -1) {
                        lastCriticalPoint = index;
                        firstCriticalPoint = index;
                    } else {
                        //before updating critical point check for the min
                        min = Math.min(min, index - lastCriticalPoint);
                        lastCriticalPoint = index;
                    }
                }
            }
            index++;
            prev = current;
            current = current.next;
        }

        // if both are at same index
        if(lastCriticalPoint ==  firstCriticalPoint) {
            return new int[]{-1,-1};
        }

        //difference of last and first critical points
        int max = lastCriticalPoint - firstCriticalPoint;
        return new int[]{min,max};
    }
}
