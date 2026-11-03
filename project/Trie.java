package project;

// 15. Trie-Based Dictionary and Autocomplete
// Store words in a trie and support word search, prefix search, and autocomplete suggestions.
import java.util.*;

// creating and defining the trie data structure

public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26]; // a to z
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node(); // root

    // inserting the value in the trie

    public static void insert(String word) // O(L)
    {
        // root ki value hamesha fixed honi chaiye
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // to get the index of the character, e.g. 'c' - 'a' = 2, 'b' - 'a' = 1 and
                                            // 'a' - 'a' = 0.

            if (curr.children[idx] == null) {
                // if the node is null then create a new node.
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                // mark the end of the word.
                curr.children[idx].eow = true;
            }

            // update the root
            curr = curr.children[idx];
        }
    }

    // search for exact word.

    public static boolean search(String key) {

        // iska bhi O(L) where L is key length.

        Node curr = root;

        // almost same code as insert
        for (int i = 0; i < key.length(); i++) {

            // get the current index jaha search karna hai
            int idx = key.charAt(i) - 'a';

            Node node = curr.children[idx];

            // agar root ke children array ke index me null value stored hai toh return
            // false.
            if (node == null) {
                return false;
            }

            // agar jo search karna hai woh exist hi nai karta toh return false.
            if (i == key.length() - 1 && node.eow == false) {
                return false;
            }

            // update the root.
            curr = curr.children[idx];
        }

        return true;
    }

    // startsWith or Prefix search.

    public static boolean startsWith(String prefix) {

        // iska bhi O(L)

        Node curr = root;

        // almost same code as insert
        for (int i = 0; i < prefix.length(); i++) {

            // get the current index jaha search karna hai
            int idx = prefix.charAt(i) - 'a';

            Node node = curr.children[idx];

            // agar root ke children array ke index me null value stored hai toh return
            // false.
            if (node == null) {
                return false;
            }

            // update the root.
            curr = curr.children[idx];
        }

        return true;
    }

    // helper function: recursively saare words dhoondta hai jo iss node ke niche
    // hain
    public static void collectWords(Node curr, String word, List<String> results) {

        // agar iss node pe word khatam ho raha hai (eow == true) toh results me add
        // karo
        if (curr.eow == true) {
            results.add(word);
        }

        // a to z saare 26 children check karo
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                // index se character nikalo (e.g. 0 -> 'a', 1 -> 'b')
                char ch = (char) ('a' + i);

                // aage explore karo
                collectWords(curr.children[i], word + ch, results);
            }
        }
    }

    // autocomplete: prefix ke matching saare suggestions return karega
    public static List<String> autocomplete(String prefix) {

        List<String> results = new ArrayList<>();
        Node curr = root;

        // pehle prefix ke aakhri character tak pohoncho (same as startsWith)
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            Node node = curr.children[idx];

            // agar prefix hi exist nahi karta toh empty list return karo
            if (node == null) {
                return results;
            }

            curr = curr.children[idx];
        }

        // ab curr node se saare words collect karke results me daalo
        collectWords(curr, prefix, results);

        return results;
    }

    public static void main(String[] args) {

        // define the array containing the words to be inserted in the trie
        String words[] = { "the", "a", "there", "their", "any", "by" };

        // insert the value in the trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // search for exact "their" and "any"
        System.out.println(search("their")); // should return true
        System.out.println(search("any")); // should return true
        System.out.println(search("thi")); // should return false
        System.out.println(search("abc")); // should return false

        // search for prefix
        System.out.println(startsWith("any")); // should return true
        System.out.println(startsWith("th")); // should return true
        System.out.println(startsWith("abc")); // should return false

        // autocomplete suggestions
        System.out.println("Autocomplete for 'th':  " + autocomplete("th")); // [the, their, there]
        System.out.println("Autocomplete for 'a':   " + autocomplete("a")); // [a, any]
        System.out.println("Autocomplete for 'xyz': " + autocomplete("xyz")); // []
    }
}