# Day 10 - Linked List Cycle

## Problem

Given the head of a linked list, determine whether the linked list contains a cycle. A cycle exists when some node can be reached again by continuously following the `next` pointer.

## Example Input

```text
head = [3, 2, 0, -4], tail connects to index 1
```

## Example Output

```text
true
```

## Explanation

The last node points back to the node containing `2`, so the linked list never ends and contains a cycle.

## Approach

Use Floyd's Cycle Detection Algorithm with two pointers:

- `slow` moves one node at a time.
- `fast` moves two nodes at a time.
- If there is a cycle, both pointers will eventually meet.
- If `fast` reaches `null`, the list has no cycle.

This approach does not require extra memory such as a HashSet.

## Java Solution

See `LinkedListCycle.java`.

## Time Complexity

`O(N)` where `N` is the number of nodes visited.

## Space Complexity

`O(1)` extra space.

## Key Learning / Pattern

**Fast and slow pointers (Floyd's Cycle Detection)** is a fundamental linked-list pattern used for cycle detection and related problems such as finding the middle node and locating the cycle entry.

## Problem Reference

LeetCode 141 - Linked List Cycle

## Status

Completed
