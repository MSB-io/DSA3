# DSA 3: Advanced Data Structures and Algorithms

This repository contains implementations, technical reports, and explanatory guides.  
The topics include Strongly Connected Components (SCC) and Maximum Network Flow with Minimum Cut.

---

## 1. Directory Structure

```
DSA3/
├── algorithms/
│   ├── scc/                           # Strongly Connected Components
│   │   ├── KosarajusAlgo.java        # Kosaraju algorithm implementation
│   │   └── TarjanAlgo.java           # Tarjan algorithm implementation
│   └── flow/                          # Network Flow and Cut Problems
│       ├── FordFulkerson.java        # Ford-Fulkerson algorithm implementation
│       └── EdmondsKarp.java          # Edmonds-Karp and Min-Cut implementation
├── docs/                              # Technical Reports and Guides
│   ├── Edmonds_Karp_and_Min_Cut_Explained.md
│   ├── Ford_Fulkerson_Algorithm_Explained.md
│   ├── Kosarajus_Algorithm_Explained.md
│   ├── Tarjans_Algorithm_Explained.md
│   ├── Edmonds-Karp and Min-Cut Technical Report.pdf
│   ├── Ford-Fulkerson Algorithm Technical Report.pdf
│   ├── Kosaraju's Algorithm Technical Report.pdf
│   └── Tarjan's Algorithm Technical Report.pdf
├── .gitignore                         # Git exclusion rules
└── README.md                          # Repository documentation
```

---

## 2. Strongly Connected Components (algorithms/scc/)

A Strongly Connected Component (SCC) is a maximal sub-graph of a directed graph.  
In an SCC, every node can reach every other node in both directions.

| File | Algorithm | Method | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| [`KosarajusAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/KosarajusAlgo.java) | Kosaraju-Sharir | Two-pass DFS with transposed graph ($G^T$) | $\mathcal{O}(V + E)$ | $\mathcal{O}(V + E)$ |
| [`TarjanAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/TarjanAlgo.java) | Tarjan | Single-pass DFS with low-link values | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |

### Comparison of Methods
* **Kosaraju Algorithm:**
  1. Run a DFS traversal on the original graph.
  2. Push each node to a stack when its traversal finishes.
  3. Reverse all directed edges to build the transposed graph ($G^T$).
  4. Pop nodes from the stack and run DFS traversals on $G^T$.
* **Tarjan Algorithm:**
  1. Run a single DFS traversal.
  2. Assign a discovery time and compute a low-link value for each node.
  3. Push visited nodes to an active stack.
  4. Pop nodes from the stack when a node satisfies the root condition `low[u] == disc[u]`.

---

## 3. Maximum Network Flow and Minimum Cut (algorithms/flow/)

These algorithms calculate the maximum possible flow from a source node $s$ to a sink node $t$.  
The calculations follow the Max-Flow Min-Cut Theorem:

$$\text{Maximum Flow Value} = \text{Capacity of Minimum Cut}$$

| File | Method | Capability | Complexity |
| :--- | :--- | :--- | :--- |
| [`FordFulkerson.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/FordFulkerson.java) | Augmenting paths via DFS | Calculates total maximum flow | $\mathcal{O}(E \cdot \text{max flow})$ |
| [`EdmondsKarp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/EdmondsKarp.java) | Augmenting paths and cut extraction | Calculates maximum flow and identifies minimum cut edges | $\mathcal{O}(E \cdot \text{max flow})$ |

### Minimum Cut Set Identification
1. Find all augmenting paths until no capacity remains in the residual graph.
2. Group nodes into two partitions based on reachability from the source node:
   * Partition $S$: Nodes reachable from the source in the residual graph.
   * Partition $T$: Nodes not reachable from the source in the residual graph.
3. Select each directed edge $(u, v)$ where $u \in S$, $v \in T$, and original $\text{capacity}[u][v] > 0$.  
   These edges form the minimum cut set.

---

## 4. Technical Documentation (docs/)

### Simplified Technical English (STE) Guides
* **[`Kosarajus_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Kosarajus_Algorithm_Explained.md):** Complete guide for the two-pass Kosaraju algorithm.
* **[`Tarjans_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Tarjans_Algorithm_Explained.md):** Complete guide for the single-pass Tarjan algorithm.
* **[`Ford_Fulkerson_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Ford_Fulkerson_Algorithm_Explained.md):** Complete guide for network flow and residual graph updates.
* **[`Edmonds_Karp_and_Min_Cut_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Edmonds_Karp_and_Min_Cut_Explained.md):** Complete guide for the Max-Flow Min-Cut Theorem and cut-set extraction.

### Technical Specification Reports (PDF)
1. **[`Edmonds-Karp and Min-Cut Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Edmonds-Karp%20and%20Min-Cut%20Technical%20Report.pdf):** Mathematical analysis and cut-set extraction.
2. **[`Ford-Fulkerson Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Ford-Fulkerson%20Algorithm%20Technical%20Report.pdf):** Network flow proofs and applications.
3. **[`Kosaraju's Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Kosaraju's%20Algorithm%20Technical%20Report.pdf):** Transposed graph mechanics and SCC proofs.
4. **[`Tarjan's Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Tarjan's%20Algorithm%20Technical%20Report.pdf):** Low-link invariants and single-pass traversal.

---

## 5. Compilation and Execution

You can run any program with the **Run** button in VS Code.  
You can also compile and run programs from the root directory using the terminal.

### Strongly Connected Component Algorithms
```bash
# Compile and run Kosaraju Algorithm
javac algorithms/scc/KosarajusAlgo.java && java algorithms.scc.KosarajusAlgo

# Compile and run Tarjan Algorithm
javac algorithms/scc/TarjanAlgo.java && java algorithms.scc.TarjanAlgo
```

### Network Flow Algorithms
```bash
# Compile and run Ford-Fulkerson Algorithm
javac algorithms/flow/FordFulkerson.java && java algorithms.flow.FordFulkerson

# Compile and run Edmonds-Karp Algorithm
javac algorithms/flow/EdmondsKarp.java && java algorithms.flow.EdmondsKarp
```
