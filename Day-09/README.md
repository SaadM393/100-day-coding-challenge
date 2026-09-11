# Day 09 - Three Sum

## Problem

Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:

```text
nums[i] + nums[j] + nums[k] = 0
```

The solution must not contain duplicate triplets.

## Example Input

```text
nums = [-1, 0, 1, 2, -1, -4]
```

## Example Output

```text
[[-1, -1, 2], [-1, 0, 1]]
```

## Explanation

First, sort the array. Then fix one element at a time and use two pointers for the remaining part of the array:

- `left` starts just after the fixed element.
- `right` starts at the end of the array.
- If the sum is too small, move `left` forward.
- If the sum is too large, move `right` backward.
- When the sum is zero, store the triplet and skip duplicate values.

Sorting makes duplicate handling possible and allows the two-pointer decisions to work correctly.

## Approach

1. Sort `nums`.
2. Loop through each possible first element.
3. Skip the same first element when it repeats.
4. Search for the other two elements using two pointers.
5. After finding a valid triplet, move both pointers and skip duplicates.

## Java Solution

See `ThreeSum.java`.

## Time Complexity

`O(N^2)` because the outer loop runs `N` times and the two-pointer scan takes `O(N)` for each fixed element.

## Space Complexity

`O(1)` auxiliary space, excluding the list used to store the answer. The sorting operation may use implementation-dependent stack space.

## Key Learning / Pattern

- Sorting + Two Pointers
- Duplicate elimination
- Reducing a 3-number search to repeated 2-number searches
- A common interview pattern for array problems

## Problem Reference

LeetCode 15 - 3Sum

## Status

✅ Day 09 Completed
