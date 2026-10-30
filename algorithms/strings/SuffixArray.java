package algorithms.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Suffix Array Construction (Basics & Optimized Coding)
 * 
 * 1. SA Construction Basics:
 *    - Naive approach: Generates all N suffixes and sorts them.
 *    - Time Complexity: O(N^2 * log N) due to string comparisons.
 * 
 * 2. SA Coding (Optimized Prefix Doubling):
 *    - Sorts suffixes by comparing prefixes of length 2^k using rank pairs.
 *    - Time Complexity: O(N * log^2 N) or O(N * log N).
 *    - Space Complexity: O(N).
 */
public class SuffixArray {

    /**
     * Approach 1: SA Construction Basics (Naive sorting)
     */
    public static int[] buildSuffixArrayNaive(String text) {
        int n = text.length();
        Integer[] sa = new Integer[n];
        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        Arrays.sort(sa, (a, b) -> text.substring(a).compareTo(text.substring(b)));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = sa[i];
        }
        return result;
    }

    /**
     * Suffix tuple for prefix doubling
     */
    static class Suffix {
        int index;
        int rank0;
        int rank1;
    }

    /**
     * Approach 2: SA Coding (Prefix Doubling - O(N log^2 N))
     */
    public static int[] buildSuffixArrayOptimized(String text) {
        int n = text.length();
        Suffix[] suffixes = new Suffix[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix();
            suffixes[i].index = i;
            suffixes[i].rank0 = text.charAt(i) - 'a';
            suffixes[i].rank1 = (i + 1 < n) ? (text.charAt(i + 1) - 'a') : -1;
        }

        Comparator<Suffix> cmp = (a, b) -> {
            if (a.rank0 != b.rank0) return Integer.compare(a.rank0, b.rank0);
            return Integer.compare(a.rank1, b.rank1);
        };

        Arrays.sort(suffixes, cmp);

        int[] ind = new int[n]; // maps original suffix index to position in suffixes[]

        for (int k = 4; k < 2 * n; k *= 2) {
            int rank = 0;
            int prevRank = suffixes[0].rank0;
            suffixes[0].rank0 = rank;
            ind[suffixes[0].index] = 0;

            for (int i = 1; i < n; i++) {
                if (suffixes[i].rank0 == prevRank && suffixes[i].rank1 == suffixes[i - 1].rank1) {
                    prevRank = suffixes[i].rank0;
                    suffixes[i].rank0 = rank;
                } else {
                    prevRank = suffixes[i].rank0;
                    suffixes[i].rank0 = ++rank;
                }
                ind[suffixes[i].index] = i;
            }

            for (int i = 0; i < n; i++) {
                int nextIndex = suffixes[i].index + k / 2;
                suffixes[i].rank1 = (nextIndex < n) ? suffixes[ind[nextIndex]].rank0 : -1;
            }

            Arrays.sort(suffixes, cmp);
        }

        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = suffixes[i].index;
        }
        return suffixArray;
    }

    public static void main(String[] args) {
        String text = "banana";

        System.out.println("Text: " + text);

        // 1. SA Construction Basics
        int[] saNaive = buildSuffixArrayNaive(text);
        System.out.println("SA (Basics - Naive):     " + Arrays.toString(saNaive));

        // 2. SA Coding (Prefix Doubling)
        int[] saOpt = buildSuffixArrayOptimized(text);
        System.out.println("SA (Coding - Doubling):  " + Arrays.toString(saOpt));

        System.out.println("\nSorted Suffixes:");
        for (int i = 0; i < text.length(); i++) {
            System.out.printf("Rank %d | Index %d | Suffix: %s%n", i, saOpt[i], text.substring(saOpt[i]));
        }
    }
}
