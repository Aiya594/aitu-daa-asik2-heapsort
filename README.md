# Assignment 2 – Algorithmic Analysis and Peer Code Review

##  Overview

This project is part of **Assignment 2: Algorithmic Analysis and Peer Code Review**.
The goal is to implement advanced sorting algorithms, collect performance metrics, validate theoretical complexity with experiments, and conduct peer review of a partner’s algorithm.

---

##  Repository Structure

```
assignment2-heapsort/
├── src/
│   ├── main/java/org/example/
│   │   ├── algorithms/HeapSort.java        # Heap Sort implementation
│   │   ├── cli/BenchmarkRunner.java        # CLI benchmarking tool
│   │   ├── csvWriter/CSVWriter.java        # CSV writer for metrics
│   │   └── metrics/Metrics.java            # Performance metrics tracker
│   └── test/java/algorithms/HeapSortTests.java # JUnit tests
├── docs/
│   ├── peer_analysis_shell_sort.pdf                 # analysis of Shell Sort
│   └── heapSort-plots/                  # benchmark plots got heapSort
├── pom.xml
└── README.md
```

---

## Build & Run

### 1. Build

Compile with Maven:

```
mvn clean install
```

### 2. Run Benchmarks

Heap Sort benchmark with default parameters (n=10000, trials=5):

```
java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main
```

Custom array size and trials:

```
java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main 20000 10
```

### 3. Options

```
Usage:
    java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main [size] [trials]

Algorithms:
  --algorithm <name>    Only "heap" supported in this repo

Other options:
  --size <n>            Size of the array (default: 10000)
  --trials <t>          Number of trials (default: 5)
  --help                Show this help message

Examples:
  java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main 5000 3
```

### 4. Output

During benchmark runs, results are printed to console and also saved to **results.csv**:

```
algorithm=heap trial=0 n=10000 time=5ms comps=349481 swaps=124177 accesses=853136
```

CSV format:

```
ALGORITHM,N,TIME_MS,COMPARISONS,SWAPS,ARRAY_ACCESSES,MEMORY_ALLOCATIONS,RECURSION_DEPTH 
heap,200,1,3629,1364,9219,0,8
```

---

##  Testing

Run all JUnit tests:

```
mvn test
```

**Test coverage includes:**

* Empty array
* Single element
* Sorted and reverse-sorted arrays
* Arrays with duplicates / identical values
* Random arrays (property-based tests)
* Scalability tests (n = 100, 1000, 10000, 100000)

---

##  Empirical Validation

Benchmarks confirm that **Heap Sort** runs in:

* Worst Case: **O(n log n)**
* Average Case: **Ө(n log n)**
* Best Case: **Theta(n log n)**

---
