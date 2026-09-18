# Day 16 - Merge Intervals

## Problem Title
**Merge Intervals (LeetCode 56)**

## Problem Statement
Given an array of intervals where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

## Example Input
```text
intervals = [[1,3],[2,6],[8,10],[9,12]]
```

## Example Output
```text
[[1,6],[8,12]]
```

## Explanation
The intervals `[1,3]` and `[2,6]` overlap, so they become `[1,6]`. The intervals `[8,10]` and `[9,12]` overlap, so they become `[8,12]`.

## Approach
1. Sort the intervals by their starting point.
2. Keep track of the current merged interval.
3. For each next interval:
   - If its start is less than or equal to the current end, merge it by extending the end.
   - Otherwise, store the current interval and start a new one.
4. Add the final current interval to the result.

## Java Solution Reference
See [`MergeIntervals.java`](./MergeIntervals.java).

## Time Complexity
`O(N log N)` because of sorting, followed by an `O(N)` scan.

## Space Complexity
`O(N)` for the result list. The algorithm uses `O(1)` extra working space apart from the output and sorting implementation.

## Key Learning / Pattern
**Sorting + Greedy Interval Merging**

When working with intervals, sorting by start time often turns a complicated overlap problem into a simple left-to-right scan. The greedy choice is to keep extending the current interval while overlap exists.
