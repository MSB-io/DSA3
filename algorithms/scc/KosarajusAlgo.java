
import java.util.*;

public class KosarajusAlgo {

    static void dfs1(
            int node,
            List<List<Integer>> graph,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, graph, visited, stack);
            }
        }

      
        stack.push(node);
    }

    static void dfs2(
            int node,
            List<List<Integer>> reversed,
            boolean[] visited) {

        visited[node] = true;
        System.out.print((char) ('A' + node) + " ");

        for (int neighbor : reversed.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, reversed, visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 7;

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reversed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

       
        graph.get(0).add(1); // A -> B
        graph.get(1).add(2); // B -> C
        graph.get(2).add(0); // C -> A
        graph.get(1).add(3); // B -> D
        graph.get(3).add(4); // D -> E
        graph.get(4).add(5); // E -> F
        graph.get(5).add(3); // F -> D
        graph.get(5).add(6); // F -> G
        graph.get(6).add(6); // G -> G

        
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                reversed.get(v).add(u);
            }
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(i, graph, visited, stack);
            }
        }

        
        Arrays.fill(visited, false);

        int count = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                count++;
                System.out.print("SCC reversed " + count + ": ");
                dfs2(node, reversed, visited);
                System.out.println();
            }
        }
    }
}