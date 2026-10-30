package algorithms.strings;

import java.util.*;

/**
 * Aho-Corasick Multi-Pattern Matching Algorithm (Fail-Link Algorithm)
 * 
 * Constructs a finite-state machine from a Trie with failure links (similar to KMP).
 * Allows matching an arbitrary set of patterns against an input text in O(Text + Patterns + Matches).
 * 
 * Time Complexity:
 *   - Trie construction: O(sum of pattern lengths)
 *   - Failure link construction (BFS): O(sum of pattern lengths * alphabet_size)
 *   - Text search: O(text length + matches)
 */
public class AhoCorasick {

    static class Node {
        Node[] next = new Node[26];
        Node fail;
        List<String> output = new ArrayList<>();
    }

    static Node root = new Node();

    static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.output.add(word);
    }

    static void buildFailLinks() {
        Queue<Node> queue = new LinkedList<>();

        // Level 1: All immediate children of root fail back to root
        for (int i = 0; i < 26; i++) {
            if (root.next[i] != null) {
                root.next[i].fail = root;
                queue.add(root.next[i]);
            }
        }

        // BFS to build fail links for deeper levels
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 26; i++) {
                Node child = curr.next[i];
                if (child != null) {
                    Node f = curr.fail;

                    // Follow fail links until a transition matching char i is found
                    while (f != null && f.next[i] == null) {
                        f = f.fail;
                    }

                    child.fail = (f != null) ? f.next[i] : root;

                    // Inherit output matches from fail node
                    child.output.addAll(child.fail.output);

                    queue.add(child);
                }
            }
        }
    }

    static void search(String text) {
        Node curr = root;

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';

            // Follow fail links if no matching child exists
            while (curr != null && curr.next[index] == null) {
                curr = curr.fail;
            }

            curr = (curr != null) ? curr.next[index] : root;

            if (curr != null && !curr.output.isEmpty()) {
                for (String match : curr.output) {
                    int start = i - match.length() + 1;
                    System.out.println("Pattern \"" + match + "\" found at indices [" + start + " .. " + i + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] patterns = {"he", "she", "his", "hers"};
        for (String pat : patterns) {
            insert(pat);
        }

        buildFailLinks();

        String text = "ushers";
        System.out.println("Text: " + text);
        System.out.println("Patterns: " + Arrays.toString(patterns));
        System.out.println("Matches found via Aho-Corasick:");
        search(text);
    }
}

