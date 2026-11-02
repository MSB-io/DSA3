package algorithms.trees;

import java.util.Arrays;

/**
 * ============================================================================
 * Binary Indexed Tree (BIT) / Fenwick Tree
 * ============================================================================
 * 
 * CORE CONCEPT:
 * A Binary Indexed Tree (BIT) is a data structure that provides efficient 
 * methods for:
 * 1. Computing prefix sums and range sums in O(log N)
 * 2. Updating elements (point updates) in O(log N)
 * 
 * WHY IS IT CALLED "BIT"?
 * - It stands for Binary Indexed Tree.
 * - Each index stores the sum of a specific sub-range whose length is determined
 *   by the Lowest Significant Set Bit (LSB): (i & -i).
 * 
 * ADVANTAGE OVER SEGMENT TREE:
 * - Requires only O(N) memory (exactly n + 1 integers vs 4 * n for Segment Tree).
 * - Exceptionally simple and fast to implement.
 * ============================================================================
 */
public class BinaryIndexedTree {

    private final int[] tree;
    private final int n;

    /**
     * Initializes a Binary Indexed Tree of size n.
     * Uses 1-based indexing (size n + 1) because index 0 cannot use (i & -i).
     */
    public BinaryIndexedTree(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    /**
     * Constructs a BIT from an existing array of values.
     */
    public BinaryIndexedTree(int[] values) {
        this.n = values.length;
        this.tree = new int[n + 1];

        // Populate tree using point updates (1-based index: i + 1)
        for (int i = 0; i < n; i++) {
            update(i + 1, values[i]);
        }
    }

    /**
     * Point Update: Adds 'delta' to the element at 1-based index 'i'.
     * 
     * HOW IT WORKS:
     * - We add 'delta' to tree[i].
     * - To find the next responsible ancestor node, we add the lowest set bit:
     *   i += (i & -i).
     * 
     * TIME COMPLEXITY: O(log N)
     */
    public void update(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            // Move up to the next parent node responsible for this range
            i += (i & -i);
        }
    }

    /**
     * Prefix Sum Query: Calculates the sum of elements from index 1 to 'i'.
     * 
     * HOW IT WORKS:
     * - Accumulate tree[i] to sum.
     * - Move to the predecessor sub-range by subtracting the lowest set bit:
     *   i -= (i & -i).
     * 
     * TIME COMPLEXITY: O(log N)
     */
    public int queryPrefix(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            // Remove the lowest set bit to jump to the preceding disjoint interval
            i -= (i & -i);
        }
        return sum;
    }

    /**
     * Range Sum Query: Calculates sum in range [l..r] (1-based indices).
     * 
     * Formula:
     *   sum[l..r] = queryPrefix(r) - queryPrefix(l - 1)
     * 
     * TIME COMPLEXITY: O(log N)
     */
    public int queryRange(int l, int r) {
        if (l > r) return 0;
        return queryPrefix(r) - queryPrefix(l - 1);
    }

    public static void main(String[] args) {
        int[] values = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2};
        System.out.println("Original Array: " + Arrays.toString(values));

        BinaryIndexedTree bit = new BinaryIndexedTree(values);

        System.out.println("\n--- Binary Indexed Tree (BIT) Operations ---");

        // Prefix sum from 1 to 5: 3 + 2 + (-1) + 6 + 5 = 15
        System.out.println("Prefix Sum [1..5]: " + bit.queryPrefix(5)); // Expected: 15

        // Range sum from 3 to 7: (-1) + 6 + 5 + 4 + (-3) = 11
        System.out.println("Range Sum  [3..7]: " + bit.queryRange(3, 7)); // Expected: 11

        // Update: Add 5 to index 4 (value was 6, now 11)
        System.out.println("\nUpdating index 4 by +5...");
        bit.update(4, 5);

        // Re-evaluate queries
        System.out.println("Prefix Sum [1..5] after update: " + bit.queryPrefix(5)); // Expected: 20
        System.out.println("Range Sum  [3..7] after update: " + bit.queryRange(3, 7)); // Expected: 16
    }
}

