# Day 02 - Valid Parentheses

📅 Date: 26 August 2026

## Problem

Given a string containing `(`, `)`, `{`, `}`, `[` and `]`, determine whether the input string has valid matching brackets.

## Examples

### Example 1
Input:
```text
()
```
Output:
```text
true
```

### Example 2
Input:
```text
()[]{ }
```
Output:
```text
true
```

### Example 3
Input:
```text
(]
```
Output:
```text
false
```

## Approach

I used a Stack because brackets must close in the reverse order in which they open.

1. Push every opening bracket onto the stack.
2. When a closing bracket appears, check whether the stack is empty.
3. Pop the top opening bracket and verify that it matches the closing bracket.
4. If any pair does not match, return `false`.
5. At the end, the stack must be empty for the string to be valid.

## Concepts Learned

- Stack
- LIFO (Last In, First Out)
- Matching brackets
- String traversal
- Conditional logic

## Complexity

Time Complexity: O(N)

Space Complexity: O(N)

## Language

Java

## Problem Reference

LeetCode 20 - Valid Parentheses

## Status

✅ Day 02 Completed
