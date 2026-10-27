# DSA 3: Advanced Data Structures & Algorithms

A repository containing implementations, lecture code, and technical reports on Java Collections, Strongly Connected Components (SCC), and Network Maximum Flow & Minimum Cut algorithms.

---

## Repository Structure

```
DSA3/
├── lectures/                           # Foundational Java Collections & Exercises
│   ├── Lecture1.java                  # ArrayList, operations, Product Cart simulation
│   └── Lecture2.java                  # LinkedList (Queue), HashSet, HashMap
├── algorithms/
│   ├── scc/                           # Strongly Connected Components (SCC)
│   │   ├── KosarajusAlgo.java        # Kosaraju-Sharir two-pass DFS algorithm
│   │   └── TarjanAlgo.java           # Tarjan's single-pass low-link DFS algorithm
│   └── flow/                          # Network Flow & Cut Problems
│       ├── FordFulkerson.java        # Ford-Fulkerson Max Flow (Augmenting paths)
│       └── EdmondsKarp.java          # Max Flow + Min-Cut Edge Identification
├── docs/                              # Technical Specification & Analysis Reports
│   ├── Edmonds-Karp and Min-Cut Technical Report.pdf
│   ├── Ford-Fulkerson Algorithm Technical Report.pdf
│   ├── Kosaraju's Algorithm Technical Report.pdf
│   └── Tarjan's Algorithm Technical Report.pdf
├── .gitignore                         # Build and OS artifact exclusions
└── README.md                          # Repository documentation
```

---

## Contents & Code Breakdown

### 1. Foundational Java Collections (`lectures/`)

| File | Key Concepts & Methods | Description |
| :--- | :--- | :--- |
| [`Lecture1.java`](file:///Users/manthan/Desktop/DSA3/lectures/Lecture1.java) | `ArrayList`, custom object `Product`, `removeIf`, duplicate elimination, linear search | Demonstrates dynamic array manipulation and models an e-commerce shopping cart with product additions, removal by predicate, and bill calculation. |
| [`Lecture2.java`](file:///Users/manthan/Desktop/DSA3/lectures/Lecture2.java) | `LinkedList`, `HashSet`, `HashMap`, `Map.Entry` | Demonstrates double-ended queue operations (`addFirst`, `removeFirst`), set intersection (`retainAll`), word/number frequency tracking, and finding key-value extremes (topper identification). |

---

### 2. Strongly Connected Components (`algorithms/scc/`)

A Strongly Connected Component (SCC) in a directed graph is a maximal subgraph where every vertex is reachable from every other vertex within the component.

| File | Algorithm | Strategy | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| [`KosarajusAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/KosarajusAlgo.java) | **Kosaraju-Sharir** | Two-pass DFS + Graph Transposition ($G^T$) | $\mathcal{O}(V + E)$ | $\mathcal{O}(V + E)$ |
| [`TarjanAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/TarjanAlgo.java) | **Tarjan's Algorithm** | Single-pass DFS + Discovery (`disc`) & Low-link (`low`) tracking | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |

#### Algorithmic Comparison:
- **Kosaraju's Algorithm**:
  1. **Pass 1**: Run DFS on the original directed graph, pushing vertices onto a stack in order of their completion/exit times.
  2. **Transpose**: Construct reversed graph $G^T$ by flipping every edge $(u \to v)$ to $(v \to u)$.
  3. **Pass 2**: Pop vertices from the stack and run DFS on $G^T$. Each DFS tree discovered corresponds to one Strongly Connected Component.
- **Tarjan's Algorithm**:
  1. Uses a single DFS traversal while assigning discovery timestamps (`disc[u]`) and tracking the lowest reachable discovery time (`low[u]`).
  2. Uses an explicit recursion stack (`stack`) and boolean lookup (`onStack[]`).
  3. When `low[u] == disc[u]`, node $u$ is the root of an SCC. Vertices are popped from the stack until $u$ is reached.

---

### 3. Maximum Network Flow & Minimum Cut (`algorithms/flow/`)

Algorithms for finding the maximum possible flow from a source vertex $s$ to a sink vertex $t$ in a flow network with capacity constraints, based on the **Max-Flow Min-Cut Theorem**:

$$\text{Maximum Flow Value} = \text{Capacity of Minimum Cut}$$

| File | Implementation | Key Capabilities | Complexity |
| :--- | :--- | :--- | :--- |
| [`FordFulkerson.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/FordFulkerson.java) | Augmenting path discovery via residual graph DFS | Computes the numerical value of maximum network flow | $\mathcal{O}(E \cdot \text{max\_flow})$ |
| [`EdmondsKarp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/EdmondsKarp.java) | Augmenting path search + Min-Cut Partitioning | Computes max flow **and identifies the exact bottleneck edges** crossing the $(S, T)$ minimum cut cut-set | $\mathcal{O}(E \cdot \text{max\_flow})$ |

#### Minimum Cut Set Identification:
1. After reaching maximum flow (no augmenting paths remain in the residual network), run a reachability traversal from source $s$.
2. The set of reachable vertices forms partition $S$, while unreachable vertices form partition $T$.
3. Any original forward edge $u \to v$ where $u \in S$, $v \in T$, and original $\text{capacity}[u][v] > 0$ belongs to the **Minimum Cut set**.

---

### 4. Technical Reports (`docs/`)

The [`docs/`](file:///Users/manthan/Desktop/DSA3/docs/) folder includes comprehensive formal technical reports:
1. **[`Edmonds-Karp and Min-Cut Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Edmonds-Karp%20and%20Min-Cut%20Technical%20Report.pdf)**: Mathematical formulation, residual capacity tracking, and cut-set extraction.
2. **[`Ford-Fulkerson Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Ford-Fulkerson%20Algorithm%20Technical%20Report.pdf)**: Augmenting paths, residual graph updates, and network flow applications.
3. **[`Kosaraju's Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Kosaraju's%20Algorithm%20Technical%20Report.pdf)**: Transpose graph mechanics, finishing order proofs, and SCC properties.
4. **[`Tarjan's Algorithm Technical Report.pdf`](file:///Users/manthan/Desktop/DSA3/docs/Tarjan's%20Algorithm%20Technical%20Report.pdf)**: Low-link values, single-pass DFS optimization, and stack invariants.

---

## How to Compile & Run

All `.java` files are self-contained without package declarations, allowing you to compile and run each program directly from any terminal:

### Running Lecture Exercises
```bash
# Lecture 1: ArrayList & Cart Simulation
javac lectures/Lecture1.java && java -cp lectures Lecture1

# Lecture 2: LinkedList, HashSet, HashMap
javac lectures/Lecture2.java && java -cp lectures Lecture2
```

### Running Graph Algorithms (SCC)
```bash
# Kosaraju's Algorithm
javac algorithms/scc/KosarajusAlgo.java && java -cp algorithms/scc KosarajusAlgo

# Tarjan's Algorithm
javac algorithms/scc/TarjanAlgo.java && java -cp algorithms/scc TarjanAlgo
```

### Running Flow Algorithms
```bash
# Ford-Fulkerson Maximum Flow
javac algorithms/flow/FordFulkerson.java && java -cp algorithms/flow FordFulkerson

# Edmonds-Karp Max Flow & Min Cut Set
javac algorithms/flow/EdmondsKarp.java && java -cp algorithms/flow EdmondsKarp
```
