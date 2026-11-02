# DSA 3: Advanced Data Structures and Algorithms

This repository contains implementations, technical reports, and explanatory guides for all algorithms covered in DSA 3.  
Topics include Strongly Connected Components (SCC), Network Flow and Minimum Cut, Dynamic Programming, Advanced String Processing, and Tree & Range Query Data Structures.

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
│   ├── strings/                       # Advanced String Processing
│   │   ├── SuffixArray.java          # 10. SA Construction Basics & 11. SA Coding (Doubling)
│   │   ├── KasaiAlgorithm.java       # 12. Kasai's LCP Construction
│   │   ├── MultiPatternMatching.java # 13. Multi-Pattern Matching (Generalized Delimiters)
│   │   ├── TrieDemo.java             # 14a. Array-based Trie Demo
│   │   ├── Trie.java                 # 14b. HashMap-based Trie (Word Storage & Autocomplete)
│   │   ├── AhoCorasick.java          # 15. Fail-Link Algorithm (Aho-Corasick Automaton)
│   │   ├── LPSDemo.java              # 16a. Coding LPS (Longest Prefix Suffix)
│   │   ├── KMPSearch.java            # 16b. KMP Pattern Search
│   │   └── Manacher.java             # 17. Manacher's O(N) Palindromic Substring
│   └── trees/                         # Tree & Range Query Data Structures
│       └── SegmentTree.java          # 18. Segment Tree with Lazy Propagation
├── docs/                              # Standardized Assignment Guides & Reports
│   ├── Assignment_01_Kosarajus_Algorithm.md
│   ├── Assignment_02_Tarjans_Algorithm.md
│   ├── Assignment_03_Ford_Fulkerson_Algorithm.md
│   ├── Assignment_04_Edmonds_Karp_and_Min_Cut.md
│   ├── Assignment_05_Bitwise_Representation_Power_Set.md
│   ├── Assignment_06_Subset_DP.md
│   ├── Assignment_07_Tree_DP.md
│   ├── Assignment_08_Transaction_DP.md
│   ├── Assignment_09_Suffix_Array_Construction.md
│   ├── Assignment_10_Kasais_Algorithm_LCP.md
│   ├── Assignment_11_Multi_Pattern_Matching.md
│   ├── Assignment_12_Trie_Word_Storage_and_Search.md
│   ├── Assignment_13_Aho_Corasick_Algorithm.md
│   ├── Assignment_14_KMP_Pattern_Matching.md
│   ├── Assignment_15_Manachers_Algorithm.md
│   └── Assignment_16_Segment_Tree_Lazy_Propagation.md
├── project/                           # Internal Mini-Project (Project 15)
│   ├── TrieDictionary.java           # Self-contained Trie Dictionary & Autocomplete CLI
│   └── PROJECT_REPORT.md             # Formal Project Specification Report & Rubric Tests
├── .gitignore                         # Git exclusion rules
└── README.md                          # Repository documentation
```

---

## 2. Complete Inventory of Covered Algorithms

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
| **14** | **Trie (Word Storage & Search)** | [`Trie.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/Trie.java) | Dynamic HashMap-based Trie supporting arbitrary characters & prefixes | $\mathcal{O}(L)$ per word | $\mathcal{O}(\text{Nodes})$ |
| **15** | **Fail-Link Algorithm (Aho-Corasick)** | [`AhoCorasick.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/AhoCorasick.java) | Trie combined with BFS failure transitions for multi-pattern search | $\mathcal{O}(N + \sum M_i + K)$ | $\mathcal{O}(\Sigma \cdot \sum M_i)$ |
| **16** | **Coding LPS / KMP Search** | [`LPSDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/LPSDemo.java) / [`KMPSearch.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/KMPSearch.java) | Longest proper prefix which is also suffix / linear pattern search | $\mathcal{O}(N + M)$ | $\mathcal{O}(M)$ |
| **17** | **Manacher's Algorithm** | [`Manacher.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/Manacher.java) | `#`-padded palindrome radius tracking with center/boundary symmetry | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

### E. Tree & Range Query Data Structures (`algorithms/trees/`)

| # | Algorithm / Data Structure | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **18** | **Segment Tree (Lazy Propagation)** | [`SegmentTree.java`](file:///Users/manthan/Desktop/DSA3/algorithms/trees/SegmentTree.java) | Recursive binary tree with lazy push-down for range sum and updates | $\mathcal{O}(\log N)$ per query/update | $\mathcal{O}(4N)$ |

---

## 3. Standardized Assignment Reports (`docs/`)

All 16 technical specification reports follow the standard format (Definition, Mermaid diagrams, Procedure, Code Walkthrough, Execution Trace, and Complexity proofs):

| Assignment # | Topic & Algorithm | Documentation Guide |
| :---: | :--- | :--- |
| **01** | Kosaraju's Algorithm (SCC) | [`Assignment_01_Kosarajus_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_01_Kosarajus_Algorithm.md) |
| **02** | Tarjan's Algorithm (SCC) | [`Assignment_02_Tarjans_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_02_Tarjans_Algorithm.md) |
| **03** | Ford-Fulkerson Algorithm (Max Flow) | [`Assignment_03_Ford_Fulkerson_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_03_Ford_Fulkerson_Algorithm.md) |
| **04** | Edmonds-Karp & Min-Cut Algorithm | [`Assignment_04_Edmonds_Karp_and_Min_Cut.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_04_Edmonds_Karp_and_Min_Cut.md) |
| **05** | Bitwise Representation (Power Set) | [`Assignment_05_Bitwise_Representation_Power_Set.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_05_Bitwise_Representation_Power_Set.md) |
| **06** | Subset Dynamic Programming | [`Assignment_06_Subset_DP.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_06_Subset_DP.md) |
| **07** | Tree Dynamic Programming | [`Assignment_07_Tree_DP.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_07_Tree_DP.md) |
| **08** | Transaction Dynamic Programming | [`Assignment_08_Transaction_DP.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_08_Transaction_DP.md) |
| **09** | Suffix Array Construction | [`Assignment_09_Suffix_Array_Construction.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_09_Suffix_Array_Construction.md) |
| **10** | Kasai's Algorithm (LCP Construction) | [`Assignment_10_Kasais_Algorithm_LCP.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_10_Kasais_Algorithm_LCP.md) |
| **11** | Multi-Pattern Matching with Delimiters | [`Assignment_11_Multi_Pattern_Matching.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_11_Multi_Pattern_Matching.md) |
| **12** | Trie: Word Storage and Autocomplete | [`Assignment_12_Trie_Word_Storage_and_Search.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_12_Trie_Word_Storage_and_Search.md) |
| **13** | Aho-Corasick Algorithm (Fail-Link) | [`Assignment_13_Aho_Corasick_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_13_Aho_Corasick_Algorithm.md) |
| **14** | KMP Pattern Matching & LPS Array | [`Assignment_14_KMP_Pattern_Matching.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_14_KMP_Pattern_Matching.md) |
| **15** | Manacher's Algorithm ($\mathcal{O}(N)$ Palindrome) | [`Assignment_15_Manachers_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_15_Manachers_Algorithm.md) |
| **16** | Segment Tree with Lazy Propagation | [`Assignment_16_Segment_Tree_Lazy_Propagation.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_16_Segment_Tree_Lazy_Propagation.md) |

---

## 4. Internal Mini-Project (`project/`)

**Selected Topic:** Project 15 — *Trie-Based Dictionary and Autocomplete*

| Deliverable | File | Description |
| :--- | :--- | :--- |
| **Source Code** | [`TrieDictionary.java`](file:///Users/manthan/Desktop/DSA3/project/TrieDictionary.java) | Single self-contained runnable application featuring dynamic `TreeMap` child mapping, insertion, exact definition retrieval, prefix autocomplete, safe memory-pruned deletion, and automated test suite. |
| **Technical Report** | [`PROJECT_REPORT.md`](file:///Users/manthan/Desktop/DSA3/project/PROJECT_REPORT.md) | Complete specification document containing problem statement, objectives, Mermaid architecture diagrams, $\mathcal{O}(L)$ complexity proofs, and rubric test validation. |

---

## 5. Compilation and Execution

Compile and execute any component from the repository root:

### Internal Mini-Project (Project 15)
```bash
# Compile and run the Trie Dictionary & Autocomplete CLI
javac project/TrieDictionary.java && java project.TrieDictionary
```

### Course Algorithms

```bash
# Tree & Range Query Data Structures
javac algorithms/trees/*.java && java algorithms.trees.SegmentTree

# String Processing & Word Storage Trie
javac algorithms/strings/*.java && java algorithms.strings.Trie

# Strongly Connected Components
javac algorithms/scc/*.java && java algorithms.scc.KosarajusAlgo

# Network Flow and Min-Cut
javac algorithms/flow/*.java && java algorithms.flow.MinCut

# Dynamic Programming
javac algorithms/dp/*.java && java algorithms.dp.TreeDp
```
