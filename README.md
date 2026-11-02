# DSA 3: Advanced Data Structures and Algorithms

This repository contains implementations, technical reports, and explanatory guides for all algorithms covered in DSA 3.  
Topics include Strongly Connected Components (SCC), Network Flow and Minimum Cut, Dynamic Programming, Advanced String Processing, Tree & Range Query Data Structures, and Java Bytecode Architecture.

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
│   │   ├── SuffixArray.java          # Suffix Array Construction (Doubling)
│   │   ├── KasaiAlgorithm.java       # 10. Kasai's LCP Construction
│   │   ├── MultiPatternMatching.java # 11. Multi-Pattern Matching (Generalized Delimiters)
│   │   ├── TrieDemo.java             # Array-based Trie Demo
│   │   ├── Trie.java                 # HashMap-based Trie (Word Storage & Autocomplete)
│   │   ├── AhoCorasick.java          # 12. Fail-Link Algorithm (Aho-Corasick Automaton)
│   │   ├── LPSDemo.java              # 13. Coding LPS (Longest Prefix Suffix)
│   │   ├── KMPSearch.java            # KMP Pattern Search
│   │   └── Manacher.java             # 14. Manacher's O(N) Palindromic Substring
│   ├── trees/                         # Tree & Range Query Data Structures
│   │   └── SegmentTree.java          # 15. Segment Tree with Lazy Propagation
│   └── bytecode/                      # JVM Foundations & Architecture
│       └── BytecodeDemo.java         # 16. Java Bytecode Execution & Stack Operations
├── docs/                              # Standardized Assignment Guides (Exact 15)
│   ├── Assignment_01_Kosarajus_Algorithm.md
│   ├── Assignment_02_Tarjans_Algorithm.md
│   ├── Assignment_03_Ford_Fulkerson_Algorithm.md
│   ├── Assignment_04_Edmonds_Karp_and_Min_Cut.md
│   ├── Assignment_05_Bitwise_Representation_Power_Set.md
│   ├── Assignment_06_Subset_DP.md
│   ├── Assignment_07_Tree_DP.md
│   ├── Assignment_08_Transaction_DP.md
│   ├── Assignment_09_Kasais_Algorithm_LCP.md
│   ├── Assignment_10_Multi_Pattern_Matching.md
│   ├── Assignment_11_Aho_Corasick_Algorithm.md
│   ├── Assignment_12_Coding_LPS.md
│   ├── Assignment_13_Manachers_Algorithm.md
│   ├── Assignment_14_Segment_Tree_Lazy_Propagation.md
│   └── Assignment_15_Java_Bytecode.md
├── project/                           # Internal Mini-Project (Project 15)
│   ├── TrieDictionary.java           # Self-contained Trie Dictionary & Autocomplete CLI
│   └── PROJECT_REPORT.md             # Formal Project Specification Report & Rubric Tests
├── .gitignore                         # Git exclusion rules
└── README.md                          # Repository documentation
```

---

## 2. Complete Inventory of Covered Topics & Algorithms

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
| **10** | **Kasai's Algorithm** | [`KasaiAlgorithm.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/KasaiAlgorithm.java) | Linear-time LCP construction using rank inversion ($LCP \ge h - 1$) | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |
| **11** | **Multi-Pattern Matching** | [`MultiPatternMatching.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/MultiPatternMatching.java) | Generalized delimited string indexing (`text#pat1$0pat2$1...`) | $\mathcal{O}(N + \sum M_i)$ | $\mathcal{O}(N + \sum M_i)$ |
| **12** | **Fail-Link Algorithm (Aho-Corasick)** | [`AhoCorasick.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/AhoCorasick.java) | Trie combined with BFS failure transitions for multi-pattern search | $\mathcal{O}(N + \sum M_i + K)$ | $\mathcal{O}(\Sigma \cdot \sum M_i)$ |
| **13** | **Coding LPS** | [`LPSDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/LPSDemo.java) | Longest proper prefix which is also suffix pre-computation | $\mathcal{O}(M)$ | $\mathcal{O}(M)$ |
| **14** | **Manacher's Algorithm** | [`Manacher.java`](file:///Users/manthan/Desktop/DSA3/algorithms/strings/Manacher.java) | `#`-padded palindrome radius tracking with center/boundary symmetry | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

### E. Tree & Range Query Data Structures (`algorithms/trees/`)

| # | Algorithm / Data Structure | File | Core Concept / Technique | Time | Space |
| :-: | :--- | :--- | :--- | :--- | :--- |
| **15** | **Segment Tree (Lazy Propagation)** | [`SegmentTree.java`](file:///Users/manthan/Desktop/DSA3/algorithms/trees/SegmentTree.java) | Recursive binary tree with lazy push-down for range sum and updates | $\mathcal{O}(\log N)$ per query/update | $\mathcal{O}(4N)$ |

---

### F. JVM Architecture & Execution (`algorithms/bytecode/`)

| # | Topic / Execution Model | File | Core Concept / Technique | Execution Model |
| :-: | :--- | :--- | :--- | :--- |
| **16** | **Java Bytecode** | [`BytecodeDemo.java`](file:///Users/manthan/Desktop/DSA3/algorithms/bytecode/BytecodeDemo.java) | Stack-based intermediate JVM opcodes, operand stack, and local variable frames | JVM Interpretation & JIT Compilation |

---

## 3. Standardized Assignment Reports (`docs/`)

The 15 official course assignment reports follow the standardized technical report specification:

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
| **09** | Kasai's Algorithm (LCP Construction) | [`Assignment_09_Kasais_Algorithm_LCP.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_09_Kasais_Algorithm_LCP.md) |
| **10** | Multi-Pattern Matching with Delimiters | [`Assignment_10_Multi_Pattern_Matching.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_10_Multi_Pattern_Matching.md) |
| **11** | Aho-Corasick Algorithm (Fail-Link) | [`Assignment_11_Aho_Corasick_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_11_Aho_Corasick_Algorithm.md) |
| **12** | Coding LPS (Longest Prefix Suffix) | [`Assignment_12_Coding_LPS.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_12_Coding_LPS.md) |
| **13** | Manacher's Algorithm ($\mathcal{O}(N)$ Palindrome) | [`Assignment_13_Manachers_Algorithm.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_13_Manachers_Algorithm.md) |
| **14** | Segment Tree with Lazy Propagation | [`Assignment_14_Segment_Tree_Lazy_Propagation.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_14_Segment_Tree_Lazy_Propagation.md) |
| **15** | Java Bytecode & JVM Execution Model | [`Assignment_15_Java_Bytecode.md`](file:///Users/manthan/Desktop/DSA3/docs/Assignment_15_Java_Bytecode.md) |

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

### Course Algorithms & Bytecode Inspection
```bash
# Java Bytecode Execution & Disassembly
javac algorithms/bytecode/*.java && java algorithms.bytecode.BytecodeDemo
javap -c algorithms.bytecode.BytecodeDemo

# Tree & Range Query Data Structures
javac algorithms/trees/*.java && java algorithms.trees.SegmentTree

# Strongly Connected Components
javac algorithms/scc/*.java && java algorithms.scc.KosarajusAlgo

# Network Flow and Min-Cut
javac algorithms/flow/*.java && java algorithms.flow.MinCut

# Dynamic Programming
javac algorithms/dp/*.java && java algorithms.dp.TreeDp
```
