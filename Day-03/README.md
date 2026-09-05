# Day 03 - Two Sum

📅 Date: 27 August 2026

## Problem

Given an array of integers `nums` and an integer `target`, return the indices of two numbers such that they add up to the target.

## Example

Input:
```text
nums = [2, 7, 11, 15]
target = 9
```

Output:
```text
[0, 1]
```

Because:
```text
nums[0] + nums[1] = 2 + 7 = 9
```

## Approach

I used a HashMap to store numbers that have already been visited along with their indices.

For every number:

1. Calculate the required complement:
   `target - nums[i]`
2. Check whether that complement already exists in the HashMap.
3. If it exists, return the stored index and the current index.
4. Otherwise, store the current number and its index.

This avoids using two nested loops.

## Concepts Learned

- HashMap
- Arrays
- Time optimization
- Complement technique
- One-pass solution

## Complexity

Time Complexity: O(N)

Space Complexity: O(N)

## Language

Java

## Problem Reference

LeetCode 1 - Two Sum

## Status

✅ Day 03 Completed
