# Day 12 - Number of Islands

## Problem Statement

Given a 2D grid containing `'1'` for land and `'0'` for water, count the number of islands. An island is formed by connected land cells connected horizontally or vertically. Diagonal cells are not considered connected.

## Example Input

```text
[
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
```

## Example Output

```text
3
```

## Explanation

There are three separate groups of connected land cells, so the answer is `3`.

## Approach

Use Breadth-First Search (BFS):

1. Traverse every cell in the grid.
2. When an unvisited land cell (`'1'`) is found, increment the island count.
3. Start BFS from that cell and visit all connected land cells.
4. Mark visited land cells as water (`'0'`) so they are not counted again.
5. Continue until the complete grid has been processed.

The four possible moves from each cell are up, down, left, and right.

## Java Solution

See [`NumberOfIslands.java`](./NumberOfIslands.java).

## Time Complexity

`O(rows × columns)` because each cell is visited at most once.

## Space Complexity

`O(rows × columns)` in the worst case for the BFS queue.

## Key Learning / Pattern

- Grid traversal
- Breadth-First Search (BFS)
- Connected components
- Visited-state marking
- Boundary checking

## Placement Value

This is a classic graph and grid problem that tests traversal, queue usage, connected-component counting, and careful edge-case handling.
