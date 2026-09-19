# Day 17 - Subsets II

## Problem Title
**Subsets II (LeetCode 90)**

## Problem Statement
Given an integer array `numbers` that may contain duplicates, return all possible subsets (the power set). The solution must not contain duplicate subsets.

## Example Input
```text
numbers = [1, 2, 2]
```

## Example Output
```text
[[], [1], [1,2], [1,2,2], [2], [2,2]]
```

## Explanation
The array contains two `2`s, so subsets such as `[2]` can be formed in more than one way. We sort the array and skip equal values at the same recursion level to avoid adding duplicate subsets, while still allowing duplicates at deeper levels such as `[2,2]`.

## Approach
1. Sort the input array so duplicate values become adjacent.
2. Add the current subset to the answer at every recursion step.
3. Try each available element from `startIndex` onward.
4. If the current value is the same as the previous value at the same recursion level, skip it.
5. Choose the value, recurse, then backtrack by removing it.

## Java Solution Reference
See [`SubsetsWithDuplicates.java`](./SubsetsWithDuplicates.java).

## Time Complexity
`O(N * 2^N)` in the worst case, because there can be up to `2^N` subsets and copying each subset can take `O(N)` time.

## Space Complexity
`O(N)` auxiliary recursion and current-subset space, excluding the output list. The output itself can require `O(N * 2^N)` space.

## Key Learning / Pattern
**Backtracking + Sorting + Duplicate Skipping**

When generating combinations with duplicate values, sorting first and skipping equal values at the same recursion depth prevents duplicate answers without blocking valid selections at deeper levels.