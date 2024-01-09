package tries;

/**
 * Leetcode 14. Longest Common Prefix
 * <p>
 * For explanation : one note -> trie
 */
class Program02 {
    public String longestCommonPrefix(String[] strs) {

        // create trie out of given strings
        Trie trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        TrieNode current = trie.getRoot(); //pointer

        String result = "";

        TrieNode child = null;

        while (current != null) {

            // if current node is terminal then return result
            if (current.getIsTerminal()) {
                // substring because first char is '/' and also need to add current pointer character
                return result.isEmpty() ? result : result.substring(1) + current.getValue();
            }

            // count the children of current node
            TrieNode[] children = current.getChildren();

            int count = 0;

            for (int i = 0; i < 26; i++) {
                if (children[i] != null) {
                    child = children[i]; // to update the pointer
                    count++;
                }
            }

            // if count is 1 then add to result else break
            if (count == 1) {
                result += Character.toString(current.getValue());
                current = child; // update the pointer
            } else {
                break;
            }
        }

        // substring because first char is '/' and also need to add current pointer character
        return result.isEmpty() ? result : result.substring(1) + current.getValue();
    }
}
