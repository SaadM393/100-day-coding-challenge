# Day 20 - Product of Array Except Self

## Problem Title
Product of Array Except Self (LeetCode 238)

## Problem Statement
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all elements of `nums` except `nums[i]`.

The solution must run in `O(N)` time and must not use division.

## Example Input
```text
nums = [1, 2, 3, 4]
```

## Example Output
```text
[24, 12, 8, 6]
```

## Explanation
For each index, multiply all values to its left and all values to its right:

- Index 0: `2 × 3 × 4 = 24`
- Index 1: `1 × 3 × 4 = 12`
- Index 2: `1 × 2 × 4 = 8`
- Index 3: `1 × 2 × 3 = 6`

## Approach
1. Store the product of all elements to the left of each index in `result`.
2. Traverse from right to left while maintaining the product of elements to the right.
3. Multiply the left product already stored in `result[i]` by the current suffix product.
4. This handles zero values naturally and does not use division.

## Java Solution Reference
See [`ProductOfArrayExceptSelf.java`](./ProductOfArrayExceptSelf.java).

## Time Complexity
`O(N)` time.

There are two linear passes through the array.

## Space Complexity
`O(1)` auxiliary space, excluding the returned output array.

## Key Learning / Pattern
**Prefix Product + Suffix Product**

When each answer depends on everything before and after an index, prefix/suffix accumulation can solve the problem in linear time without nested loops or division.
