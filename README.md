# DSA 3: Advanced Data Structures and Algorithms

This repository contains implementations, technical reports, and explanatory guides for all 17 algorithms covered in DSA 3.  
Topics include Strongly Connected Components (SCC), Network Flow and Minimum Cut, Dynamic Programming, and Advanced String Processing.

---

## 1. Directory Structure

```
DSA3/
├── algorithms/
│   ├── scc/                           # Strongly Connected Components (SCC)
│   │   ├── KosarajusAlgo.java        # 1. Kosaraju's Algorithm
│   │   └── TarjanAlgo.java           # 2. Tarjan's Algorithm
│   ├── flow/                          # Network Flow and Cut Problems
│   │   ├── FordFulkerson.java        # 3. Ford-Fulkerson Algorithm
│   │   ├── EdmondsKarp.java          # 4. Edmonds-Karp Max-Flow Algorithm
│   │   └── MinCut.java               # 5. Minimum Cut Set Identification
│   ├── dp/                            # Dynamic Programming & Bitmasking
│   │   ├── bitmask.java              # 6. Bitwise Representation / Power Set
│   │   ├── subset.java               # 7. Subset DP
│   │   ├── TreeDp.java               # 8. Tree DP (Subtree Size Calculation)
│   │   └── TransactionDp.java        # 9. DP State Transitions (Transaction DP)
│   └── strings/                       # Advanced String Processing
│       ├── SuffixArray.java          # 10. SA Construction Basics & 11. SA Coding (Doubling)
│       ├── KasaiAlgorithm.java       # 12. Kasai's LCP Construction
│       ├── MultiPatternMatching.java # 13. Multi-Pattern Matching (Generalized Delimiters)
│       ├── TrieDemo.java             # 14. Trie Algorithm (Insert, Search, Prefix)
│       ├── AhoCorasick.java          # 15. Fail-Link Algorithm (Aho-Corasick Automaton)
│       ├── LPSDemo.java              # 16a. Coding LPS (Longest Prefix Suffix)
│       ├── KMPSearch.java            # 16b. KMP Pattern Search
│       └── Manacher.java             # 17. Manacher's O(N) Palindromic Substring
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

## 2. Complete Inventory of Covered Algorithms (17 Total)

### A. Strongly Connected Components (`algorithms/scc/`)

| # | Algorithm | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **1** | **Kosaraju's Algorithm** | [`KosarajusAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/KosarajusAlgo.java) | Two-pass DFS on original graph $G$ and transposed graph $G^T$ | $\mathcal{O}(V + E)$ | $\mathcal{O}(V + E)$ |
| **2** | **Tarjan's Algorithm** | [`TarjanAlgo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/scc/TarjanAlgo.java) | Single-pass DFS tracking discovery time and low-link invariants | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |

---

### B. Network Flow & Cut Problems (`algorithms/flow/`)

| # | Algorithm | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **3** | **Ford-Fulkerson** | [`FordFulkerson.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/FordFulkerson.java) | Augmenting paths identified via DFS traversal | $\mathcal{O}(E \cdot \text{max flow})$ | $\mathcal{O}(V^2)$ |
| **4** | **Edmonds-Karp** | [`EdmondsKarp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/EdmondsKarp.java) | Shortest augmenting paths found via BFS | $\mathcal{O}(V \cdot E^2)$ | $\mathcal{O}(V^2)$ |
| **5** | **Min-Cut Algorithm** | [`MinCut.java`](file:///Users/manthan/Desktop/DSA3/algorithms/flow/MinCut.java) | Residual reachability partition ($S, T$) yielding minimum cut capacity | $\mathcal{O}(V \cdot E^2)$ | $\mathcal{O}(V^2)$ |

---

### C. Dynamic Programming & Bitmasking (`algorithms/dp/`)

| # | Algorithm | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **6** | **Bitwise Representation** | [`bitmask.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/bitmask.java) | Power set enumeration via bit manipulation $(1 \ll n)$ | $\mathcal{O}(N \cdot 2^N)$ | $\mathcal{O}(1)$ |
| **7** | **Subset DP** | [`subset.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/subset.java) | Dynamic programming state transitions over bitmasks | $\mathcal{O}(N \cdot 2^N)$ | $\mathcal{O}(2^N)$ |
| **8** | **Tree DP** | [`TreeDp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/TreeDp.java) | Post-order DFS subtree DP accumulation | $\mathcal{O}(V + E)$ | $\mathcal{O}(V)$ |
| **9** | **Transaction DP** | [`TransactionDp.java`](file:///Users/manthan/Desktop/DSA3/algorithms/dp/TransactionDp.java) | 1D DP prefix state transition tracking on `"11231"` | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

### D. Advanced String Processing (`algorithms/strings/`)

| # | Algorithm | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **10** | **SA Construction Basics** | [`SuffixArray.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/SuffixArray.java) | Direct string sorting of all suffix substrings | $\mathcal{O}(N^2 \log N)$ | $\mathcal{O}(N)$ |
| **11** | **SA Coding (Prefix Doubling)** | [`SuffixArray.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/SuffixArray.java) | Rank-pair doubling over prefixes of length $2^k$ | $\mathcal{O}(N \log^2 N)$ | $\mathcal{O}(N)$ |
| **12** | **Kasai's Algorithm** | [`KasaiAlgorithm.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/KasaiAlgorithm.java) | Linear-time LCP construction using rank inversion ($LCP \ge h - 1$) | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |
| **13** | **Multi-Pattern Matching** | [`MultiPatternMatching.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/MultiPatternMatching.java) | Generalized delimited string indexing (`text#pat1$0pat2$1...`) | $\mathcal{O}(N + \sum M_i)$ | $\mathcal{O}(N + \sum M_i)$ |
| **14** | **Trie Algorithm** | [`TrieDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/TrieDemo.java) | 26-way prefix tree with `insert`, `search`, and `startsWith` | $\mathcal{O}(L)$ per word | $\mathcal{O}(\Sigma \cdot \sum L)$ |
| **15** | **Fail-Link Algorithm (Aho-Corasick)** | [`AhoCorasick.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/AhoCorasick.java) | Trie combined with BFS failure transitions for multi-pattern search | $\mathcal{O}(N + \sum M_i + K)$ | $\mathcal{O}(\Sigma \cdot \sum M_i)$ |
| **16** | **Coding LPS / KMP Search** | [`LPSDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/LPSDemo.java) / [`KMPSearch.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/KMPSearch.java) | Longest proper prefix which is also suffix / linear pattern search | $\mathcal{O}(N + M)$ | $\mathcal{O}(M)$ |
| **17** | **Manacher's Algorithm** | [`Manacher.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/Manacher.java) | `#`-padded palindrome radius tracking with center/boundary symmetry | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

## 3. Technical Documentation (`docs/`)

* **[`Kosarajus_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Kosarajus_Algorithm_Explained.md):** Complete guide for the two-pass Kosaraju algorithm.
* **[`Tarjans_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Tarjans_Algorithm_Explained.md):** Complete guide for the single-pass Tarjan algorithm.
* **[`Ford_Fulkerson_Algorithm_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Ford_Fulkerson_Algorithm_Explained.md):** Complete guide for network flow and residual graph updates.
* **[`Edmonds_Karp_and_Min_Cut_Explained.md`](file:///Users/manthan/Desktop/DSA3/docs/Edmonds_Karp_and_Min_Cut_Explained.md):** Complete guide for the Max-Flow Min-Cut Theorem and cut-set extraction.

---

## 4. Compilation and Execution

Compile and execute any algorithm from the repository root:

```bash
# Strongly Connected Components
javac algorithms/scc/*.java && java algorithms.scc.KosarajusAlgo

# Network Flow and Min-Cut
javac algorithms/flow/*.java && java algorithms.flow.MinCut

# Dynamic Programming
javac algorithms/dp/*.java && java algorithms.dp.TreeDp

# String Processing
javac algorithms/strings/*.java && java algorithms.strings.Manacher
```
