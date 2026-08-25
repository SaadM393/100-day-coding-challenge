# Day 01 - Permutations

📅 Date: 25 August 2026

## Problem

Generate all possible permutations of an array of distinct integers.

## Example

Input:
[1, 2, 3]

Output:
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]

## Approach

I used recursion and backtracking. At every step, I choose one element from the remaining list, add it to the current permutation, remove it from the remaining elements, and recursively generate the rest. When no elements remain, the completed permutation is stored.

## Concepts Learned

- Recursion
- Backtracking
- ArrayList
- List manipulation
- State management

## Complexity

Time Complexity: O(N × N!)

Space Complexity: O(N × N!)

## Language

Java

## Status

✅ Day 01 Completed
