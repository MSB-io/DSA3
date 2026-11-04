package project;

import java.util.*;

public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return false;
            }

            if (i == key.length() - 1 && node.eow == false) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static void collectWords(Node curr, String word, List<String> results) {
        if (curr.eow == true) {
            results.add(word);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                char ch = (char) ('a' + i);
                collectWords(curr.children[i], word + ch, results);
            }
        }
    }

    public static List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return results;
            }

            curr = curr.children[idx];
        }

        collectWords(curr, prefix, results);
        return results;
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "by" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("their"));
        System.out.println(search("any"));
        System.out.println(search("thi"));
        System.out.println(search("abc"));

        System.out.println(startsWith("any"));
        System.out.println(startsWith("th"));
        System.out.println(startsWith("abc"));

        System.out.println("Autocomplete for 'th':  " + autocomplete("th"));
        System.out.println("Autocomplete for 'a':   " + autocomplete("a"));
        System.out.println("Autocomplete for 'xyz': " + autocomplete("xyz"));
    }
}
