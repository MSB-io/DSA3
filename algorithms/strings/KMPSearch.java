package algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Knuth-Morris-Pratt (KMP) Pattern Matching Algorithm
 * 
 * Uses the pre-computed LPS (Longest Proper Prefix which is also Suffix) array
 * to avoid backtracking in the text when a character mismatch occurs.
 * 
 * Time Complexity:
 *   - LPS Preprocessing: O(M) where M is pattern length
 *   - Pattern Search:     O(N) where N is text length
 *   - Total Time:         O(N + M)
 * Space Complexity:       O(M) for LPS array
 */
public class KMPSearch {

    /**
     * Builds LPS array for the pattern.
     */
    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Searches for all occurrences of pattern in text using KMP.
     */
    public static List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m == 0 || n < m) return occurrences;

        int[] lps = buildLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                occurrences.add(i - j); // Match found at index (i - j)
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        System.out.println("Text:    " + text);
        System.out.println("Pattern: " + pattern);

        List<Integer> matches = search(text, pattern);
        System.out.println("Pattern found at starting indices: " + matches);

        for (int idx : matches) {
            System.out.println("Match: \"" + text.substring(idx, idx + pattern.length()) + "\" at index " + idx);
        }
    }
}

