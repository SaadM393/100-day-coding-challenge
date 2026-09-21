# Day 19 - Longest Consecutive Sequence

## Problem Title
Longest Consecutive Sequence (LeetCode 128)

## Problem Statement
Given an unsorted integer array `nums`, return the length of the longest sequence of consecutive integers. The sequence elements do not need to be next to each other in the original array.

## Example Input
```text
nums = [100, 4, 200, 1, 3, 2]
```

## Example Output
```text
4
```

## Explanation
The longest consecutive sequence is `[1, 2, 3, 4]`, so the answer is `4`.

## Approach
1. Put every number into a `HashSet` for average `O(1)` lookup.
2. Treat a number as the beginning of a sequence only when `number - 1` is not present.
3. Starting from that number, keep checking `number + 1`, `number + 2`, and so on.
4. Track the maximum sequence length found.

This avoids sorting. Each sequence is expanded only from its smallest value, so the same sequence is not repeatedly scanned from every element.

## Java Solution Reference
See [`LongestConsecutiveSequence.java`](./LongestConsecutiveSequence.java).

## Time Complexity
`O(N)` average time.

Every value is inserted once, and each consecutive sequence is scanned from its starting value. HashSet operations are average `O(1)`.

## Space Complexity
`O(N)` for the HashSet.

## Key Learning / Pattern
**HashSet + Sequence Start Detection**

When an array is unsorted and you need consecutive values, use a set for fast membership checks. The important optimization is to begin a scan only when the current value has no predecessor.
