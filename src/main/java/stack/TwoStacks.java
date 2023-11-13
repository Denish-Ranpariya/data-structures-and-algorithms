package stack;

/**
 * GFG : Implement two stacks in an array
 */
class TwoStacks {

    int top1;
    int top2;
    int[] arr = new int[100];


    TwoStacks() {
        top1 = -1;
        top2 = arr.length;
    }

    //Function to push an integer into the stack1.
    void push1(int x) {
        if (top1 + 1 == top2) {
            return;
        }

        top1++;
        arr[top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x) {
        if (top1 + 1 == top2) {
            return;
        }

        top2--;
        arr[top2] = x;

    }

    //Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 == -1) {
            return -1;
        }

        return arr[top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 == arr.length) {
            return -1;
        }

        return arr[top2++];
    }
}
