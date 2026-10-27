import java.util.*;

public class TarjanAlgo {

    static int time = 0;

    static int[] disc;
    static int[] low;
    static boolean[] onStack;

    static Stack<Integer> stack = new Stack<>();
    static List<List<Integer>> graph;

    static void tarjan(int u) {
        disc[u] = low[u] = time++;
        stack.push(u);
        onStack[u] = true;
        for (int v : graph.get(u)) {

            if (disc[v] == -1) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

      
        if (low[u] == disc[u]) {

            System.out.print("SCC: ");

            int v;

            do {
                v = stack.pop();
                onStack[v] = false;

                System.out.print((char) ('A' + v) + " ");

            } while (v != u);

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 7;

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // A -> B
        graph.get(0).add(1);

        // B -> C, D
        graph.get(1).add(2);
        graph.get(1).add(3);

        // C -> A
        graph.get(2).add(0);

        // D -> E
        graph.get(3).add(4);

        // E -> F
        graph.get(4).add(5);

        // F -> D, G
        graph.get(5).add(3);
        graph.get(5).add(6);

        // G -> G
        graph.get(6).add(6);

        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                tarjan(i);
            }
        }
    }
}