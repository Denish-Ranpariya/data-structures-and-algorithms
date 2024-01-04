package tries;

public class TrieNode {
    char value;

    TrieNode[] children;

    boolean isTerminal;

    public TrieNode(char value) {
        this.value = value;
        this.children = new TrieNode[26]; //26 letters in alphabets

        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
    }
}
