# Day 25 - Course Schedule

## Problem Title

**Course Schedule (LeetCode 207)**

## Problem Statement

There are `numberOfCourses` courses labeled from `0` to `numberOfCourses - 1`.

A prerequisite pair `[course, requiredCourse]` means that you must complete `requiredCourse` before taking `course`.

Return `true` if it is possible to finish every course. Return `false` when the prerequisite relationships contain a cycle.

## Example Input

```
numberOfCourses = 2
prerequisites = [[1,0]]
```

## Example Output

```
true
```

## Explanation

Course `0` must be completed before course `1`, so the order `0 -> 1` is valid.

For a cyclic example:

```
numberOfCourses = 2
prerequisites = [[1,0],[0,1]]
```

neither course can be completed first, so the answer is `false`.

## Approach

1. Model the courses as a directed graph.
2. For every prerequisite `[course, requiredCourse]`, add an edge from `requiredCourse` to `course`.
3. Store the indegree of every course, which is the number of prerequisites still remaining.
4. Add all courses with indegree `0` to a queue.
5. Repeatedly remove a ready course, count it as completed, and reduce the indegree of its dependent courses.
6. If a dependent course reaches indegree `0`, add it to the queue.
7. If all courses are processed, the graph has no cycle and all courses can be finished. Otherwise, a cycle exists.

This is Kahn's topological sort algorithm.

## Java Solution Reference

See [CourseSchedule.java](./CourseSchedule.java) in this folder.

## Time Complexity

`O(V + E)`, where `V` is the number of courses and `E` is the number of prerequisite pairs.

## Space Complexity

`O(V + E)` for the graph, indegree array, and queue.

## Key Learning / Pattern

**Graph Cycle Detection using Topological Sort (BFS).**

A directed graph can be completed in dependency order only when it is a DAG (Directed Acyclic Graph). Counting processed nodes lets us detect whether a cycle blocks the schedule.
