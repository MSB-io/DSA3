package project;

import java.util.*;

/**
 * ============================================================================
 * DSA 3 INTERNAL PROJECT (Project 15)
 * Title: Trie-Based Dictionary and Autocomplete Engine
 * ============================================================================
 */
public class TrieDictionary {

    // 1. TRIE NODE
    static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean isEndOfWord = false;
        String definition = null;
    }

    private final TrieNode root = new TrieNode();

    // 2. INSERTION: O(L)
    public void insert(String word, String definition) {
        if (word == null || word.trim().isEmpty())
            return;
        TrieNode curr = root;
        for (char ch : word.trim().toLowerCase().toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        curr.definition = definition;
    }

    // 3. SEARCH EXACT WORD: O(L)
    public String search(String word) {
        if (word == null || word.trim().isEmpty())
            return null;
        TrieNode curr = root;
        for (char ch : word.trim().toLowerCase().toCharArray()) {
            curr = curr.children.get(ch);
            if (curr == null)
                return null;
        }
        return curr.isEndOfWord ? curr.definition : null;
    }

    // 4. AUTOCOMPLETE (PREFIX SEARCH): O(P + K)
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        if (prefix == null || prefix.trim().isEmpty())
            return results;

        TrieNode curr = root;
        for (char ch : prefix.trim().toLowerCase().toCharArray()) {
            curr = curr.children.get(ch);
            if (curr == null)
                return results; // prefix does not exist
        }
        dfs(curr, new StringBuilder(prefix.trim().toLowerCase()), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder word, List<String> results) {
        if (node.isEndOfWord) {
            results.add(word.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            word.append(entry.getKey());
            dfs(entry.getValue(), word, results);
            word.deleteCharAt(word.length() - 1); // backtrack
        }
    }

    // 5. SAFE DELETION: O(L)
    public boolean delete(String word) {
        if (word == null || word.trim().isEmpty())
            return false;
        return deleteHelper(root, word.trim().toLowerCase(), 0);
    }

    private boolean deleteHelper(TrieNode curr, String word, int depth) {
        if (depth == word.length()) {
            if (!curr.isEndOfWord)
                return false;
            curr.isEndOfWord = false;
            curr.definition = null;
            return curr.children.isEmpty(); // return true if safe to prune
        }
        char ch = word.charAt(depth);
        TrieNode child = curr.children.get(ch);
        if (child == null)
            return false;

        boolean shouldPrune = deleteHelper(child, word, depth + 1);
        if (shouldPrune) {
            curr.children.remove(ch);
            return !curr.isEndOfWord && curr.children.isEmpty();
        }
        return false;
    }

    // 6. MAIN METHOD & TEST CASES
    public static void main(String[] args) {
        TrieDictionary dict = new TrieDictionary();

        // Sample Vocabulary
        dict.insert("apple", "A sweet red or green fruit.");
        dict.insert("app", "A mobile or desktop application.");
        dict.insert("application", "The action of putting something into operation.");
        dict.insert("apt", "Appropriate or suitable in the circumstances.");
        dict.insert("banana", "A long yellow fruit.");

        System.out.println("=================================================");
        System.out.println("   TRIE DICTIONARY & AUTOCOMPLETE DEMONSTRATION  ");
        System.out.println("=================================================\n");

        // Test Case 1: Exact Search
        System.out.println("[TEST 1] Exact Word Search:");
        System.out.println(" - Search 'apple': " + dict.search("apple"));
        System.out.println(" - Search 'app':   " + dict.search("app"));
        System.out.println(" - Search 'appl':  " + dict.search("appl") + " (Prefix only -> null)\n");

        // Test Case 2: Autocomplete
        System.out.println("[TEST 2] Autocomplete Suggestions for Prefix 'ap':");
        System.out.println(" - Results: " + dict.autocomplete("ap") + "\n");

        // Test Case 3: Safe Deletion
        System.out.println("[TEST 3] Safe Deletion of 'app':");
        dict.delete("app");
        System.out.println(" - Search 'app' post-delete:   " + dict.search("app") + " (Deleted)");
        System.out.println(" - Search 'apple' post-delete: " + dict.search("apple") + " (Preserved)");
        System.out.println(" - Autocomplete for 'ap':      " + dict.autocomplete("ap") + "\n");

        // Test Case 4: Edge Cases
        System.out.println("[TEST 4] Edge Cases:");
        System.out.println(" - Empty query search:     " + dict.search(""));
        System.out.println(" - Non-existent prefix:    " + dict.autocomplete("xyz"));
        System.out.println(" - Case-insensitive lookup: " + dict.search("BaNaNa"));
        System.out.println("=================================================");
    }
}
