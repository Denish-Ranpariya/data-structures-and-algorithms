package tries;

class TrieNode {
    private char value;
    private TrieNode[] children;
    private boolean isTerminal;

    TrieNode(char value, boolean isTerminal) {
        this.value = value;
        this.isTerminal = isTerminal;

        this.children = new TrieNode[26];
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean getIsTerminal() {
        return this.isTerminal;
    }

    public void setIsTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    public TrieNode[] getChildren() {
        return this.children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }
}
