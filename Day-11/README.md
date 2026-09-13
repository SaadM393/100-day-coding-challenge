# Day 11 - Binary Tree Level Order Traversal

## Problem

Given the root of a binary tree, return the values of its nodes level by level from left to right.

## Example Input

```text
root = [3, 9, 20, null, null, 15, 7]
```

## Example Output

```text
[[3], [9, 20], [15, 7]]
```

## Explanation

- Level 1 contains `3`.
- Level 2 contains `9` and `20`.
- Level 3 contains `15` and `7`.

## Approach

Use Breadth-First Search (BFS) with a queue.

1. Add the root node to the queue.
2. At the start of each loop, store the current queue size. This is the number of nodes in the current level.
3. Remove exactly that many nodes, add their values to a list, and insert their non-null children into the queue.
4. Add the completed level to the result.
5. Repeat until the queue becomes empty.

## Java Solution

See `BinaryTreeLevelOrderTraversal.java`.

## Time Complexity

`O(N)` because every node is visited once.

## Space Complexity

`O(N)` for the queue and the output list. The queue can contain nodes from one or more levels in the worst case.

## Key Learning / Pattern

**Breadth-First Search (BFS) using a queue** is the standard pattern for level-wise tree traversal. The `queue.size()` technique helps separate one level from the next.

## Problem Reference

LeetCode 102 - Binary Tree Level Order Traversal

## Status

Completed
