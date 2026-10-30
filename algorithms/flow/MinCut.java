package algorithms.flow;

import java.util.*;

/**
 * Minimum Cut Algorithm in a Flow Network (Max-Flow Min-Cut Theorem)
 * 
 * Theorem:
 *   The maximum value of an s-t flow is equal to the minimum capacity
 *   over all s-t cuts.
 * 
 * Method:
 *   1. Run Edmonds-Karp / Ford-Fulkerson to compute maximum flow and final residual graph.
 *   2. Find all vertices reachable from source 's' in the residual graph (Partition S).
 *   3. Partition T contains all remaining vertices (not reachable from 's').
 *   4. Any original edge (u -> v) with capacity > 0 where u in S and v in T belongs
 *      to the Minimum Cut set.
 * 
 * Time Complexity: O(V * E^2) using BFS augmenting paths.
 * Space Complexity: O(V^2) for residual and capacity representation.
 */
public class MinCut {

    static boolean bfs(int[][] residual, int source, int sink, int[] parent) {
        int n = residual.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < n; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    parent[v] = u;
                    visited[v] = true;
                    queue.add(v);

                    if (v == sink) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // DFS to identify all vertices reachable from source in residual network
    static void dfsReachability(int[][] residual, int s, boolean[] visited) {
        visited[s] = true;
        for (int v = 0; v < residual.length; v++) {
            if (residual[s][v] > 0 && !visited[v]) {
                dfsReachability(residual, v, visited);
            }
        }
    }

    public static void findMinCut(int[][] capacity, int source, int sink) {
        int n = capacity.length;
        int[][] residual = new int[n][n];

        for (int i = 0; i < n; i++) {
            residual[i] = capacity[i].clone();
        }

        int[] parent = new int[n];
        int maxFlow = 0;

        // Augment flow using BFS (Edmonds-Karp)
        while (bfs(residual, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        // Find vertices reachable from source in residual graph (Partition S)
        boolean[] isReachable = new boolean[n];
        dfsReachability(residual, source, isReachable);

        System.out.println("Maximum Flow / Min-Cut Capacity: " + maxFlow);
        System.out.println("\nPartition S (Reachable from Source):");
        for (int i = 0; i < n; i++) {
            if (isReachable[i]) System.out.print(i + " ");
        }

        System.out.println("\n\nPartition T (Non-reachable from Source):");
        for (int i = 0; i < n; i++) {
            if (!isReachable[i]) System.out.print(i + " ");
        }

        System.out.println("\n\nEdges in the Minimum Cut set:");
        int cutCapacity = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isReachable[i] && !isReachable[j] && capacity[i][j] > 0) {
                    System.out.println("Edge " + i + " -> " + j + " | Capacity = " + capacity[i][j]);
                    cutCapacity += capacity[i][j];
                }
            }
        }
        System.out.println("Total Min-Cut Value = " + cutCapacity + " (Matches Max-Flow: " + (cutCapacity == maxFlow) + ")");
    }

    public static void main(String[] args) {
        int[][] capacity = {
            {0, 10, 5, 0},
            {0, 0, 5, 0},
            {5, 0, 0, 0},
            {10, 0, 0, 0}
        };

        findMinCut(capacity, 0, 2);
    }
}

