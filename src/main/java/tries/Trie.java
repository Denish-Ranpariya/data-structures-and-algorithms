package tries;

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('/', false);
    }

    public void insert(String word) {
        int n = word.length();

        TrieNode current = root;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            TrieNode[] children = current.getChildren();

            // check if ch is already a child of current node
            if (children[ch - 'a'] == null) {
                //not a child
                TrieNode newNode = new TrieNode(ch, false); // create

                // assign
                children[ch - 'a'] = newNode;
                current.setChildren(children);

                current = current.getChildren()[ch - 'a']; //update current
            } else {
                current = children[ch - 'a']; //update current
            }
        }

        current.setIsTerminal(true);
    }

    // to search, iterate thorugh string
    public boolean search(String word) {
        int n = word.length();

        TrieNode current = root;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            TrieNode[] children = current.getChildren();

            if (children[ch - 'a'] == null) {
                // if ch is not child of current node return false
                return false;
            } else {
                current = children[ch - 'a']; // update current
            }
        }

        // at this point string is present in trie but check if current node is terminal or not
        return current.getIsTerminal();
    }

    // same as search but no need to check last node is terminal or not becuase we are searching for prefix not the whole string
    public boolean startsWith(String prefix) {
        int n = prefix.length();

        TrieNode current = root;

        for (int i = 0; i < n; i++) {
            char ch = prefix.charAt(i);

            TrieNode[] children = current.getChildren();

            if (children[ch - 'a'] == null) {
                return false;
            } else {
                current = children[ch - 'a'];
            }
        }

        return true;
    }
}
