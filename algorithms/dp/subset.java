package algorithms.dp;

public class subset {
    public static void main(String[] args) {
        int n = 3;

        int totalmasks = 1 << n;

        int[] dp = new int[totalmasks];

        dp[0] = 1;

        for (int mask = 0; mask < totalmasks; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    int newMask = mask | (1 << i);
                    dp[newMask] += dp[mask];
                }
            }
        }
        System.out.println("Total orders = " + dp[totalmasks - 1]);
    }
}
