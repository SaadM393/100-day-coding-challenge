# Day 14 - Clone Graph

## Problem Title
Clone Graph (LeetCode 133)

## Problem Statement
Given a reference to a node in a connected undirected graph, return a deep copy of the graph.

Each node contains an integer value and a list of neighboring nodes. The graph may contain cycles, so every original node must be copied exactly once and all neighbor relationships must be preserved.

## Example Input
```text
1 -- 2
|    |
4 -- 3

Starting node = 1
```

## Example Output
```text
A deep copy of the same graph:
1 -- 2
|    |
4 -- 3
```

## Explanation
The graph contains a cycle. While cloning node `1`, we may reach node `2`, then `3`, then `4`, and finally return to node `1` again.

A `HashMap` stores the cloned version of every node already visited. Before recursively cloning a node, we check the map. If the node has already been cloned, we reuse the existing copy instead of creating another one. This prevents infinite recursion and keeps the graph structure correct.

## Approach
1. If the starting node is `null`, return `null`.
2. Create a `HashMap<Node, Node>` where each original node maps to its clone.
3. Clone the current node and immediately store it in the map.
4. Recursively clone every neighbor and add the cloned neighbor to the current clone's neighbor list.
5. If a node appears again because of a cycle, return the already-created clone from the map.

This is depth-first search on a graph with a visited/cloned map.

## Java Solution
See [`CloneGraph.java`](./CloneGraph.java).

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> clonedNodes = new HashMap<>();
        return cloneDfs(node, clonedNodes);
    }

    private Node cloneDfs(Node current, Map<Node, Node> clonedNodes) {
        if (clonedNodes.containsKey(current)) {
            return clonedNodes.get(current);
        }

        Node copy = new Node(current.val);
        clonedNodes.put(current, copy);

        for (Node neighbor : current.neighbors) {
            copy.neighbors.add(cloneDfs(neighbor, clonedNodes));
        }

        return copy;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
```

## Time Complexity
`O(V + E)` where `V` is the number of graph nodes and `E` is the number of edges. Every node and edge is processed once.

## Space Complexity
`O(V)` for the cloned-node map and the recursion stack in the worst case, excluding the returned cloned graph.

## Key Learning / Pattern
- Graph traversal using DFS
- Handling cycles with a visited map
- Deep copying linked structures
- Create and store a node before exploring its neighbors
- Reuse already-cloned nodes to preserve graph relationships
