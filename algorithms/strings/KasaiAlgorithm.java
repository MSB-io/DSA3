package algorithms.strings;

import java.util.Arrays;

/**
 * Kasai's Algorithm for Longest Common Prefix (LCP) Array Construction.
 * 
 * Given a string and its Suffix Array, Kasai's algorithm builds the LCP array
 * in linear time O(N) using the property:
 *   If LCP(suffix[i], suffix[j]) = h, then LCP(suffix[i+1], suffix[k]) >= h - 1.
 * 
 * Time Complexity: O(N) for LCP construction (given suffix array).
 * Space Complexity: O(N) for rank and LCP arrays.
 */
public class KasaiAlgorithm {

    /**
     * Builds the LCP (Longest Common Prefix) array using Kasai's algorithm.
     * lcp[i] stores the length of the longest common prefix between
     * suffixArray[i] and suffixArray[i - 1]. (lcp[0] is typically 0).
     */
    public static int[] buildLCP(String text, int[] suffixArray) {
        int n = text.length();
        int[] lcp = new int[n];

        // rank[i] stores the position of suffix starting at text index i in suffixArray
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[suffixArray[i]] = i;
        }

        int h = 0; // length of previous LCP
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = suffixArray[rank[i] - 1]; // previous suffix in sorted order

                // Extend matching characters
                while (i + h < n && j + h < n && text.charAt(i + h) == text.charAt(j + h)) {
                    h++;
                }

                lcp[rank[i]] = h;

                // For the next suffix text[i+1...], the LCP is at least h - 1
                if (h > 0) {
                    h--;
                }
            }
        }

        return lcp;
    }

    /**
     * Helper method to build suffix array by sorting suffix indices.
     */
    public static int[] buildSuffixArray(String text) {
        int n = text.length();
        Integer[] sa = new Integer[n];
        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        Arrays.sort(sa, (a, b) -> text.substring(a).compareTo(text.substring(b)));

        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = sa[i];
        }
        return suffixArray;
    }

    public static void main(String[] args) {
        String text = "banana";
        int[] suffixArray = buildSuffixArray(text);
        int[] lcp = buildLCP(text, suffixArray);

        System.out.println("Text: " + text);
        System.out.println("Suffix Array: " + Arrays.toString(suffixArray));
        System.out.println("LCP Array:    " + Arrays.toString(lcp));

        System.out.println("\nDetailed Suffix & LCP breakdown:");
        System.out.printf("%-5s %-10s %-5s %-15s%n", "Rank", "Index", "LCP", "Suffix");
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%-5d %-10d %-5d %-15s%n", i, suffixArray[i], lcp[i], text.substring(suffixArray[i]));
        }
    }
}

