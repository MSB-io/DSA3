import java.util.*;

public class  EdmondsKarp {

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
        boolean[] finalVisited = new boolean[n];

        while (true) {
            boolean[] visited = new boolean[n];
            Arrays.fill(parent, -1);

            if (!dfs(residual, source, sink, visited, parent)) {
                finalVisited = visited; 
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

        System.out.println("Capacity of the Minimum Cut (Max Flow): " + maxFlow);
        System.out.println("Edges in the Minimum Cut set:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (finalVisited[i] && !finalVisited[j] && capacity[i][j] > 0) {
                    System.out.println(i + " -> " + j + " (Capacity: " + capacity[i][j] + ")");
                }
            }
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] capacity = {
            {0, 10, 5, 0},
            {0, 0, 5, 0},
            {5, 0, 0, 0},
            {10, 0, 0, 0}
        };

       
        maxFlow(capacity, 0, 2);
    }
}