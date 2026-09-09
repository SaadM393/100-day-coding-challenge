# Day 07 - Product of Array Except Self

📅 Date: 9 September 2026

## Problem

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all elements of `nums` except `nums[i]`.

The solution must run in O(N) time and should not use division.

## Example Input

```text
nums = [1, 2, 3, 4]
```

## Example Output

```text
[24, 12, 8, 6]
```

## Explanation

- For index 0: `2 × 3 × 4 = 24`
- For index 1: `1 × 3 × 4 = 12`
- For index 2: `1 × 2 × 4 = 8`
- For index 3: `1 × 2 × 3 = 6`

## Approach

For every index, the answer is:

```text
(product of all elements on the left) × (product of all elements on the right)
```

1. In the first pass, store the prefix product in `result[i]`.
2. In the second pass from right to left, multiply `result[i]` by the suffix product.
3. This handles zero values naturally and avoids division.

## Java Solution

See `ProductOfArrayExceptSelf.java`.

## Time Complexity

`O(N)` because the array is traversed twice.

## Space Complexity

`O(1)` extra space excluding the output array.

## Key Learning / Pattern

- Prefix and suffix products
- Space optimization
- Two-pass array technique
- Handling zero values without division

## Problem Reference

LeetCode 238 - Product of Array Except Self

## Status

✅ Day 07 Completed
