# Day 08 - Kth Largest Element in an Array

## Problem Title

Kth Largest Element in an Array

## Problem Statement

Given an integer array `numbers` and an integer `k`, return the `k`th largest element in the array.

The answer is based on sorted order, so duplicate values are counted separately.

## Example Input

```text
numbers = [3, 2, 1, 5, 6, 4]
k = 2
```

## Example Output

```text
5
```

The sorted array in descending order is `[6, 5, 4, 3, 2, 1]`, so the 2nd largest element is `5`.

## Explanation

A min-heap keeps the largest `k` elements seen so far.

- Add every number to the min-heap.
- If the heap contains more than `k` elements, remove the smallest one.
- After processing the whole array, the smallest element inside the heap is the `k`th largest element overall.

## Approach

1. Create a `PriorityQueue`, which works as a min-heap by default in Java.
2. Insert each array value into the heap.
3. Keep the heap size equal to `k` by removing the smallest value whenever the size becomes greater than `k`.
4. Return the value at the top of the heap.

## Java Solution

See `KthLargestElement.java`.

## Time Complexity

`O(N log K)` because each of the `N` elements is inserted and may be removed from a heap of size at most `K`.

## Space Complexity

`O(K)` for the min-heap.

## Key Learning / Pattern

- Min-heap for maintaining the top `K` elements
- Priority Queue
- Useful pattern for kth largest/smallest and streaming data problems
- Avoids sorting the complete array

## Problem Reference

LeetCode 215 - Kth Largest Element in an Array

## Status

✅ Day 08 Completed
