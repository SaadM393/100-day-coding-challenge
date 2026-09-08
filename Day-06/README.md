# Day 06 - Longest Substring Without Repeating Characters

📅 Date: 08 September 2026

## Problem

Given a string, find the length of the longest substring that contains no repeated characters.

## Example Input

```text
s = "abcabcbb"
```

## Example Output

```text
3
```

The longest substring without repeating characters is `"abc"`.

## Explanation

We maintain a sliding window from `left` to `right` that always contains unique characters. A HashMap stores the most recent index of every character.

When a repeated character is found, move `left` to one position after its previous index. The `Math.max` check prevents `left` from moving backward.

After each step, update the maximum window length.

## Approach

1. Start two pointers: `left = 0` and `right = 0`.
2. Traverse the string with `right`.
3. If the current character was seen inside the current window, move `left` forward.
4. Store the current character's latest index.
5. Update the maximum length of the current window.

## Java Solution

See `LongestSubstringWithoutRepeatingCharacters.java`.

## Time Complexity

`O(N)`, because each character is processed a constant number of times.

## Space Complexity

`O(K)`, where `K` is the number of distinct characters stored in the HashMap. In the worst case, this is `O(N)`.

## Key Learning / Pattern

- Sliding Window
- Two Pointers
- HashMap for last seen positions
- Efficient duplicate handling

## Problem Reference

LeetCode 3 - Longest Substring Without Repeating Characters

## Status

✅ Day 06 Completed
