package tree.binary_tree;

import tree.Node;

import java.util.*;

/**
 * GFG - Top View of Binary Tree
 * MIMP
 * By maintaining horizontal level
 */
public class Program12 {

    // do level order traversal
    // maintain queue with type as Pair
    // maintain map to keep track of nodes at specific horizontal level
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> hm = new HashMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair current = q.remove();

                // only add node to map with given horizontal level if it appeared for the first time
                if (!hm.containsKey(current.hd)) {
                    hm.put(current.hd, current.node);
                }

                if (current.node.left != null) {
                    q.add(new Pair(current.node.left, current.hd - 1));
                }

                if (current.node.right != null) {
                    q.add(new Pair(current.node.right, current.hd + 1));
                }
            }
        }

        //sort map keys
        ArrayList<Integer> sortedKeys = new ArrayList<>(hm.keySet());
        Collections.sort(sortedKeys);

        //add respective node's data to result
        for (int key : sortedKeys) {
            result.add(hm.get(key).data);
        }

        return result;

    }

    // to maintain node along with horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
