# Day 04 - First and Last Position of Element in Sorted Array

📅 Date: 6 September 2026

## Problem

Given a sorted array of integers, find the starting and ending position of a given target value.

Return `[-1, -1]` if the target does not exist.

## Example Input

```text
numbers = [5, 7, 7, 8, 8, 10]
target = 8
```

## Example Output

```text
[3, 4]
```

## Explanation

The target `8` first appears at index `3` and last appears at index `4`.

## Approach

A normal binary search can find one occurrence, but duplicate values may appear on both sides. Therefore, use binary search twice:

1. `findFirst` keeps searching to the left after finding the target.
2. `findLast` keeps searching to the right after finding the target.
3. Return both indices as the answer.

The array is sorted, so every search discards half of the remaining elements.

## Java Solution

The solution is implemented in `FirstAndLastPosition.java`.

## Time Complexity

`O(log N)` because two binary searches are performed.

## Space Complexity

`O(1)` auxiliary space.

## Key Learning / Pattern

- Binary search on a sorted array
- Finding the first and last occurrence of a duplicate value
- Boundary-based binary search
- Safe midpoint calculation: `left + (right - left) / 2`

## Edge Cases Covered

- Target is absent
- Target appears once
- Target appears at the beginning
- Target appears at the end
- All elements are equal
- Empty array

## Problem Reference

LeetCode 34 - Find First and Last Position of Element in Sorted Array

## Status

✅ Day 04 Completed
