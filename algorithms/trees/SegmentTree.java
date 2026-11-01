package algorithms.trees;

import java.util.Arrays;

/**
 * Segment Tree with Lazy Propagation
 * 
 * Supports:
 * 1. Range Sum Queries in O(log N)
 * 2. Range Updates (Add value to [L..R]) with Lazy Propagation in O(log N)
 * 3. Point Queries / Updates in O(log N)
 * 4. Online and Offline Query Processing
 * 
 * Space Complexity: O(4 * N) = O(N)
 * Time Complexity:
 *   - Build: O(N)
 *   - Range Query: O(log N)
 *   - Range Update: O(log N)
 */
public class SegmentTree {

    private final long[] tree;
    private final long[] lazy;
    private final int n;

    public SegmentTree(int[] values) {
        n = values.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        build(1, 0, n - 1, values);
    }

    /**
     * Builds the segment tree recursively.
     * node: index in tree[] array (1-based)
     * start, end: segment range [start..end]
     */
    private void build(int node, int start, int end, int[] values) {
        if (start == end) {
            tree[node] = values[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        build(leftChild, start, mid, values);
        build(rightChild, mid + 1, end, values);

        tree[node] = tree[leftChild] + tree[rightChild];
    }

    /**
     * Propagates pending lazy updates down to child nodes.
     */
    private void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            // Apply lazy update to current node
            tree[node] += (end - start + 1) * lazy[node];

            // If not a leaf node, pass pending update to children
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            // Clear lazy value for current node
            lazy[node] = 0;
        }
    }

    /**
     * Range Update: Adds 'val' to all elements in range [l..r].
     */
    public void updateRange(int l, int r, long val) {
        updateRange(1, 0, n - 1, l, r, val);
    }

    private void updateRange(int node, int start, int end, int l, int r, long val) {
        // Resolve pending lazy updates
        propagate(node, start, end);

        // Out of range
        if (start > end || start > r || end < l) {
            return;
        }

        // Segment completely within [l..r]
        if (start >= l && end <= r) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[2 * node] += val;
                lazy[2 * node + 1] += val;
            }
            return;
        }

        int mid = start + (end - start) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    /**
     * Range Query: Calculates the sum of elements in range [l..r].
     */
    public long queryRange(int l, int r) {
        return queryRange(1, 0, n - 1, l, r);
    }

    private long queryRange(int node, int start, int end, int l, int r) {
        // Resolve pending lazy updates
        propagate(node, start, end);

        // Out of range
        if (start > end || start > r || end < l) {
            return 0;
        }

        // Segment completely within [l..r]
        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        long leftSum = queryRange(2 * node, start, mid, l, r);
        long rightSum = queryRange(2 * node + 1, mid + 1, end, l, r);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 5, 7, 9, 11};
        System.out.println("Initial Array: " + Arrays.toString(values));

        SegmentTree segTree = new SegmentTree(values);

        // Online Query: Range Sum [1..3] -> 3 + 5 + 7 = 15
        System.out.println("\n--- Online Range Queries ---");
        System.out.println("Sum of range [1..3]: " + segTree.queryRange(1, 3)); // 15
        System.out.println("Sum of range [0..5]: " + segTree.queryRange(0, 5)); // 36

        // Lazy Range Update: Add 10 to range [1..4]
        // Updated array would be: [1, 13, 15, 17, 19, 11]
        System.out.println("\n--- Lazy Range Update (+10 to indices [1..4]) ---");
        segTree.updateRange(1, 4, 10);

        System.out.println("Sum of range [1..3] after update: " + segTree.queryRange(1, 3)); // 13 + 15 + 17 = 45
        System.out.println("Sum of range [0..5] after update: " + segTree.queryRange(0, 5)); // 76
        System.out.println("Sum of index [4..4]: " + segTree.queryRange(4, 4));              // 19
    }
}
