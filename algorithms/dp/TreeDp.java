package algorithms.dp;

import java.util.*;

/**
 * Tree DP (Dynamic Programming on Trees)
 * 
 * Computes subtree sizes for all nodes in an undirected tree rooted at node 1.
 * Time Complexity: O(V + E) = O(N) since an N-node tree has N - 1 edges.
 * Space Complexity: O(N) for tree adjacency list and recursion stack.
 */
public class TreeDp {

    static List<List<Integer>> tree;
    static int[] dp;

    static void dfs(int node, int parent) {
        // Base case: leaf node or starting count of self
        dp[node] = 1;

        for (int child : tree.get(node)) {
            // Avoid traversing back up to parent in an undirected tree
            if (child != parent) {
                dfs(child, node);
                dp[node] += dp[child];
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Tree structure:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 4},
            {2, 5}
        };

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dp = new int[n + 1];
        dfs(1, 0);

        System.out.println("--- Subtree Sizes Calculated via Tree DP ---");
        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + " -> Subtree Size = " + dp[i]);
        }
    }
}

