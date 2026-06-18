# Algorithms & Data Structures — Assignment 2 (AITU)

![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white)

## Overview

Custom implementations of core linear data structures and abstract data types in Java, built from scratch without relying on `java.util` collection classes. Includes a JUnit 5 test suite for each structure.

## What it implements

- **`MyList<T>` interface** — common contract (add, get, set, remove, sort, indexOf, iterator) implemented by both list types.
- **`MyArrayList<T>`** — generic dynamic array backed by a raw `Object[]`. Supports O(1) amortized `add`, O(n) insert/remove, and doubles capacity on overflow. Implements `Iterable<T>` with an inner iterator. Contains three sort strategies selectable by name:
  - **Bubble sort** — O(n²), early-exit on no swap.
  - **Quick sort** — O(n log n) average, in-place Lomuto partition.
  - **Merge sort** — O(n log n) worst-case, stable.
- **`MyLinkedList<T>`** — generic doubly-linked list with head/tail pointers. O(1) `addFirst`/`addLast`/`removeFirst`/`removeLast`. Sorts in-place with bubble sort.
- **`MyStack<T>`** — LIFO stack backed by `MyLinkedList`. `push`/`pop`/`peek` with `EmptyStackException`.
- **`MyQueue<T>`** — FIFO queue backed by `MyLinkedList`. `enqueue`/`dequeue`/`peek`.
- **`MyMinHeap<T>`** — min-heap backed by `MyArrayList`; insert + bubble-sort to maintain order; `findMin` and `deleteMin` in O(1) and O(n) respectively.
- **JUnit 5 tests** — separate test classes for all five structures covering edge cases (empty, single element, boundary indices).

## Project structure

```
src/
├── main/java/
│   ├── Main.java
│   ├── lists/
│   │   ├── MyList.java        # Shared interface
│   │   ├── MyArrayList.java   # Dynamic array + 3 sort algorithms
│   │   └── MyLinkedList.java  # Doubly-linked list
│   └── types/
│       ├── MyStack.java       # LIFO stack
│       ├── MyQueue.java       # FIFO queue
│       └── MyMinHeap.java     # Min-heap
└── test/java/
    ├── lists/
    │   ├── TestArrayList.java
    │   └── TestLinkedList.java
    └── types/
        ├── MyStackTest.java
        ├── MyQueueTest.java
        └── MyMinHeapTest.java
```

## How to run

**Run tests (Gradle):**

```bash
./gradlew test
```

**Compile and run manually:**

```bash
javac -d out src/main/java/lists/*.java src/main/java/types/*.java src/main/java/Main.java
java -cp out Main
```

---

Adil Ormanov — [GitHub](https://github.com/Adilforest)
