# Day 13 - Course Schedule

## Problem Title
Course Schedule (LeetCode 207)

## Problem Statement
There are `numberOfCourses` courses labeled from `0` to `numberOfCourses - 1`. Some courses have prerequisites. A prerequisite pair `[course, requiredCourse]` means you must complete `requiredCourse` before taking `course`.

Return `true` if it is possible to finish all courses. Otherwise, return `false`.

## Example Input
```text
numberOfCourses = 2
prerequisites = [[1, 0]]
```

## Example Output
```text
true
```

## Explanation
Course `0` has no prerequisite, so we can complete it first. After that, course `1` becomes available. Therefore, both courses can be completed.

If the prerequisites contain a cycle such as `[[1, 0], [0, 1]]`, no valid order exists and the answer is `false`.

## Approach
We model the courses as a directed graph:

- An edge `requiredCourse -> course` means the required course must come first.
- `indegree[course]` stores how many prerequisites are still pending.
- Put every course with indegree `0` into a queue.
- Repeatedly remove a course from the queue and reduce the indegree of its dependent courses.
- If a dependent course reaches indegree `0`, add it to the queue.
- If we process all courses, there is no cycle. Otherwise, a cycle prevents completion.

This is **Kahn's Algorithm for Topological Sorting**.

## Java Solution
See [`CourseSchedule.java`](./CourseSchedule.java).

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numberOfCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numberOfCourses];

        for (int course = 0; course < numberOfCourses; course++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];

            graph.get(requiredCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numberOfCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;

            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completedCourses == numberOfCourses;
    }
}
```

## Time Complexity
`O(V + E)` where `V` is the number of courses and `E` is the number of prerequisite pairs.

## Space Complexity
`O(V + E)` for the graph, indegree array, and queue.

## Key Learning / Pattern
- Topological sorting of a directed graph
- Detecting cycles using indegrees
- Kahn's algorithm with BFS
- Converting prerequisite/order problems into graph problems
