package tries;


import java.util.ArrayList;
import java.util.List;

/**
 * Print all the words which starts with given prefix
 * MMIMP
 */
public class Program01 {
    List<String> result;
    Trie trie;

    public Program01(List<String> words) {
        result = new ArrayList<>();
        trie = new Trie();

        words.forEach(word -> trie.insert(word));
    }

    public void printAllWordsWithPrefix(String prefix) {

        // reach to node with given prefix
        TrieNode trieNode = reachToNodeWithGivenPrefix(prefix);

        // now find words starting with this prefix
        if (trieNode != null) {
            findWords(trieNode, prefix.substring(0, prefix.length() - 1)); // removing last character because it will be included only if it's a terminal
        }

        result.forEach(System.out::println);
    }

    // method to reach node with given prefix (similar to search algorithm)
    private TrieNode reachToNodeWithGivenPrefix(String prefix) {
        TrieNode current = trie.getRoot();

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (current.getChildren()[ch - 'a'] != null) {
                current = current.getChildren()[ch - 'a'];
            } else {
                return null;
            }
        }

        return current;
    }

    private void findWords(TrieNode trieNode, String currentString) {

        //base case
        if (trieNode == null) {
            return;
        }

        // add current node's character to string
        currentString += trieNode.getValue();

        // if it's a terminal then add it to result
        if (trieNode.getIsTerminal()) {
            result.add(currentString);
        }

        // recursive call to all the children
        TrieNode[] children = trieNode.getChildren();

        for (int i = 0; i < 26; i++) {
            findWords(children[i], currentString);
        }
    }

    public static void main(String[] args) {
        List<String> words = List.of("code", "court", "car", "card", "codehelp", "love", "lovely", "loved", "dove", "dovey", "dot");
        Program01 program01 = new Program01(words);
        program01.printAllWordsWithPrefix("ca");
    }
}
