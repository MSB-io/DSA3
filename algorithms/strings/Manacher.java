package algorithms.strings;

/**
 * Manacher's Algorithm for Longest Palindromic Substring in O(N) time.
 * 
 * Transforms string by inserting '#' between each character to uniformly handle
 * both odd and even length palindromes. Maintains center C and right boundary R
 * of the most rightward palindrome found so far to achieve linear time.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class Manacher {

    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // Insert '#' between characters and around the string
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        String str = sb.toString();
        int n = str.length();

        int[] p = new int[n]; // p[i] = radius of palindrome centered at i
        int c = 0;            // Center of the palindrome extending furthest right
        int r = 0;            // Right boundary of the palindrome extending furthest right

        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 0; i < n; i++) {
            int iMirror = 2 * c - i; // Mirror of i with respect to center c

            // If within current right boundary, use symmetry
            if (r > i) {
                p[i] = Math.min(r - i, p[iMirror]);
            } else {
                p[i] = 0;
            }

            // Expand palindrome centered at i beyond current known radius
            while (i - 1 - p[i] >= 0 && i + 1 + p[i] < n &&
                   str.charAt(i + 1 + p[i]) == str.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            // If expanded past r, update center and right boundary
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            // Track longest palindrome
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Extract longest palindromic substring from original string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String[] testCases = {"babad", "cbbd", "racecar", "forgeeksskeegfor"};

        System.out.println("--- Manacher's O(N) Palindrome Algorithm ---");
        for (String test : testCases) {
            String lps = longestPalindrome(test);
            System.out.println("String: \"" + test + "\" -> Longest Palindrome: \"" + lps + "\" (Length: " + lps.length() + ")");
        }
    }
}

