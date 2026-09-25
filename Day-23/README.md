# Day 23 - Word Break

## Problem Title

**Word Break (LeetCode 139)**

## Problem Statement

Given a string `text` and a list of words `dictionary`, return `true` if `text` can be split into one or more dictionary words.

A dictionary word may be used multiple times.

## Example Input

```text
text = "leetcode"
dictionary = ["leet", "code"]
```

## Example Output

```text
true
```

## Explanation

The string can be split as `"leet" + "code"`, and both parts appear in the dictionary.

## Approach

Use bottom-up dynamic programming.

- `canBreak[i]` tells whether the prefix `text.substring(0, i)` can be formed from dictionary words.
- `canBreak[0] = true` because an empty prefix needs no words.
- For every ending position `end`, try every earlier split position `start`.
- If the prefix before `start` can be formed and `text.substring(start, end)` is in the dictionary, mark `canBreak[end]` as `true`.
- The final answer is `canBreak[text.length()]`.

A `HashSet` gives average O(1) dictionary lookup.

## Java Solution Reference

See [`WordBreak.java`](./WordBreak.java).

## Time Complexity

`O(N^2)` average time, where `N` is the length of `text`. HashSet lookups are average O(1); substring creation may add implementation-dependent overhead.

## Space Complexity

`O(N + D)`, where `D` is the total number of distinct dictionary words stored in the HashSet.

## Key Learning / Pattern

**Dynamic Programming on prefixes**

This problem teaches how to decide whether a string prefix is reachable from smaller valid prefixes. It is a common interview pattern for string segmentation, parsing, and break-point DP.
