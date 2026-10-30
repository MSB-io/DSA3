package algorithms.dp;

import java.util.*;

/**
 * DP Transitions / Transaction DP
 * 
 * Demonstrates 1D Dynamic Programming state transitions on a numeric string
 * "11231".
 * Tracks state changes / transitions between consecutive elements:
 * - dp[i] stores the cumulative count of transitions up to index i.
 * - If num[i] != num[i-1], a state transition occurs (dp[i] = dp[i-1] + 1).
 * - Otherwise, state persists (dp[i] = dp[i-1]).
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class TransactionDp {

    public static void main(String[] args) {

        String num = "11231";
        int n = num.length();

        int[] dp = new int[n];

        // Base case: 0 transitions at the first element
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (num.charAt(i) != num.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println("String: " + num);
        System.out.println("Cumulative state transitions at each index: " + Arrays.toString(dp));
        System.out.println("Total transitions across string: " + dp[n - 1]);
    }
}
