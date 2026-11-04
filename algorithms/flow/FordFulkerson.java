package algorithms.flow;

import java.util.*;

public class FordFulkerson {

    static boolean dfs(int[][] residual, int u, int sink,
            boolean[] visited, int[] parent) {

        visited[u] = true;

        if (u == sink) {
            return true;
        }

        for (int v = 0; v < residual.length; v++) {
            if (!visited[v] && residual[u][v] > 0) {
                parent[v] = u;

                if (dfs(residual, v, sink, visited, parent)) {
                    return true;
                }
            }
        }

        return false;
    }

    static int maxFlow(int[][] capacity, int source, int sink) {
        int n = capacity.length;
        int[][] residual = new int[n][n];

        for (int i = 0; i < n; i++) {
            residual[i] = capacity[i].clone();
        }

        int[] parent = new int[n];
        int maxFlow = 0;

        while (true) {
            boolean[] visited = new boolean[n];
            Arrays.fill(parent, -1);

            if (!dfs(residual, source, sink, visited, parent)) {
                break;
            }

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

        return maxFlow;
    }

    public static void main(String[] args) {
        // Node mapping: 0 = s, 1 = 1, 2 = 2, 3 = 3, 4 = t
        int[][] capacity = {
                { 0, 2, 3, 0, 0 }, // s -> 1 (cap 2), s -> 2 (cap 3)
                { 0, 0, 0, 0, 3 }, // 1 -> t (cap 3)
                { 0, 1, 0, 1, 0 }, // 2 -> 1 (cap 1), 2 -> 3 (cap 1)
                { 0, 0, 0, 0, 3 }, // 3 -> t (cap 3)
                { 0, 0, 0, 0, 0 }  // t (sink has no outgoing edges)
        };

        System.out.println("Max Flow = " + maxFlow(capacity, 0, 4));
    }
}