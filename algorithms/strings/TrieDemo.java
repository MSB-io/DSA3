package algorithms.strings;

/**
 * Standard Trie (Prefix Tree) Implementation
 * 
 * Supports insert, search, and startsWith prefix checking in O(L) time,
 * where L is the length of the word/query.
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

public class TrieDemo {
    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    static boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEnd;
    }

    static boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "banana", "bat", "ball"};
        for (String word : words) {
            insert(word);
        }

        System.out.println("--- Trie Operations ---");
        System.out.println("Search 'apple': " + search("apple"));       // true
        System.out.println("Search 'app': " + search("app"));           // true
        System.out.println("Search 'appl': " + search("appl"));         // false
        System.out.println("Prefix 'ban': " + startsWith("ban"));       // true
        System.out.println("Prefix 'cat': " + startsWith("cat"));       // false
    }
}

