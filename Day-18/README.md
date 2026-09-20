# Day 18 - Minimum Window Substring

## Problem Title
Minimum Window Substring (LeetCode 76)

## Problem Statement
Given two strings `s` and `t`, return the shortest substring of `s` that contains every character from `t`, including duplicate characters. If no such substring exists, return an empty string.

## Example Input
```text
s = "ADOBECODEBANC"
t = "ABC"
```

## Example Output
```text
"BANC"
```

## Explanation
The substring `BANC` contains `A`, `B`, and `C`, and it is the smallest valid window in `s`.

## Approach
1. Count how many times each character is required in `t`.
2. Expand a sliding window using the `right` pointer.
3. Track character frequencies inside the current window.
4. Once the window contains all required characters, move the `left` pointer forward to remove unnecessary characters.
5. Store the shortest valid window found.

The window is expanded until it becomes valid, then contracted while it remains valid. This guarantees that every possible useful window is considered efficiently.

## Java Solution Reference
See [`MinimumWindowSubstring.java`](./MinimumWindowSubstring.java).

## Time Complexity
`O(|s| + |t|)`

Each character is added to and removed from the sliding window at most once.

## Space Complexity
`O(|s| + |t|)` in the general case for the frequency maps.

## Key Learning / Pattern
**Sliding Window with Frequency Counting**

This pattern is useful when a problem asks for the smallest or largest subarray/substring satisfying a frequency, coverage, or constraint condition.
