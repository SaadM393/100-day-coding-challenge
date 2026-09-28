# Day 26 - Kth Largest Element in an Array

## Problem Title

**Kth Largest Element in an Array (LeetCode 215)**

## Problem Statement

Given an integer array `numbers` and an integer `k`, return the `k`th largest element in the array. Duplicate values count as separate elements.

## Example Input

```text
numbers = [3, 2, 1, 5, 6, 4]
k = 2
```

## Example Output

```text
5
```

## Explanation

In descending order, the array is `[6, 5, 4, 3, 2, 1]`. The second largest value is `5`.

## Approach

1. Maintain a min-heap with at most `k` values.
2. Add each number to the heap.
3. If the heap size becomes larger than `k`, remove the smallest value.
4. After all values are processed, the heap stores the `k` largest values seen so far.
5. The smallest value in that heap is the `k`th largest element.

## Java Solution Reference

See [KthLargestElement.java](./KthLargestElement.java).

## Time Complexity

`O(N log K)`.

## Space Complexity

`O(K)`.

## Key Learning / Pattern

**Top-K elements using a bounded min-heap.**

A min-heap of size `k` keeps only the most important `k` candidates while scanning the array once.
