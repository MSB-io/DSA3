# DSA 3: Advanced Data Structures and Algorithms

This repository contains implementations, technical reports, and explanatory guides for Advanced Data Structures and Algorithms.  
Topics include Strongly Connected Components (SCC), Maximum Network Flow with Minimum Cut, Dynamic Programming, and Advanced String Processing.

---

## 1. Directory Structure

```
DSA3/
├── algorithms/
│   ├── scc/                           # Strongly Connected Components
│   │   ├── KosarajusAlgo.java        # Kosaraju algorithm implementation
│   │   └── TarjanAlgo.java           # Tarjan algorithm implementation
│   ├── flow/                          # Network Flow and Cut Problems
│   │   ├── FordFulkerson.java        # Ford-Fulkerson algorithm implementation
│   │   └── EdmondsKarp.java          # Edmonds-Karp and Min-Cut implementation
│   ├── dp/                            # Dynamic Programming
│   │   ├── subset.java               # Subset mask DP
│   │   ├── bitmask.java              # Bitmask power set exploration
│   │   ├── TreeDp.java               # Dynamic Programming on Trees (Subtree size)
│   │   └── TransectionDp.java        # DP State Transitions / Transaction DP
│   └── strings/                       # Advanced String Processing
│       ├── KasaiAlgorithm.java       # Suffix Array & Kasai's LCP Construction
│       ├── MultiPatternMatching.java  # Generalized multi-pattern search with delimiters
│       ├── TrieDemo.java             # Prefix Tree (Trie) operations
│       ├── AhoCorasick.java          # Multi-pattern search with fail links
│       ├── LPSDemo.java              # Longest Prefix Suffix (KMP pre-computation)
│       └── Manacher.java             # O(N) Longest Palindromic Substring
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

## 2. Strongly Connected Components (`algorithms/scc/`)

A Strongly Connected Component (SCC) is a maximal sub-graph of a directed graph.  
In an SCC, every node can reach every other node in both directions.

| File | Algorithm | Method | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| [`KosarajusAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/KosarajusAlgo.java) | Kosaraju-Sharir | Two-pass DFS with transposed graph ($G^T$) | $\mathcal{O}(V + E)$ | $\mathcal{O}(V + E)$ |
| [`TarjanAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/TarjanAlgo.java) | Tarjan | Single-pass DFS with low-link values | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |

---

## 3. Maximum Network Flow and Minimum Cut (`algorithms/flow/`)

These algorithms calculate the maximum possible flow from a source node $s$ to a sink node $t$.  
The calculations follow the Max-Flow Min-Cut Theorem:

$$\text{Maximum Flow Value} = \text{Capacity of Minimum Cut}$$

| File | Method | Capability | Complexity |
| :--- | :--- | :--- | :--- |
| [`FordFulkerson.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/FordFulkerson.java) | Augmenting paths via DFS | Calculates total maximum flow | $\mathcal{O}(E \cdot \text{max flow})$ |
| [`EdmondsKarp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/EdmondsKarp.java) | Augmenting paths and cut extraction | Calculates maximum flow and identifies minimum cut edges | $\mathcal{O}(V \cdot E^2)$ |

---

## 4. Dynamic Programming (`algorithms/dp/`)

| File | Problem / Concept | Method | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| [`subset.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/subset.java) | Subset Permutations | Bitmask tabulation over $2^N$ sub-states | $\mathcal{O}(N \cdot 2^N)$ | $\mathcal{O}(2^N)$ |
| [`bitmask.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/bitmask.java) | Power Set Generation | Iterative bitmask state enumeration | $\mathcal{O}(N \cdot 2^N)$ | $\mathcal{O}(1)$ |
| [`TreeDp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/TreeDp.java) | Dynamic Programming on Trees | Post-order DFS subtree accumulation | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |
| [`TransectionDp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/TransectionDp.java) | DP State Transitions | 1D prefix state transition tracking | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

## 5. Advanced String Processing (`algorithms/strings/`)

| File | Algorithm | Method / Application | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| [`KasaiAlgorithm.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/KasaiAlgorithm.java) | Kasai's LCP Construction | Rank inversion with $LCP \ge h - 1$ guarantee | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |
| [`MultiPatternMatching.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/MultiPatternMatching.java) | Multi-Pattern Search | Delimited generalized string indexing | $\mathcal{O}(N + \sum M_i)$ | $\mathcal{O}(N + \sum M_i)$ |
| [`TrieDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/TrieDemo.java) | Standard Trie | 26-way prefix tree insert, search, and prefix query | $\mathcal{O}(L)$ per word | $\mathcal{O}(\Sigma \cdot \sum L)$ |
| [`AhoCorasick.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/AhoCorasick.java) | Aho-Corasick Automaton | Trie with BFS failure transitions for multi-pattern search | $\mathcal{O}(N + \sum M_i + K)$ | $\mathcal{O}(\Sigma \cdot \sum M_i)$ |
| [`LPSDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/LPSDemo.java) | KMP LPS Array | Two-pointer proper prefix-suffix pre-computation | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |
| [`Manacher.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/Manacher.java) | Manacher's Algorithm | `#`-interleaving with center/right boundary palindrome reuse | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

## 6. Technical Documentation (`docs/`)

### Simplified Technical English (STE) Guides
* **[`Kosarajus_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Kosarajus_Algorithm_Explained.md):** Complete guide for the two-pass Kosaraju algorithm.
* **[`Tarjans_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Tarjans_Algorithm_Explained.md):** Complete guide for the single-pass Tarjan algorithm.
* **[`Ford_Fulkerson_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Ford_Fulkerson_Algorithm_Explained.md):** Complete guide for network flow and residual graph updates.
* **[`Edmonds_Karp_and_Min_Cut_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Edmonds_Karp_and_Min_Cut_Explained.md):** Complete guide for the Max-Flow Min-Cut Theorem and cut-set extraction.

---

## 7. Compilation and Execution

You can compile and run any program from the repository root:

### Dynamic Programming
```bash
javac algorithms/dp/*.java
java algorithms.dp.TreeDp
java algorithms.dp.TransectionDp
```

### Advanced String Algorithms
```bash
javac algorithms/strings/*.java
java algorithms.strings.KasaiAlgorithm
java algorithms.strings.MultiPatternMatching
java algorithms.strings.TrieDemo
java algorithms.strings.AhoCorasick
java algorithms.strings.LPSDemo
java algorithms.strings.Manacher
```

### SCC and Network Flow
```bash
javac algorithms/scc/*.java && java algorithms.scc.KosarajusAlgo
javac algorithms/flow/*.java && java algorithms.flow.EdmondsKarp
```
