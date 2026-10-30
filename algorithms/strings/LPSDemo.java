package algorithms.strings;

import java.util.Arrays;

/**
 * LPS (Longest Proper Prefix which is also Suffix) Array Construction for KMP.
 * 
 * lps[i] stores the length of the longest proper prefix of pattern[0..i]
 * that is also a suffix of pattern[0..i].
 * 
 * Time Complexity: O(N) where N is pattern length.
 * Space Complexity: O(N) for LPS array.
 */
public class LPSDemo {

    static int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        // lps[0] is always 0
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Fall back to previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String pattern = "AAACAAAA";
        int[] lps = buildLPS(pattern);

        System.out.println("Pattern:   " + pattern);
        System.out.println("LPS Array: " + Arrays.toString(lps));

        System.out.println("\n--- Step-by-Step Index Breakdown ---");
        for (int i = 0; i < pattern.length(); i++) {
            System.out.println("Substr: " + pattern.substring(0, i + 1) + 
                               " | char: " + pattern.charAt(i) + 
                               " | lps[" + i + "] = " + lps[i]);
        }
    }
}

