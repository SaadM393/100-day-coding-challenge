# Day 05 - Merge Intervals

📅 Date: 7 September 2026

## Problem

Given an array of intervals where `intervals[i] = [start, end]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

## Example Input

```text
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

## Example Output

```text
[[1,6],[8,10],[15,18]]
```

## Explanation

The intervals `[1,3]` and `[2,6]` overlap, so they are merged into `[1,6]`. The other intervals do not overlap with this merged interval.

## Approach

1. Sort all intervals by their starting point.
2. Keep track of the current interval being built.
3. For each next interval:
   - If its start is less than or equal to the current end, the intervals overlap. Extend the current end using the larger end value.
   - Otherwise, store the current interval and start a new one.
4. Add the final current interval to the result.

Sorting makes overlapping intervals appear next to each other, which allows a single linear scan after sorting.

## Java Solution

See `MergeIntervals.java` in this folder.

## Time Complexity

- Sorting: `O(N log N)`
- Scanning: `O(N)`
- Overall: `O(N log N)`

## Space Complexity

`O(N)` for the output list. The sorting implementation may use additional stack space.

## Key Learning / Pattern

- Sorting + Greedy traversal
- Interval merging
- Maintaining a current range while scanning
- A common pattern used in scheduling and meeting-room problems

## Edge Cases

- Empty input array
- A single interval
- Intervals that only touch, such as `[1,4]` and `[4,5]`
- One interval completely containing another

## Problem Reference

LeetCode 56 - Merge Intervals

## Status

✅ Day 05 Completed
