package algorithms.strings;

import java.util.Arrays;

/**
 * Multi-Pattern Matching using Generalized Suffix / Delimited String
 * 
 * Demonstrates concatenating text and multiple patterns using unique delimiters:
 * text + "#" + pattern[0] + "$0" + pattern[1] + "$1" ...
 * Suffixes can then be indexed or searched to find all occurrences of patterns in the text.
 * 
 * Note from instructor:
 * Core concept is understanding how multi-pattern matching can be framed as a single
 * string indexing problem using distinct delimiters to avoid cross-boundary false matches.
 */
public class MultiPatternMatching {

    public static void main(String[] args) {
        String text = "banana";
        String[] patterns = {"a", "ana", "anana", "banana", "na", "nana"};

        // Example: banana#0ana$1n%2
        StringBuilder combinedBuilder = new StringBuilder(text);
        combinedBuilder.append("#");

        int[] patternIndices = new int[patterns.length];

        for (int i = 0; i < patterns.length; i++) {
            patternIndices[i] = combinedBuilder.length();
            combinedBuilder.append(patterns[i]).append("$").append(i);
        }

        String combined = combinedBuilder.toString();
        System.out.println("Text: " + text);
        System.out.println("Patterns: " + Arrays.toString(patterns));
        System.out.println("Combined Delimited String: " + combined);

        System.out.println("\n--- Pattern Occurrences in Text ---");
        for (int i = 0; i < patterns.length; i++) {
            String pat = patterns[i];
            System.out.print("Pattern \"" + pat + "\": ");
            int index = text.indexOf(pat);
            if (index == -1) {
                System.out.println("Not Found");
            } else {
                System.out.print("Found at index ");
                while (index != -1) {
                    System.out.print(index + " ");
                    index = text.indexOf(pat, index + 1);
                }
                System.out.println();
            }
        }
    }
}

