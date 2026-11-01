package algorithms.strings;

import java.util.*;

/**
 * Word Storage and Search using Trie with HashMap Child Mapping
 * 
 * Unlike fixed 26-way array Tries, HashMap-based child mapping supports:
 * 1. Arbitrary characters (uppercase, lowercase, digits, symbols, spaces)
 * 2. Dynamic memory allocation (only allocates space for characters that exist)
 * 3. Fast O(L) insertions, lookups, prefix searches, and deletions
 * 
 * Space Complexity: O(Total characters across all unique prefixes)
 * Time Complexity:
 *   - Insert: O(L)
 *   - Search: O(L)
 *   - StartsWith: O(L)
 *   - Delete: O(L)
 *   (where L is the length of the word)
 */
public class Trie {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }

    private final Node root = new Node();

    /**
     * Inserts a word into the Trie.
     */
    public void insert(String word) {
        if (word == null) return;
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            current.children.putIfAbsent(ch, new Node());
            current = current.children.get(ch);
        }
        current.isWord = true;
    }

    /**
     * Searches for a full word in the Trie.
     */
    public boolean search(String word) {
        if (word == null) return false;
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    /**
     * Checks if any word in the Trie begins with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        return getNode(prefix) != null;
    }

    /**
     * Deletes a word from the Trie.
     */
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWord) {
                return false; // Word doesn't exist
            }
            current.isWord = false;
            // If current node has no other children, it can be deleted
            return current.children.isEmpty();
        }

        char ch = word.charAt(index);
        Node child = current.children.get(ch);
        if (child == null) {
            return false;
        }

        boolean shouldDeleteChild = delete(child, word, index + 1);

        if (shouldDeleteChild) {
            current.children.remove(ch);
            // Return true if current node is not a word and has no more children
            return !current.isWord && current.children.isEmpty();
        }

        return false;
    }

    /**
     * Retrieves all words in the Trie starting with a given prefix (Autocomplete).
     */
    public List<String> getWordsWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        Node prefixNode = getNode(prefix);
        if (prefixNode != null) {
            collectWords(prefixNode, new StringBuilder(prefix), results);
        }
        return results;
    }

    private void collectWords(Node node, StringBuilder current, List<String> results) {
        if (node.isWord) {
            results.add(current.toString());
        }

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            current.append(entry.getKey());
            collectWords(entry.getValue(), current, results);
            current.deleteCharAt(current.length() - 1);
        }
    }

    private Node getNode(String str) {
        Node current = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            current = current.children.get(ch);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // 1. Storage of words
        List<String> words = Arrays.asList(
            "apple", "app", "application", "apt", "banana", "bat", "batch", "cat 123", "data structure"
        );
        for (String w : words) {
            trie.insert(w);
        }

        System.out.println("--- Trie Word Storage & Lookup ---");
        System.out.println("Search 'apple': " + trie.search("apple"));           // true
        System.out.println("Search 'appl': " + trie.search("appl"));             // false (prefix only)
        System.out.println("Search 'cat 123': " + trie.search("cat 123"));       // true (spaces & numbers)
        System.out.println("StartsWith 'app': " + trie.startsWith("app"));       // true

        System.out.println("\n--- Autocomplete (Words starting with 'ap') ---");
        System.out.println(trie.getWordsWithPrefix("ap"));

        System.out.println("\n--- Deletion Test ---");
        System.out.println("Deleting 'app'...");
        trie.delete("app");
        System.out.println("Search 'app': " + trie.search("app"));               // false
        System.out.println("Search 'apple': " + trie.search("apple"));           // true (preserved)
        System.out.println("Words with 'ap': " + trie.getWordsWithPrefix("ap")); // ["apt", "apple", "application"]
    }
}
